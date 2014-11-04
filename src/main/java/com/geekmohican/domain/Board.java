package com.geekmohican.domain;

import com.geekmohican.game.Constants;

import java.io.Serializable;

/**
 * Created by ERKIN on 01/11/14.
 */
public class Board implements Serializable {

    private Pit[] pits;

    public Board() {
        pits = new Pit[Constants.TOTAL_PIT_COUNT];

        for (int i = 0; i < Constants.TOTAL_PIT_COUNT; i++) {
            if (i == Constants.PLAYER_1_GRAVA || i == Constants.PLAYER_2_GRAVA) {
                pits[i] = new Pit(0, true);
            }
            else {
                pits[i] = new Pit();
            }
        }
    }

    public Pit[] getPits() {
        return pits.clone();
    }

    public int getGravaStones(PlayerInfo info) {
        return pits[info.getGravaIndex()].getStoneCount();
    }

    public int moveStones(int index, PlayerInfo playerInfo) {

        playerInfo.isValidMove(index);

        int opponentGravaIndex = playerInfo.getOpponentGravaIndex();

        int stoneCount = pits[index].removeStones();

        int step = index;
        while (stoneCount > 0) {
            step++;
            step = step % Constants.TOTAL_PIT_COUNT; // example you are at step 14, you need to go to index 0

            if (step == opponentGravaIndex) {
                continue;
            }

            pits[step].addStone();
            stoneCount--;
        }

        if (lastStoneToEmptyPit(step, playerInfo)) {
            getOpponentStonesToGrava(step, playerInfo);
        }

        return step;
    }

    private void getOpponentStonesToGrava(int step, PlayerInfo playerInfo) {
        int stones = pits[step].removeStones();

        int opponentPit = playerInfo.getOpponentPit(step);

        int opponentStones = pits[opponentPit].removeStones();

        int gravaIndex = playerInfo.getGravaIndex();

        pits[gravaIndex].addStones(stones + opponentStones);

    }


    private boolean lastStoneToEmptyPit(int step, PlayerInfo playerTurn) {

        if (playerTurn.equals(PlayerInfo.PLAYER_1)) {
            if (step >= 6) {
                return false;
            }
        }
        else {
            if (step < 7 || step > 12) {
                return false;
            }
        }

        return pits[step].getStoneCount() == 1; //meaning before last stone, it was empty
    }

    public boolean isGameOver(PlayerInfo playerTurn) {
        int begin, end;
        if (playerTurn.equals(PlayerInfo.PLAYER_1)) {
            begin = 0;
            end = 5;
        }
        else {
            begin = 7;
            end = 12;
        }

        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum += pits[i].getStoneCount();
        }

        return sum == 0;
    }

    public PlayerInfo whoWillPlayNext(PlayerInfo playerInfo, int lastStep) {
        return playerInfo.whoWillPlay(lastStep);
    }

    public boolean hasStones(int index) {
        return pits[index].getStoneCount() > 0;
    }

    public PlayerInfo whoWins() {

        int play1Stones = pits[Constants.PLAYER_1_GRAVA].getStoneCount();
        int play2Stones = pits[Constants.PLAYER_2_GRAVA].getStoneCount();

        int result = Integer.compare(play1Stones, play2Stones);

        if (result > 0) {
            return PlayerInfo.PLAYER_1;
        }
        else if (result < 0) {
            return PlayerInfo.PLAYER_2;
        }
        else {
            return PlayerInfo.PLAYER_DRAW;
        }
    }
}
