package pl.game.client;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @author JNartowicz
 */
public class Game {

    private static Game gameInstance;

    private Stage primaryStage;
    private Scene primaryScene;
    private AnchorPane gameContent;

    private Game(Stage primaryStage){
        this.primaryStage = primaryStage;
        buildGame();
    }

    private void buildGame() {

        this.gameContent = new AnchorPane();
        this.primaryScene = new Scene(this.gameContent);
        this.primaryStage.setScene(this.primaryScene);
        this.primaryStage.sizeToScene();
        this.primaryStage.setResizable(false);
        this.primaryStage.show();

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
}
