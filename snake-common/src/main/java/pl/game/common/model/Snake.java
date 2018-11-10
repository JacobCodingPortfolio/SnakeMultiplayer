package pl.game.common.model;

import java.util.List;

public class Snake extends SnakePart {

    private List<GamePoint> allGamePoints;

    public List<GamePoint> getAllGamePoints() {
        return allGamePoints;
    }

    public void setAllGamePoints(List<GamePoint> allGamePoints) {
        this.allGamePoints = allGamePoints;
    }
}
