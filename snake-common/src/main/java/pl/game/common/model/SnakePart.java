package pl.game.common.model;

import java.util.List;

public class SnakePart extends AbstractModel{

    private User owner;
    private List<GamePoint> beginningGamePoints;
    private List<GamePoint> endingGamePoints;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<GamePoint> getBeginningGamePoints() {
        return beginningGamePoints;
    }

    public void setBeginningGamePoints(List<GamePoint> beginningGamePoints) {
        this.beginningGamePoints = beginningGamePoints;
    }

    public List<GamePoint> getEndingGamePoints() {
        return endingGamePoints;
    }

    public void setEndingGamePoints(List<GamePoint> endingGamePoints) {
        this.endingGamePoints = endingGamePoints;
    }
}
