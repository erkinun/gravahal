package com.geekmohican.domain;

import com.geekmohican.game.Constants;

import java.io.Serializable;

/**
 * Created by ERKIN on 01/11/14.
 */
public class Pit implements Serializable {

    private int count;
    private PitType type;

    public Pit() {
        count = Constants.PIT_STONE_COUNT;
        type = PitType.PIT;
    }

    public Pit(int count, boolean grava) {
        this.count = count;

        if (grava) {
            type = PitType.GRAVA;
        }
        else {
            type = PitType.PIT;
        }
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

    @Override
    public String toString() {
        return "Pit{"
                + "count=" + count
                + '}';
    }

    public String getType() {
        return type.type;
    }

    private enum PitType {

        PIT("Pit"),
        GRAVA("Grava");

        private String type;

        PitType(String type) {
            this.type = type;
        }
    }


}
