package com.geekmohican.domain;

import com.geekmohican.game.Constants;

/**
 * Created by ERKIN on 02/11/14.
 */
public class GameState {

    private static final String GRAVA_ERROR = "You cannot move stones from gravahal";
    private static final String OPPONENT_STONES = "You cannot move stones of your opponents";
    private static final String NO_STONES_THERE = "There are no stones at the index";
    private static final String GAME_OK = "Game is OK";

    private Board board;
    private PlayerInfo playerInfo;
    private boolean gameOver;
    private String message = GAME_OK;

    public GameState(Board board) {
        this.board = board;
        this.playerInfo = PlayerInfo.PLAYER_1; //start with player 1
        gameOver = false;
    }

    public void move(int index) {

        //validate move
        if (!validateMove(index)) {
            return;
        }

        int lastStep = board.moveStones(index, playerInfo);

        //is game over
        gameOver = board.isGameOver(playerInfo);

        if (gameOver) {
            return;
        }

        //who will play next
        playerInfo = board.whoWillPlayNext(playerInfo, lastStep);
    }

    private boolean validateMove(int index) {
        if (index == Constants.PLAYER_1_GRAVA || index == Constants.PLAYER_2_GRAVA) {
            this.message = GRAVA_ERROR;
            return false;
        }

        if (!playerInfo.validateMove(index)) {
            this.message = OPPONENT_STONES;
            return false;
        }

        if (!board.hasStones(index)) {
            this.message = NO_STONES_THERE;
            return false;
        }


        this.message = GAME_OK;
        return true;
    }

    public String isGameOver() {
        if (gameOver) {
            return "Over";
        }
        else {
            return "Playing";
        }
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public Pit[] getBoard() {
        return board.getPits();
    }

    public String getMessage() {
        return message;
    }
}
