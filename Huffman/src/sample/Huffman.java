package sample;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by kvdb on 12/03/16.
 */
public class Huffman
{
    private Map<Character, Integer> map;
    private Map<Character, Integer> sortedMap;

    private List<Knot> nodes = new ArrayList<Knot>();

    public Huffman(char[] letters)
    {
        map = new TreeMap<>();

        setMap(letters);
    }

    public Map<Character, Integer> getMap()
    {
        return map;
    }

    public void setMap(char[] letters)
    {
        //Get all unique characters frequency and put then in a TreeMap(map)
        for (char w : letters) {
            Integer n = map.get(w);
            n = (n == null) ? 1 : ++n;
            map.put(w, n);
        }

        //Adds all entrys form the map to the nodes
        nodes.addAll(map.entrySet().stream().map(entry -> new Knot(entry.getKey(), entry.getValue())).collect(Collectors.toList()));
        //nodes.sort(null);


        PriorityQueue queue = new PriorityQueue<>(new Comparator<Knot>() {

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

        queue.addAll(nodes);
        System.out.println(queue.toArray().toString());

    }

    public static PriorityQueue<Knot> sortPriorityQueue(PriorityQueue<Knot> huffQ)
    {
        PriorityQueue<Knot> sortedQueue = new PriorityQueue<Knot>();
        sortedQueue.addAll(huffQ);
        return sortedQueue;
    }

    public List<Knot> getNodes()
    {
        return nodes;
    }

    public Map<Character, Integer> getSortedMap(){
        Collections.sort((List) map, new Comparator() {
                public int compare(Object o1, Object o2) {
                    return ((Map.Entry<Character, Integer>) o2).getValue().compareTo(
                            ((Map.Entry<Character, Integer>) o1).getValue());
                }
            });
        return map;

    }

}
