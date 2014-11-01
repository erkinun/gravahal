package domain;

/**
 * Created by ERKIN on 01/11/14.
 */
public class Pit {

    private int number;

    public Pit () {
        number = 6;
    }

    public int getNumber() {
        return number;
    }

    public void addStone() {
        number += 1;
    }

    public void removeStones() {
        number = 0;
    }
}
