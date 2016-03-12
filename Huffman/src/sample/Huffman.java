package sample;

import java.util.*;

/**
 * Created by kvdb on 12/03/16.
 */
public class Huffman
{
    private Map<Character, Integer> map;
    private Map<Character, Integer> sortedMap;

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
    }

    public Object[] getSortedMap(){
        Object[] set = map.entrySet().toArray();
        Arrays.sort(set, new Comparator() {
                public int compare(Object o1, Object o2) {
                    return ((Map.Entry<Character, Integer>) o2).getValue().compareTo(
                            ((Map.Entry<Character, Integer>) o1).getValue());
                }
            });
        return set;

    }

}
