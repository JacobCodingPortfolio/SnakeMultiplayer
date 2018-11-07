package pl.game.client;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.game.client.component.Header;
import pl.game.client.util.Const;
import pl.game.client.util.Logger;
import pl.game.client.util.Metric;
import sun.rmi.runtime.Log;

import java.util.Map;

/**
 * @author JNartowicz
 */
public class Game {

    private double actualSceneHeight; //TODO - dobrać domyślne wartości.
    private double actualSceneWidth;

    private static Game gameInstance;
    private Stage primaryStage;
    private Scene primaryScene;
    private BorderPane gameContent;
    private Header header;


    private Game(Stage primaryStage){
        this.primaryStage = primaryStage;
        buildGame();
        initializeBehaviour();
        propertySceneSize();
    }

    private void buildGame() {
        this.gameContent = new BorderPane();
        this.header = new Header();
        this.gameContent.setTop(this.header);
        this.primaryScene = new Scene(this.gameContent);
        this.primaryStage.setScene(this.primaryScene);
        this.primaryStage.sizeToScene();
        this.primaryStage.show();
    }

    private void initializeBehaviour() {
    }

    private void propertySceneSize() {
        this.primaryScene.widthProperty().addListener((observable, oldValue, newValue) -> {
            this.actualSceneWidth = newValue.doubleValue();
            this.changeComponentSize();
        });
        this.primaryScene.heightProperty().addListener((observable, oldValue, newValue) -> {
            this.actualSceneHeight = newValue.doubleValue();
            this.changeComponentSize();
        });
    }

    private void changeComponentSize() {
        //TODO - maybe I can do it better :)
        Map<Metric, Double> size = this.header.setSize(this.actualSceneWidth, Const.HEADER_HEIGHT);
        Logger.log(String.valueOf(size.get(Metric.HEIGHT)));
        Logger.log(String.valueOf(size.get(Metric.WIDTH)));
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

}
