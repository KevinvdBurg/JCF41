package sample;

import java.util.Comparator;

/**
 * Created by kvdb on 12/03/16.
 */
public class Knot implements Comparable
{
    public static int LEFT = 0;
    public static int RIGHT = 1;

    public char character;
    public int frequency;
    private Knot leftKnot;
    private Knot rightKnot;

    public Knot(){

    }

    public Knot(char character)
    {
        this.character = character;
        this.frequency = 0;
    }

    public Knot(char character, int frequency)
    {
        this.character = character;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Object o)
    {
        if (((Knot)o).frequency > this.frequency)
        {
            return 1;
        }
        else if (((Knot)o).frequency < this.frequency)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    public Knot getRightKnot() {
        return rightKnot;
    }

    public void setRightKnot(Knot rightKnot) {
        this.rightKnot = rightKnot;
    }

    public Knot getLeftKnot() {
        return leftKnot;
    }

    public void setLeftKnot(Knot leftKnot) {
        this.leftKnot = leftKnot;
    }
}


