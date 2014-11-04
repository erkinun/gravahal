package com.geekmohican.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testGetGravaStones() throws Exception {
        int stones = board.getGravaStones(PlayerInfo.PLAYER_1);
        Assert.assertEquals(0, stones);
    }

    @Test
    public void testMoveStones() throws Exception {
        int lastStep = board.moveStones(0, PlayerInfo.PLAYER_1);
        Assert.assertEquals(6, lastStep);

        int stones = board.getGravaStones(PlayerInfo.PLAYER_1);
        Assert.assertEquals(1, stones);
    }

    @Test
    public void testIsGameOver() throws Exception {
        int lastStep = board.moveStones(0, PlayerInfo.PLAYER_1);
        Assert.assertEquals(6, lastStep);

        Assert.assertFalse(board.isGameOver(PlayerInfo.PLAYER_1));
    }

    @Test
    public void testWhoWillPlayNext() throws Exception {
        int lastStep = board.moveStones(0, PlayerInfo.PLAYER_1);
        Assert.assertEquals(6, lastStep);

        Assert.assertEquals(PlayerInfo.PLAYER_1, board.whoWillPlayNext(PlayerInfo.PLAYER_1, lastStep));
    }

    @Test
    public void testWhoWillPlay2Next() throws Exception {
        int lastStep = board.moveStones(0, PlayerInfo.PLAYER_1);
        Assert.assertEquals(6, lastStep);

        Assert.assertEquals(PlayerInfo.PLAYER_1, board.whoWillPlayNext(PlayerInfo.PLAYER_1, lastStep));

        int secondStep = board.moveStones(1, PlayerInfo.PLAYER_1);
        Assert.assertEquals(PlayerInfo.PLAYER_2, board.whoWillPlayNext(PlayerInfo.PLAYER_1, secondStep));
    }

    @Test
    public void whoWins() throws Exception {

        PlayerInfo info = board.whoWins();

        Assert.assertEquals(info, PlayerInfo.PLAYER_DRAW);
    }
}