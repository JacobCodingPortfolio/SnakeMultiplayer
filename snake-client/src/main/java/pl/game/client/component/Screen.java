package pl.game.client.component;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import pl.game.client.annotation.FxmlComponent;
import pl.game.client.util.Action;
import pl.game.client.util.Const;
import pl.game.client.util.Logger;
import pl.game.client.util.Metric;

import java.util.Map;


/**
 * @author JNartowicz
 */
public class Screen extends AbstractNode{

    @FxmlComponent
    private VBox screenVboxConentDecorator;

    @FxmlComponent
    private AnchorPane screenInfoBar;

    @FxmlComponent
    private ScrollPane screenScrollCenterCanvasPane;

    @FxmlComponent
    private GridPane screenGridCenterCanvas;

    @FxmlComponent
    private Canvas screenCanvas;

    @Override
    public void changeSizeComponents(double parentWidth, double parentHeight) {

        Action.changeRegionSize(screenVboxConentDecorator, parentWidth, parentHeight);
        Action.changeRegionSize(screenInfoBar, parentWidth, Const.INFO_BAR_HEIGHT);
        Action.changeRegionSize(screenScrollCenterCanvasPane, parentWidth, parentHeight - Const.INFO_BAR_HEIGHT);
        Map<Metric, Double> metricsScreenScrollPane = Action.getRegionSize(screenScrollCenterCanvasPane);

        double centerGridWidth;
        double centerGridHeight;

        if(metricsScreenScrollPane.get(Metric.WIDTH) <  Const.CANVAS_WIDTH){
            centerGridWidth = Const.CANVAS_WIDTH;
        } else {
            centerGridWidth = metricsScreenScrollPane.get(Metric.WIDTH);
        }

        if(metricsScreenScrollPane.get(Metric.HEIGHT) <  Const.CANVAS_HEIGHT){
            centerGridHeight = Const.CANVAS_HEIGHT;
        } else {
            centerGridHeight = metricsScreenScrollPane.get(Metric.HEIGHT);
        }

        Action.changeRegionSize(screenGridCenterCanvas, centerGridWidth, centerGridHeight);
        Action.changeCanvasSize(screenCanvas, Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT); //Set canvas to default
        
    }

    @Override
    public void buildComponent() {

    }
}
