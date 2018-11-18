package pl.game.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.game.common.util.ServerConst;

@RestController
@RequestMapping(path = ServerConst.GAME)
public class GameEngine {
}
