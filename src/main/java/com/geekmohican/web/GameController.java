package com.geekmohican.web;

import com.geekmohican.domain.GameState;
import com.geekmohican.web.model.Move;
import com.geekmohican.web.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by ERKIN on 02/11/14.
 */
@Controller
public class GameController {

    private static final String GAME = "game";
    private static final String MOVE = "move";
    private static final String VIEW = "game";


    @Autowired
    private GameService service;

    @RequestMapping(value = { "start", "reset" }, method = RequestMethod.GET)
    public String start(Model model, HttpSession session) {
        GameState state = service.startNewGame();

        session.setAttribute(GAME, state);
        model.addAttribute(GAME, state);
        model.addAttribute(MOVE, new Move());

        return VIEW;
    }

    @RequestMapping(value = "play", method = RequestMethod.POST)
    public String play(@ModelAttribute Move move, Model model, HttpSession session) {

        GameState state = (GameState) session.getAttribute(GAME);
        int index = move.getIndex();

        GameState newState = service.move(index, state);

        model.addAttribute(GAME, newState);
        model.addAttribute(MOVE, new Move());
        return VIEW;
    }

    @RequestMapping(value = "play", method = RequestMethod.GET)
    public String play(Model model, HttpSession session) {

        GameState state = (GameState) session.getAttribute(GAME);

        if (state == null) {
            state = service.startNewGame();
            session.setAttribute(GAME, state);
        }

        model.addAttribute(GAME, state);
        model.addAttribute(MOVE, new Move());
        return VIEW;
    }
}
