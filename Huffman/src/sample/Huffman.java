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
    private char[] chars;

    public Huffman(char[] characters)
    {
        characterCodes = new HashMap<>();
        treeRoot = new Knot();
        map = new TreeMap<>();
        chars = characters;
        setMap(characters);
    }


    public void setMap(char[] characters)
    {
        //Get all unique characters frequency and put then in a TreeMap(map)
        for (char w : characters) {
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
                if (o1.frequency < o2.frequency)
                {
                    return 1;
                }
                else if (o1.frequency > o2.frequency)
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
            frequencyKnot.frequency = leftKnot.frequency;

            frequencyKnot.setRightKnot(rightKnot);
            frequencyKnot.frequency += rightKnot.frequency;

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
        if(knot.character == (char) 0) {
            buildKnotCode(knot.getLeftKnot(), currentCode + knot.LEFT);
            buildKnotCode(knot.getRightKnot(), currentCode + knot.RIGHT);
        }
        else {
            characterCodes.put(knot.character, currentCode);
        }

    }


    /**
     * Encodes the text that is currently in the huffman tree
     * @return
     */
    public String encodeText(){
        //Creates a empty result
        String result = "";
        for (Character c : chars){

            result += characterCodes.get(c); // Gets the value of that character in the characterCodes map.
        }

        System.out.println(result); //prints result in the console
        return result; //returns the value(string)
    }

    /**
     * Method to decode a string with encoded text
     * @param code
     * @return
     */
    public String decodeText(String code)
    {
        String result = "";
        Knot knot = treeRoot;

        //Loop over the given code
        for(int i = 0; i < code.length(); i++)
        {
            //Get the direction and the knot in which that direction results
            int direction = Character.getNumericValue(code.charAt(i));
            if(direction == Knot.LEFT)
                knot = knot.getLeftKnot();
            else if(direction == Knot.RIGHT)
                knot = knot.getRightKnot();

            //Check if the knot has a character, if it does add that character to the result and go back to the root
            if(knot.character != (char) 0)
            {
                result += knot.character;
                knot = treeRoot;
            }
        }
        return result;
    }




}
