package com.geekmohican.domain;

import org.junit.Assert;
import org.junit.Test;

public class PlayerInfoTest {

    @Test
    public void testGetGravaIndex1() throws Exception {
        PlayerInfo info = PlayerInfo.PLAYER_1;

        int index = info.getGravaIndex();

        Assert.assertEquals(index, 6);
    }

    @Test
    public void testGetGravaIndex2() throws Exception {
        PlayerInfo info = PlayerInfo.PLAYER_2;

        int index = info.getGravaIndex();

        Assert.assertEquals(index, 13);
    }

    @Test
    public void testGetOpponentPit() throws Exception {
        PlayerInfo info = PlayerInfo.PLAYER_1;

        int oppStep = info.getOpponentPit(3);

        Assert.assertEquals(oppStep, 9);
    }

    @Test
    public void testGetOpponentPit2() throws Exception {
        PlayerInfo info = PlayerInfo.PLAYER_1;

        int oppStep = info.getOpponentPit(2);

        Assert.assertEquals(oppStep, 10);
    }

    @Test
    public void testGetOpponentPit3() throws Exception {
        PlayerInfo info = PlayerInfo.PLAYER_2;

        int oppStep = info.getOpponentPit(11);

        Assert.assertEquals(oppStep, 1);
    }

    @Test
    public void testGetOpponentPit4() throws Exception {
        PlayerInfo info = PlayerInfo.PLAYER_2;

        int oppStep = info.getOpponentPit(12);

        Assert.assertEquals(oppStep, 0);
    }

    @Test
    public void testWhoWillPlay() throws Exception {
        PlayerInfo info = PlayerInfo.PLAYER_1;

        PlayerInfo who =  info.whoWillPlay(3);

        Assert.assertEquals(who, PlayerInfo.PLAYER_2);
    }

    @Test
    public void testWhoWillPlay2() throws Exception {
        PlayerInfo info = PlayerInfo.PLAYER_1;

        PlayerInfo who =  info.whoWillPlay(6);

        Assert.assertEquals(who, PlayerInfo.PLAYER_1);
    }

    @Test
    public void testWhoWillPlay3() throws Exception {
        PlayerInfo info = PlayerInfo.PLAYER_2;

        PlayerInfo who =  info.whoWillPlay(10);

        Assert.assertEquals(who, PlayerInfo.PLAYER_1);
    }

    @Test
    public void testWhoWillPlay4() throws Exception {
        PlayerInfo info = PlayerInfo.PLAYER_2;

        PlayerInfo who =  info.whoWillPlay(13);

        Assert.assertEquals(who, PlayerInfo.PLAYER_2);
    }
}