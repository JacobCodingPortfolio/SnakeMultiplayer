package pl.game.common.model;

import java.util.List;

public class GameDataResponse {

    private List<Snake> snakes;
    private List<SnakePart> snakesPart;
    private Boolean pauseGame;

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<SnakePart> getSnakesPart() {
        return snakesPart;
    }

    public void setSnakesPart(List<SnakePart> snakesPart) {
        this.snakesPart = snakesPart;
    }

    public Boolean getPauseGame() {
        return pauseGame;
    }

    public void setPauseGame(Boolean pauseGame) {
        this.pauseGame = pauseGame;
    }
}
