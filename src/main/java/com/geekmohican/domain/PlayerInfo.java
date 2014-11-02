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

    @Override
    public String toString() {
        return "PlayerInfo{"
                + "turn=" + turn
                + ", gravaIndex=" + gravaIndex
                + '}';
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

    public void isValidMove(int index) {
        if (this.equals(PLAYER_1)) {
            if (!(index >= 0 && index < 6)) {
                throw new IllegalArgumentException(index + " is not a valid move for PLAYER 1");
            }
        }
        else {
            if (!(index >= 7 && index < 13)) {
                throw new IllegalArgumentException(index + " is not a valid move for PLAYER 2");
            }
        }
    }

    public int getOpponentGravaIndex() {
        if (this.equals(PLAYER_1)) {
            return Constants.PLAYER_2_GRAVA;
        }
        else {
            return Constants.PLAYER_1_GRAVA;
        }
    }
}
