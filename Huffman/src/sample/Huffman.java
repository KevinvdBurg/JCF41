package sample;

import java.util.*;

/**
 * Created by kvdb on 12/03/16.
 */
public class Huffman implements Comparator
{
    private Map<String, Integer> map;
    private Map<String, Integer> sortedMap;

    public Huffman(String[] words)
    {
        map = new TreeMap<>();

        setMap(words);
    }

    public Map<String, Integer> getMap()
    {
        return map;
    }

    public void setMap(String[] words)
    {
        //Get all unique characters frequency and put then in a TreeMap(map)
        for (String w : words) {
            Integer n = map.get(w);
            n = (n == null) ? 1 : ++n;
            map.put(w, n);
        }
    }

    public Object[] getSortedMap(){
        Object[] set = map.entrySet().toArray();
        Arrays.sort(set, new Comparator() {
                public int compare(Object o1, Object o2) {
                    return ((Map.Entry<String, Integer>) o2).getValue().compareTo(
                            ((Map.Entry<String, Integer>) o1).getValue());
                }
            });
        return set;

    }

    @Override
    public int compare(Object o1, Object o2)
    {
        return ((Map.Entry<String, Integer>) o2).getValue().compareTo(((Map.Entry<String, Integer>) o1).getValue());
    }
}
