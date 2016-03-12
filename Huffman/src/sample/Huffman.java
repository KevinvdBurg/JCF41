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
    private List<Knot> nodes = new ArrayList<Knot>();

    public Huffman(char[] letters)
    {
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
        //nodes.sort(null); //This can sort the list before the queue


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



}
