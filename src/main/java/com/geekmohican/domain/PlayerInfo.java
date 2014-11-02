package com.geekmohican.domain;

import com.geekmohican.game.Constants;

/**
 * Created by ERKIN on 02/11/14.
 */
public enum PlayerInfo {

    PLAYER_1(1, Constants.PLAYER_1_GRAVA),
    PLAYER_2(2, Constants.PLAYER_2_GRAVA);

    private int turn;
    private int gravaIndex;

    PlayerInfo(int turn, int gravaIndex) {
        this.turn = turn;
        this.gravaIndex = gravaIndex;
    }

    public int getGravaIndex() {
        return gravaIndex;
    }

    public int getOpponentPit(int step) {
        int diff = 6 - step;
        return 6 + diff;
    }


    public PlayerInfo whoWillPlay(int lastStep) {
        if (this.equals(PLAYER_1)) {
            if (lastStep == PLAYER_1.gravaIndex) {
                return PLAYER_1;
            }
            else {
                return PLAYER_2;
            }
        }
        else {
            if (lastStep == PLAYER_2.gravaIndex) {
                return PLAYER_2;
            }
            else {
                return PLAYER_1;
            }
        }
    }
}
