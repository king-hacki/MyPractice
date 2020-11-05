package enough_is_enough;

import java.util.*;

public class EnoughIsEnough {


    /**
     * Given a list lst and a number N, create a new list that contains
     * each number of lst at most N times without reordering.
     * For example if N = 2, and the input is [1,2,3,1,2,1,2,3],
     * you take [1,2,3,1,2], drop the next [1,2] since this would lead
     * to 1 and 2 being in the result 3 times, and then take 3,
     * which leads to [1,2,3,1,2,3].
     *
     * @param elements input array
     * @param maxOccurrences max count
     * @return filtered array
     */
    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        if (maxOccurrences != 0)
            for (int e : elements)
                if (!map.containsKey(e)) {
                    map.put(e, 1);
                    list.add(e);
                } else
                    if (map.get(e) != maxOccurrences) {
                        map.put(e, map.get(e) + 1);
                        list.add(e);
                    }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] deleteNthBestSolution(int[] elements, int maxOccurrences) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return Arrays.stream(elements)
                .filter(e -> map.merge(e, 1, Integer::sum) <= maxOccurrences)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[] { 20, 37, 20, 21 }, 2)));
        System.out.println(Arrays.toString(deleteNthBestSolution(new int[] { 20, 37, 20, 21 }, 2)));
    }
}
