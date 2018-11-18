package pl.game.common.model;

import pl.game.common.util.ErrorCode;

public class UserResponse {

    private String nickname;
    private String userId;
    private ErrorCode errorCode;

    public static UserResponse successResponse(String nickname, String userId){
        UserResponse response = new UserResponse();
        response.nickname = nickname;
        response.userId = userId;
        return response;
    }

    public static UserResponse errorResponse(ErrorCode error){
        UserResponse response = new UserResponse();
        response.errorCode = error;
        return response;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
