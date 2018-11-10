package pl.game.common.model;

import java.util.List;

public class SnakePart {


    private List<GamePoint> beginningGamePoints;
    private List<GamePoint> endingGamePoints;

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
