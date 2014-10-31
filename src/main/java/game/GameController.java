package game;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by unlue on 31/10/14.
 */

@RestController
public class GameController {

    @RequestMapping("game")
    public String index(){
        return "hello gravahal game";
    }
}
