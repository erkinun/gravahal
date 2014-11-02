package com.geekmohican.domain;

/**
 * Created by ERKIN on 02/11/14.
 */
public class GameState {

    private Board board;
    private PlayerInfo playerInfo;
    private boolean gameOver;

    public GameState(Board board) {
        this.board = board;
        this.playerInfo = PlayerInfo.PLAYER_1; //start with player 1
        gameOver = false;
    }

    public void move(int index) {

        int lastStep = board.moveStones(index, playerInfo);

        //is game over
        gameOver = board.isGameOver(playerInfo);

        if (gameOver) {
            return;
        }

        //who will play next
        playerInfo = board.whoWillPlayNext(playerInfo, lastStep);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }
}
