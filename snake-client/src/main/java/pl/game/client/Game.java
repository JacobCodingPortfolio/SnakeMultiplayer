package pl.game.client;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author JNartowicz
 */
public class Game {

    private static Game gameInstance;
    private Stage primaryStage;
    private Scene primaryScene;
    private BorderPane gameContent;
    private Thread resizerRefresher;
    private Resizer resizer;


    private Game(Stage primaryStage){
        this.primaryStage = primaryStage;
        buildGame();
        initializeBehaviour();
        propertySceneSize();
    }

    private void buildGame() {
        this.gameContent = new BorderPane();
        this.primaryScene = new Scene(this.gameContent);
        this.primaryStage.setScene(this.primaryScene);
        this.primaryStage.sizeToScene();
        this.primaryStage.show();
    }

    private void initializeBehaviour() {
        //refreshThreadInitialize();
    }

    private void propertySceneSize() {
        //To działa poprawnie :)
        this.primaryScene.widthProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Szerokość się zmieniła - " + " stara: " + String.valueOf(oldValue.doubleValue()) + ", nowa: " + String.valueOf(newValue.doubleValue()));
        });
        this.primaryScene.heightProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Wysokość się zmieniła - " + " stara: " + String.valueOf(oldValue.doubleValue()) + ", nowa: " + String.valueOf(newValue.doubleValue()));
        });
    }

    private void refreshThreadInitialize() {
        resizer = new Resizer();
        resizerRefresher = new Thread(resizer);
        resizerRefresher.start();
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

    public Thread getResizerRefresher() {
        return resizerRefresher;
    }

    public Resizer getResizer() {
        return resizer;
    }
}
