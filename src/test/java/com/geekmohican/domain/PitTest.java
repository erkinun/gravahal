package com.geekmohican.domain;


import org.junit.Assert;

public class PitTest {

    @org.junit.Test
    public void testGetNumber() throws Exception {

        Pit pit = new Pit();

        Assert.assertEquals(6, pit.getStoneCount());

    }

    @org.junit.Test
    public void testAddStone() throws Exception {
        Pit pit = new Pit();

        pit.addStone();
        Assert.assertEquals(7, pit.getStoneCount());
    }

    @org.junit.Test
    public void testRemoveStones() throws Exception {

        Pit pit = new Pit();

        pit.removeStones();
        Assert.assertEquals(0, pit.getStoneCount());
    }
}