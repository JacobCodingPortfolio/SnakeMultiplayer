package pl.game.client.component;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pl.game.client.annotation.FxmlComponent;
import pl.game.client.util.Action;
import pl.game.client.util.Const;


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

    }

    @Override
    public void buildComponent() {

    }

    public VBox getScreenVboxConentDecorator() {
        return screenVboxConentDecorator;
    }

    public AnchorPane getScreenInfoBar() {
        return screenInfoBar;
    }

    public ScrollPane getScreenScrollCenterCanvasPane() {
        return screenScrollCenterCanvasPane;
    }

    public GridPane getScreenGridCenterCanvas() {
        return screenGridCenterCanvas;
    }

    public Canvas getScreenCanvas() {
        return screenCanvas;
    }
}
