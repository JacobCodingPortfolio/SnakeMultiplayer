package pl.game.client.util;

import javafx.scene.paint.Color;
import pl.game.common.util.Constant;

/**
 * @author JNartowicz
 */
public class Const {
    public static final int REFRESH_RESIZER_INTERVAL_MILISECONDS = 1000;
    public static final int MILIS_IN_SECOND = 1000;
    public static final String RESOURCE_NODE_FOLDER = "node";
    public static final String SLASH = "/";
    public static final String FXML_EXTENSION = ".fxml";
    public static final String LOGGER_ARROW = " ====> ";
    public static final double HEADER_HEIGHT = 60.0;
    public static final double HEADER_HEIGHT_INSIDE = 50.0;
    public static final double MIN_HEADER_WIDTH = 700.0;
    public static final double INITIAL_WIDTH = 1100.0;
    public static final double INITIAL_HEIGHT = 1000.0;
    public static final double INFO_BAR_HEIGHT = 40.0;
    public static final int CANVAS_WIDTH_INT = Constant.GAME_PIXELS_WIDTH; //Parameters defined in the commons dependency
    public static final int CANVAS_HEIGHT_INT = Constant.GAME_PIXELS_HEIGHT;
    public static final double CANVAS_WIDTH = CANVAS_WIDTH_INT;
    public static final double CANVAS_HEIGHT = CANVAS_HEIGHT_INT;
    public static final double SCROLL_PANE_NO_BAR_TOLERANT = 5.0;
    public static final double THICKNESS_FRAME_GRID = 5.0;
    public static final double GRID_SCREEN_CANVAS_WIDTH = (CANVAS_WIDTH + 2 * THICKNESS_FRAME_GRID) * 1.0;
    public static final double GRID_SCREEN_CANVAS_HEIGHT = (CANVAS_HEIGHT + 2 * THICKNESS_FRAME_GRID) * 1.0;
    public static final int BREAK_BETWEEN_KEY_PRESS_REFRESH = 500;
    public static final int FULL_ANGLE = 360;
    public static final int ZERO_ANGLE = 0;
    public static final Color GAME_FRAME_COLOR = Color.LIGHTGOLDENRODYELLOW;

}
