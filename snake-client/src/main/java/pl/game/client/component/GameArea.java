package pl.game.client.component;

import javafx.scene.layout.AnchorPane;
import pl.game.client.annotation.FxmlComponent;
import pl.game.client.util.Action;
import pl.game.client.util.Content;
import pl.game.client.util.Logger;

/**
 * @author JNartowicz
 */
public class GameArea extends AbstractNode {

    @FxmlComponent
    private AnchorPane gameAreaMainContent;

    private Screen screen;
    private Roomer roomer;

    @Override
    public void changeSizeComponents(double parentWidth, double parentHeight) {
        Action.changeRegionSize(gameAreaMainContent, parentWidth, parentHeight);
        if(getGameAreaContent() != null){
            getGameAreaContent().changeSizeComponents(parentWidth, parentHeight);
        }
    }

    public AnchorPane getGameAreaMainContent() {
        return gameAreaMainContent;
    }

    public void setGameAreaContent(AbstractNode abstractNode){
        this.gameAreaMainContent.getChildren().removeAll();
        if(abstractNode != null){
            this.gameAreaMainContent.getChildren().add(abstractNode);
        }
    }

    public AbstractNode getGameAreaContent(){
        if(this.gameAreaMainContent.getChildren().size() > 1) {
            Logger.log("Fail while application trying to get game area content.");
        }
        if(this.gameAreaMainContent.getChildren().size() == 0) {
            return null;
        }
        return (AbstractNode) this.gameAreaMainContent.getChildren().get(0);
    }

    public void changeAreaContent (Content content){
        switch (content){
            case GAME:
                setGameAreaContent(screen);
                break;
            case ROOM:
                setGameAreaContent(roomer);
                break;
            case NOTHING:
                setGameAreaContent(null);
                break;
            default:
                Logger.log("Unsupported content.");
                break;
        }
        this.changeSizeComponents(Action.getRegionWidth(this), Action.getRegionHeight(this));
    }

    @Override
    public void buildComponent() {
        this.screen = new Screen();
        this.roomer = new Roomer();
        this.initializeAction();
    }

    private void initializeAction(){
        this.changeAreaContent(Content.NOTHING);
    }

    public Screen getScreen() {
        return screen;
    }

    public Roomer getRoomer() {
        return roomer;
    }
}
