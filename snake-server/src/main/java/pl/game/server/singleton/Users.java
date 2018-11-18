package pl.game.server.singleton;

import pl.game.common.exception.UserNotExists;
import pl.game.common.model.User;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private static List<User> users = new ArrayList<User>();

    private Users(){}

    public static synchronized User getUserById(String userId) throws UserNotExists {
        for (User user: users){
            if(user.getModelId().equals(userId)){
                return user;
            }
        }
        throw new UserNotExists();
    }

    public static synchronized boolean nickNameExists(String nickName) {
        if(users.isEmpty()){
            return false;
        }
        for (User user: users){
            if(user.getNickname().equals(nickName)){
                return true;
            }
        }
        return false;
    }

    public static synchronized void addUser(User user){
        users.add(user);
    }

    public static synchronized List<User> getUsers() {
        return users;
    }
}
