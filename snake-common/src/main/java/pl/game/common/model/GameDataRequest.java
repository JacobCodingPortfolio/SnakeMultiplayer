package pl.game.common.model;

public class GameDataRequest {

    private String tabelId;
    private String userId;
    private String snakeId;
    private Boolean pauseGame;
    private Integer direction;

    public String getTabelId() {
        return tabelId;
    }

    public void setTabelId(String tabelId) {
        this.tabelId = tabelId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSnakeId() {
        return snakeId;
    }

    public void setSnakeId(String snakeId) {
        this.snakeId = snakeId;
    }

    public Boolean getPauseGame() {
        return pauseGame;
    }

    public void setPauseGame(Boolean pauseGame) {
        this.pauseGame = pauseGame;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }
}
