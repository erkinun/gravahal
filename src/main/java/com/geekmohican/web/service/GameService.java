package com.geekmohican.web.service;

import com.geekmohican.domain.GameState;

/**
 * Created by ERKIN on 02/11/14.
 */
public interface GameService {
    GameState startNewGame();
    GameState move(int index, GameState state);

}
