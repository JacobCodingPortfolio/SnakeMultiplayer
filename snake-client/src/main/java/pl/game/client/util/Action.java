package pl.game.client.util;

import javafx.fxml.FXMLLoader;
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

    public static Object getFxmlNode(FXMLLoader loader, String key){
        return loader.getNamespace().get(key);
    }

}
