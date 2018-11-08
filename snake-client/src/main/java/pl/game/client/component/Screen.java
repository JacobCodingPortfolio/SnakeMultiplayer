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

        double centerGridWidth;
        double centerGridHeight;

        double widthForScreen = parentWidth  - Const.SCROLL_PANE_NO_BAR_TOLERANT;
        double heightForScreen = (parentHeight - Const.INFO_BAR_HEIGHT) - Const.SCROLL_PANE_NO_BAR_TOLERANT;



        if(widthForScreen <  Const.GRID_SCREEN_CANVAS_WIDTH){
            centerGridWidth = Const.GRID_SCREEN_CANVAS_WIDTH;
        } else {
            centerGridWidth = widthForScreen;
        }

        if(heightForScreen <  Const.GRID_SCREEN_CANVAS_HEIGHT){
            centerGridHeight = Const.GRID_SCREEN_CANVAS_HEIGHT;
        } else {
            centerGridHeight = heightForScreen;
        }

        Action.changeRegionSize(screenGridCenterCanvas, centerGridWidth, centerGridHeight);
        Action.changeCanvasSize(screenCanvas, Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT); //Set canvas to default

        GraphicsContext graphicsContext = screenCanvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(0, 0, Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        graphicsContext.fill();

    }

    @Override
    public void buildComponent() {

    }
}
