package com.geekmohican.domain;

import com.geekmohican.game.Constants;

/**
 * Created by ERKIN on 01/11/14.
 */
public class Pit {

    private int number;

    public Pit() {
        number = Constants.PIT_STONE_COUNT;
    }

    public int getNumber() {
        return number;
    }

    public void addStone() {
        number += 1;
    }

    public void removeStones() {
        number = 0;
    }
}
