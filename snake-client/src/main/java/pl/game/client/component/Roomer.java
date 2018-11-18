package pl.game.client.component;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.game.client.annotation.FxmlComponent;
import pl.game.client.util.Action;
import pl.game.common.model.Table;
import pl.game.common.model.User;

/**
 * @author JNartowicz
 */
public class Roomer extends AbstractNode{

    @FxmlComponent
    private TableView<User> gameUsers;
    @FxmlComponent
    private TableView<Table> gameTables;
    @FxmlComponent
    private ScrollPane infoPane;
    @FxmlComponent
    private Button startGame;

    @Override
    public void changeSizeComponents(double parentWidth, double parentHeight) {

        Double parentWidthObjectively = parentWidth;
        Double parentHeightObjectively = parentHeight;

        Integer widthInfoPaneConstruct = parentWidthObjectively.intValue();
        Integer widthInfoPaneFinal = widthInfoPaneConstruct / 2;
        Integer widthTables = widthInfoPaneConstruct - widthInfoPaneFinal;

        Integer heightGameUsersConstruct = parentHeightObjectively.intValue();
        Integer heightGameUsersFinal = heightGameUsersConstruct / 2;
        Integer heightGameTables = heightGameUsersConstruct - heightGameUsersFinal;

        Action.changeRegionSize(infoPane, widthInfoPaneFinal.doubleValue(), parentHeight);
        Action.changeRegionSize(gameUsers, widthTables.doubleValue(), heightGameUsersFinal.doubleValue());
        Action.changeRegionSize(gameTables, widthTables.doubleValue(), heightGameTables.doubleValue());

        Action.changeRegionCoordinates(infoPane, widthTables.doubleValue(), 0.0);
        Action.changeRegionCoordinates(gameUsers, 0.0, 0.0);
        Action.changeRegionCoordinates(gameTables, 0.0, heightGameTables.doubleValue());

    }

    @Override
    public void buildComponent() {
        TableColumn userNickColumn = new TableColumn("Nick");
        userNickColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        gameUsers.getColumns().add(userNickColumn);
        TableColumn tableNameColumn = new TableColumn("Name");
        tableNameColumn.setCellFactory(new PropertyValueFactory<>("tableName"));
        gameTables.getColumns().add(tableNameColumn);
    }

    public TableView<User> getGameUsers() {
        return gameUsers;
    }

    public TableView<Table> getGameTables() {
        return gameTables;
    }
}
