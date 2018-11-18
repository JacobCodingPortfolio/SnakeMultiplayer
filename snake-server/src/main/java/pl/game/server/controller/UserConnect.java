package pl.game.server.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.game.common.model.User;
import pl.game.common.model.UserRequest;
import pl.game.common.model.UserResponse;
import pl.game.common.util.ErrorCode;
import pl.game.common.util.ServerConst;
import pl.game.server.singleton.Users;

@RestController
@RequestMapping(path = ServerConst.USER)
public class UserConnect {

    @RequestMapping(path = ServerConst.USER_CREATE)
    public UserResponse userCreate(@RequestBody UserRequest userRequest){
        if(!Users.nickNameExists(userRequest.getNickname())){ //Check user exists
            User user = User.createUser(userRequest.getNickname());
            Users.addUser(user); //Add use to the cache
            return UserResponse.successResponse(user.getNickname(), user.getModelId());
        } else {
            return UserResponse.errorResponse(ErrorCode.NICK_EXISTS);
        }
    }

}
