package pl.game.client.component;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import pl.game.client.annotation.FxmlComponent;
import pl.game.client.util.Action;
import pl.game.client.util.Const;


/**
 * @author JNartowicz
 */
public class Header extends AbstractNode{

    @FxmlComponent
    private ScrollPane headerScrollPane;

    @FxmlComponent
    private HBox headerHBox;

    @FxmlComponent
    private Button headerRunButton;

    @FxmlComponent
    private TextField headerIpTextField;

    @FxmlComponent
    private TextField headerPingTextField;

    @FxmlComponent
    private TextField headerFpsTextField;

    @Override
    public void changeSizeComponents(double parentWidth, double parentHeight) {
        Action.changeRegionSize(headerScrollPane, parentWidth, parentHeight); //Header size
        if(parentWidth < Const.MIN_HEADER_WIDTH){ //Changing size of panel inside
            Action.changeRegionSize(headerHBox, Const.MIN_HEADER_WIDTH, Const.HEADER_HEIGHT_INSIDE);
        } else {
            Action.changeRegionSize(headerHBox, parentWidth - 2, Const.HEADER_HEIGHT_INSIDE);
        }
    }

    public ScrollPane getHeaderScrollPane() {
        return headerScrollPane;
    }

    public HBox getHeaderHBox() {
        return headerHBox;
    }

    public Button getHeaderRunButton() {
        return headerRunButton;
    }

    public TextField getHeaderIpTextField() {
        return headerIpTextField;
    }

    public TextField getHeaderPingTextField() {
        return headerPingTextField;
    }

    public TextField getHeaderFpsTextField() {
        return headerFpsTextField;
    }

}














