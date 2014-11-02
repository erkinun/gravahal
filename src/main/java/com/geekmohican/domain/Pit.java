package com.geekmohican.domain;

import com.geekmohican.game.Constants;

/**
 * Created by ERKIN on 01/11/14.
 */
public class Pit {

    private int count;

    public Pit() {
        count = Constants.PIT_STONE_COUNT;
    }

    public int getStoneCount() {
        return count;
    }

    public void addStone() {
        count += 1;
    }

    public int removeStones() {
        int current = this.count;
        this.count = 0;

        return current;
    }

    public void addStones(int stones) {
        count += stones;
    }
}
