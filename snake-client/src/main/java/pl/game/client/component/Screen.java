package pl.game.client.component;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pl.game.client.Game;
import pl.game.client.annotation.FxmlComponent;
import pl.game.client.util.Action;
import pl.game.client.util.Const;
import pl.game.client.util.Logger;

import java.awt.*;


/**
 * @author JNartowicz
 */
public class Screen extends AbstractNode{

    @FxmlComponent
    private VBox screenVboxContentDecorator;

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

        Action.changeRegionSize(screenVboxContentDecorator, parentWidth, parentHeight);
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
        setBehaviour();
    }

    private void setBehaviour() {
        //This piece of code hide scroll bars on scroll pane
        this.screenScrollCenterCanvasPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.screenScrollCenterCanvasPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.screenScrollCenterCanvasPane.setOnKeyPressed(keyEvent -> Game.getGameInstance().handleScrollPaneKeyEvent(keyEvent));
        this.initializeGameScreen();
    }

    private void initializeGameScreen() {
        this.buildGameFrame();
    }

    /**
     * This method build a frame in game screen.
     * While a snake touch this frame the game for him will be end.
     * In the future I would like to develop game and make some bonuses.
     * One of them provide invisible frame. It will be works
     * that when snake hit the frame I will not be the game but the snake
     * appear on the other side.
     */
    private void buildGameFrame() {
        GraphicsContext context = this.getScreenCanvas().getGraphicsContext2D();
        PixelWriter pixelWriter = context.getPixelWriter();
        for(int i=1; i<=Const.CANVAS_WIDTH_INT; i++){
            pixelWriter.setColor(i,1, Const.GAME_FRAME_COLOR);
            pixelWriter.setColor(i,Const.CANVAS_HEIGHT_INT - 1, Const.GAME_FRAME_COLOR);
        }
        for(int j=2; j<Const.CANVAS_HEIGHT_INT; j++){
            pixelWriter.setColor(1, j, Const.GAME_FRAME_COLOR);
            pixelWriter.setColor(Const.CANVAS_WIDTH_INT - 1, j, Const.GAME_FRAME_COLOR);
        }
    }

    public VBox getScreenVboxContentDecorator() {
        return screenVboxContentDecorator;
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
