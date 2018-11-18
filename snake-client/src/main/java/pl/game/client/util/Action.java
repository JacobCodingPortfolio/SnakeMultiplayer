package pl.game.client.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
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

    public static void changeCanvasSize(Canvas canvas, double width, double height){
        canvas.setWidth(width);
        canvas.setHeight(height);
    }

    public static void changeRegionCoordinates(Region region, double x, double y){
        region.setLayoutX(x);
        region.setLayoutY(y);
    }

    public static double getRegionWidth(Region region){
        return region.getWidth();
    }

    public static double getRegionHeight(Region region){
        return region.getHeight();
    }

    public static Object getFxmlNode(FXMLLoader loader, String key){
        return loader.getNamespace().get(key);
    }

}
