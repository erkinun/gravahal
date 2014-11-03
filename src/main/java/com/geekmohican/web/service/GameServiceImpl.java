package com.geekmohican.web.service;

import com.geekmohican.domain.Board;
import com.geekmohican.domain.GameState;
import org.springframework.stereotype.Service;

/**
 * Created by ERKIN on 02/11/14.
 */
@Service("gameService")
public class GameServiceImpl implements GameService {

    public GameState startNewGame() {
        return new GameState(new Board());
    }

    public GameState move(int index, GameState state) {

        state.move(index);

        return state;
    }
}
