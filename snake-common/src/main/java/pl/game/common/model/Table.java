package pl.game.common.model;

import java.util.List;

public class Table extends AbstractModel{

    private String tableName;
    private List<User> users;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
