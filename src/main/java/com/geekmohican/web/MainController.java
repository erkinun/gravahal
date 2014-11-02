package com.geekmohican.web;

import com.geekmohican.domain.GameState;
import com.geekmohican.web.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ERKIN on 02/11/14.
 */
@Controller
public class MainController {

    @Autowired
    private GameService service;

    @RequestMapping(value = "start", method = RequestMethod.GET)
    public String start(Model model) {
        GameState state = service.startNewGame();
        model.addAttribute("game", state);

        return "game";
    }
}
