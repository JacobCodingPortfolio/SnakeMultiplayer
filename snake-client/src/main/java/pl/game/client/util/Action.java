package pl.game.client.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Region;

import java.util.HashMap;
import java.util.Map;

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

    public static Map<Metric, Double> getRegionSize(Region region){
        Map<Metric, Double> regionMetric = new HashMap<>();
        regionMetric.put(Metric.WIDTH, region.getWidth());
        regionMetric.put(Metric.HEIGHT, region.getHeight());
        return regionMetric;
    }

    public static Object getFxmlNode(FXMLLoader loader, String key){
        return loader.getNamespace().get(key);
    }

}
