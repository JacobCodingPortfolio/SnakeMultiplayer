package pl.game.client.component;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import pl.game.client.annotation.FxmlComponent;
import pl.game.client.util.Action;
import pl.game.client.util.Const;
import pl.game.client.util.Logger;
import pl.game.client.util.Metric;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is helper for Game Application.
 * Must be extended by classes with the name like FXML files in Java resources.
 * Abstract class provide to load controls from FXML file.
 * Controls in extended class must have name like controls on FXML file.
 * Keep on track on this instruction. It will help you to use this class correctly.
 *
 *
 * @author JNartowicz
 */
public abstract class AbstractNode extends AnchorPane {

    private FXMLLoader fxmlLoader;
    private AnchorPane paneContainer;


    public AbstractNode() {
        this.fxmlLoader = new FXMLLoader(getClass().getResource(Const.SLASH + Const.RESOURCE_NODE_FOLDER + Const.SLASH + this.getClass().getSimpleName() + Const.FXML_EXTENSION));
        try {
            this.paneContainer = fxmlLoader.load();
        } catch (IOException e) {
            Logger.log("Fail while Abstract component try to load FXML file.");
            e.printStackTrace();
        }
        this.getChildren().add(this.paneContainer); //Add node to parent anchor pane.
        this.loadControls();
    }

    /**
     * Load controls annotated by @FxmlComponent
     * Name control in FXML must be tha same like variables names in Java class.
     */
    private void loadControls(){
        Field[] classFields = this.getClass().getDeclaredFields();
        for(Field field: classFields){
            if(field.isAnnotationPresent(FxmlComponent.class)){
                field.setAccessible(true);
                try {
                    field.set(this, Action.getFxmlNode(this.fxmlLoader, field.getName()));
                } catch (IllegalAccessException e) {
                    Logger.log("Fail while read FXML controls.");
                    e.printStackTrace();
                }
            }
        }
    }

    public Map<Metric, Double> setSize(double width, double height){
        Action.changeRegionSize(this, width, height);
        Map<Metric, Double> metricDoubleMap = new HashMap<>();
        metricDoubleMap.put(Metric.WIDTH, this.getWidth());
        metricDoubleMap.put(Metric.HEIGHT, this.getHeight());
        return metricDoubleMap;
    }

}
