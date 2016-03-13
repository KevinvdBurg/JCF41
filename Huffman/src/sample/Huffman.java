package sample;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kvdb on 12/03/16.
 */
public class Huffman
{
    private Map<Character, Integer> map;
    private List<Knot> nodes = new ArrayList<>();

    private PriorityQueue<Knot> knotQueue;
    private Knot treeRoot;
    private Map<Character, String> characterCodes;

    public Huffman(char[] letters)
    {
        characterCodes = new HashMap<>();
        treeRoot = new Knot();
        map = new TreeMap<>();

        setMap(letters);
    }


    public void setMap(char[] letters)
    {
        //Get all unique characters frequency and put then in a TreeMap(map)
        for (char w : letters) {
            Integer n = map.get(w);
            n = (n == null) ? 1 : ++n;
            map.put(w, n);
        }

        //Adds all entry form the map to the nodes, addAll is why faster than a for loop
        nodes.addAll(map.entrySet().stream().map(entry -> new Knot(entry.getKey(), entry.getValue())).collect(Collectors.toList()));
        nodes.sort(null); //This can sort the list before the queue


        PriorityQueue<Knot> queue = new PriorityQueue(new Comparator<Knot>() {

            @Override
            public int compare(Knot o1, Knot o2)
            {
                if (o1.frequentie < o2.frequentie)
                {
                    return 1;
                }
                else if (o1.frequentie > o2.frequentie)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }

        });

        //Adds all the Knots to the PriorityQueue Sorted
        queue.addAll(nodes);

        knotQueue = queue;

        System.out.println(queue);


    }
    public Map<Character, Integer> getMap()
    {
        return map;
    }

    public List<Knot> getNodes()
    {
        return nodes;
    }

    /* TODO
    * Add making the huffman tree
    * Incode the message with huffman
    * Decode the message with huffman
    *
    * */

    /**
     * Method which builds a Huffman tree based on the knotQueue
     * @return
     */
    public Knot buildTree()
    {
        Knot leftKnot;
        Knot rightKnot;
        Knot frequencyKnot;

        //Loop over the queue with knots, get the last 2 items and remove them
        while((rightKnot = knotQueue.poll()) != null)
        {
            //If there's only 1 item left, that's is the root of the tree
            if((leftKnot = knotQueue.poll()) == null)
            {
                treeRoot = rightKnot;
                break;
            }

            //Create a new knot which serves as a link containing 2 other knots
            frequencyKnot = new Knot();
            frequencyKnot.setLeftKnot(leftKnot);
            frequencyKnot.frequentie = leftKnot.frequentie;

            frequencyKnot.setRightKnot(rightKnot);
            frequencyKnot.frequentie += rightKnot.frequentie;

            //Put the knot back into the queue so it can be picked up to add to the tree
            knotQueue.add(frequencyKnot);
        }
        return treeRoot;
    }

    /**
     * Method which initiates building coe for characters in the tree
     */
    public void buildCharacterCodes()
    {
        //Start building from the root
        buildKnotCode(treeRoot, "");
    }

    /**
     * Recursive method which builds codes for characters in the tree
     * @param knot
     * @param currentCode
     */
    private void buildKnotCode(Knot knot, String currentCode)
    {
        //If the given knot doesn't exist, stop the method
        if(knot == null)
            return;

        //If the knot doesnt contain a character call the method on it's children
        if(knot.letter == (char) 0) {
            buildKnotCode(knot.getLeftKnot(), currentCode + knot.LEFT);
            buildKnotCode(knot.getRightKnot(), currentCode + knot.RIGHT);
        }
        else {
            characterCodes.put(knot.letter, currentCode);
        }
    }
}
