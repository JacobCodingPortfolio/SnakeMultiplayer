package pl.game.client.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Region;

/**
 * @author JNartowicz
 */
public class Action {

    public static void changeRegionSize(Region region, double width, double height){
        region.setMinSize(width, height);
        region.setPrefSize(width, height);
        region.setMaxSize(width, height);
    }

    public static Class<? extends Node> getFxmlNode(FXMLLoader loader, String key){
        return (Class<? extends Node>) loader.getNamespace().get(key);
    }

}
