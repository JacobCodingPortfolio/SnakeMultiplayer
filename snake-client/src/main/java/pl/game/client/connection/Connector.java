package pl.game.client.connection;

import org.springframework.http.HttpEntity;
import pl.game.client.Game;
import pl.game.common.model.TableRoomRequest;
import pl.game.common.model.TableRoomResponse;
import pl.game.common.model.UserRequest;
import pl.game.common.model.UserResponse;
import pl.game.common.util.ServerConst;

public class Connector {

    private Connector(){}

    public static synchronized Boolean checkConnection(){
        String url = Game.getGameInstance().getIpFromInput() + ServerConst.CONTROL_CONNECT_PATH;
        return RestSpringClient.conn().getForObject(url, Boolean.class);
    }

    public static synchronized TableRoomResponse refreshRoom(TableRoomRequest request){
        String url = Game.getGameInstance().getIpFromInput() + ServerConst.ROOM_REFRESH_PATH;
        HttpEntity<TableRoomRequest> requestHttpEntity = new HttpEntity<>(request);
        return RestSpringClient.conn().postForObject(url, requestHttpEntity, TableRoomResponse.class);
    }

    public static synchronized UserResponse connectUser(UserRequest request){
        String url = Game.getGameInstance().getIpFromInput() + ServerConst.USER_CREATE_PATH;
        HttpEntity<UserRequest> requestHttpEntity = new HttpEntity<>(request);
        return RestSpringClient.conn().postForObject(url, requestHttpEntity, UserResponse.class);
    }

}
