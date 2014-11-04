package com.geekmohican.domain;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameStateTest {

    private GameState state;

    @Before
    public void setUp() throws Exception {
        state = new GameState(new Board());
    }

    @Test
    public void testMove() throws Exception {
        state.move(1);
    }

    @Test
    public void testIsGameOver() throws Exception {
        state.move(1);

        String result = state.isGameOver();

        Assert.assertEquals("Playing", result);
    }

    @Test
    public void testGetWhoWon() throws Exception {
        state.move(1);

        PlayerInfo info = state.getWhoWon();

        Assert.assertNull(info);
    }
}