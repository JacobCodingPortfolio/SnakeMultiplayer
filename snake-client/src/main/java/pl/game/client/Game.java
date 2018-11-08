package pl.game.client;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.omg.CORBA.PUBLIC_MEMBER;
import pl.game.client.component.GameArea;
import pl.game.client.component.Header;
import pl.game.client.util.Const;
import pl.game.client.util.Content;
import pl.game.client.util.Logger;
import pl.game.client.util.Metric;
import sun.rmi.runtime.Log;

import java.util.Map;

/**
 * @author JNartowicz
 */
public class Game {

    private static double actualSceneHeight;
    private static double actualSceneWidth;

    private static Game gameInstance;
    private Stage primaryStage;
    private Scene primaryScene;
    private BorderPane gameContent;
    private Header header;
    private GameArea gameArea;

    private Game(Stage primaryStage){
        this.primaryStage = primaryStage;
        buildGame();
        setDefaultSceneSize();
        initializeBehaviour();
        propertySceneSize();
    }

    private void buildGame() {
        this.gameContent = new BorderPane();
        this.header = new Header();
        this.gameArea = new GameArea();
        this.gameContent.setTop(this.header);
        this.gameContent.setCenter(this.gameArea);
        this.primaryScene = new Scene(this.gameContent, Const.INITIAL_WIDTH, Const.INITIAL_HEIGHT);
        this.primaryStage.setScene(this.primaryScene);
        this.primaryStage.sizeToScene();
        this.primaryStage.show();
    }

    private void setDefaultSceneSize() {
        changeComponentSize(Const.INITIAL_WIDTH, Const.INITIAL_HEIGHT);
    }

    private void initializeBehaviour() {
    }

    private void propertySceneSize() {
        this.primaryScene.widthProperty().addListener((observable, oldValue, newValue) -> {
            setActualSceneWidth(newValue.doubleValue());
            this.changeComponentSize(getActualSceneWidth(), getActualSceneHeight());
        });
        this.primaryScene.heightProperty().addListener((observable, oldValue, newValue) -> {
            setActualSceneHeight(newValue.doubleValue());
            this.changeComponentSize(getActualSceneWidth(), getActualSceneHeight());
        });
    }

    private void changeComponentSize(double actualSceneWidth, double actualSceneHeight) {
        //Logger.log("Szerokość scene: " + String.valueOf(actualSceneWidth));
        //Logger.log("Wysokość scene: " + String.valueOf(actualSceneHeight));
        Map<Metric, Double> sizeHeader = this.header.setSize(actualSceneWidth, Const.HEADER_HEIGHT);
        Map<Metric, Double> sizeGameArea = this.gameArea.setSize(actualSceneWidth, actualSceneHeight - Const.HEADER_HEIGHT);
    }

    public static synchronized Game startGame(Stage primaryStage) {
        if(gameInstance == null){
            gameInstance = new Game(primaryStage);
        }
        return gameInstance;
    }

    public static synchronized Game getGameInstance() {
        return gameInstance;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Scene getPrimaryScene() {
        return primaryScene;
    }

    public BorderPane getGameContent() {
        return gameContent;
    }

    public GameArea getGameArea() {
        return gameArea;
    }

    public Header getHeader() {
        return header;
    }

    public synchronized static void setActualSceneHeight(double actualSceneHeight) {
        Game.actualSceneHeight = actualSceneHeight;
    }

    public synchronized static void setActualSceneWidth(double actualSceneWidth) {
        Game.actualSceneWidth = actualSceneWidth;
    }

    public static double getActualSceneHeight() {
        return actualSceneHeight;
    }

    public static double getActualSceneWidth() {
        return actualSceneWidth;
    }
}
