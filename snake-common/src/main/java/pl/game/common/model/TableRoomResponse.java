package pl.game.common.model;

import java.util.List;

public class TableRoomResponse {

    private List<Table> tables;
    private List<User> users;
    private Boolean startGame;

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Boolean getStartGame() {
        return startGame;
    }

    public void setStartGame(Boolean startGame) {
        this.startGame = startGame;
    }
}
