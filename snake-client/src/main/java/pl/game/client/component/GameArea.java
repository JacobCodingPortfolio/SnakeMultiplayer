package pl.game.client.component;

import javafx.scene.layout.AnchorPane;
import pl.game.client.annotation.FxmlComponent;
import pl.game.client.util.Action;

/**
 * @author JNartowicz
 */
public class GameArea extends AbstractNode {

    @FxmlComponent
    private AnchorPane gameAreaMainContent;

    @Override
    public void changeSizeComponents(double parentWidth, double parentHeight) {
        Action.changeRegionSize(gameAreaMainContent, parentWidth, parentHeight);
    }

    public AnchorPane getGameAreaMainContent() {
        return gameAreaMainContent;
    }
}
