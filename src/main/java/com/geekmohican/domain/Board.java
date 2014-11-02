package com.geekmohican.domain;

import com.geekmohican.game.Constants;

/**
 * Created by ERKIN on 01/11/14.
 */
public class Board {

    private Pit[] pits;
    private GravaHal gravaHalPit;

    public Board() {
        pits = new Pit[Constants.TOTAL_PIT_COUNT];
        gravaHalPit = new GravaHal();
    }

    public int getGravaStones() {
        return gravaHalPit.getStoneCount();
    }

    public int moveStones(int index, PlayerInfo playerInfo) {

        int opponentGravaIndex = playerInfo.getGravaIndex();

        int stoneCount = pits[index].removeStones();

        int step = index;
        while (stoneCount > 0) {
            step++;

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

    private int findGrava(PlayerInfo playerTurn) {
        return playerTurn.getGravaIndex();
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
}