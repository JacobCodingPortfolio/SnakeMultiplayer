package pl.game.common.model;

public class TableRoomRequest {

    private String userId;
    private String actualTableId;
    private String wantToJoinTableId;
    private String createNewTableName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActualTableId() {
        return actualTableId;
    }

    public void setActualTableId(String actualTableId) {
        this.actualTableId = actualTableId;
    }

    public String getWantToJoinTableId() {
        return wantToJoinTableId;
    }

    public void setWantToJoinTableId(String wantToJoinTableId) {
        this.wantToJoinTableId = wantToJoinTableId;
    }

    public String getCreateNewTableName() {
        return createNewTableName;
    }

    public void setCreateNewTableName(String createNewTableName) {
        this.createNewTableName = createNewTableName;
    }
}
