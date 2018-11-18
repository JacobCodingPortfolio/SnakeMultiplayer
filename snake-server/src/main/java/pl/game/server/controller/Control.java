package pl.game.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.game.common.util.ServerConst;

@RestController
@RequestMapping(ServerConst.CONTROL)
public class Control {

    @RequestMapping(ServerConst.CONTROL_CONNECT)
    public Boolean connect(){
        System.out.println("Connected.");
        return true;
    }

}
