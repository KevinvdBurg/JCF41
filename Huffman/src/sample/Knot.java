package sample;

import java.util.Comparator;

/**
 * Created by kvdb on 12/03/16.
 */
public class Knot implements Comparable
{
    public char letter;
    public int frequentie;
    public Knot left;
    public Knot right;

    public Knot(){

    }

    public Knot(char letter)
    {
        this.letter = letter;
    }

    public Knot(char letter, int frequentie)
    {
        this.letter = letter;
        this.frequentie = frequentie;
    }

    @Override
    public int compareTo(Object o)
    {
        if (((Knot)o).frequentie > this.frequentie)
        {
            return 1;
        }
        else if (((Knot)o).frequentie < this.frequentie)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}


