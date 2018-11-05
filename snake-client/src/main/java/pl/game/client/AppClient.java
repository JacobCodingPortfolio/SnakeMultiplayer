package pl.game.client;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author JNartowicz
 */
public class AppClient extends Application {
    public void start(Stage primaryStage) throws Exception {
        Game.startGame(primaryStage);
    }
}
