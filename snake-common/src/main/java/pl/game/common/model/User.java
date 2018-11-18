package pl.game.common.model;

import java.util.Date;

public class User extends AbstractModel{

    private String nickname;
    private Date lastTimeUpdate;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getLastTimeUpdate() {
        return lastTimeUpdate;
    }

    public void setLastTimeUpdate(Date lastTimeUpdate) {
        this.lastTimeUpdate = lastTimeUpdate;
    }

    public static User createUser(String nickname){
        User user = new User();
        user.nickname = nickname;
        return user;
    }
}
