package pl.game.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.game.common.model.TableRoomRequest;
import pl.game.common.model.TableRoomResponse;
import pl.game.common.util.ServerConst;
import pl.game.server.singleton.Tables;
import pl.game.server.singleton.Users;

@RestController
@RequestMapping(path = ServerConst.ROOM)
public class RoomController {

    @PostMapping(ServerConst.ROOM_REFRESH)
    public TableRoomResponse roomRefresh(TableRoomRequest roomRequest){
        TableRoomResponse tableRoomResponse = new TableRoomResponse();
        tableRoomResponse.setUsers(Users.getUsers());
        tableRoomResponse.setTables(Tables.getTables());
        tableRoomResponse.setStartGame(null); //TODO - after to change
        return tableRoomResponse;
    }

}
