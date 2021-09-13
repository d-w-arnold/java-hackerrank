package ProblemSolving.Implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
public class MigratoryBirds
{
    /**
     * Migratory Birds problem: https://www.hackerrank.com/challenges/migratory-birds/problem
     *
     * @param arr The types of birds sighted.
     * @return The lowest type id of the most frequently sighted birds.
     */
    public static int migratoryBirds(List<Integer> arr)
    {
        Map<Integer, Integer> ids = new HashMap<>();
        for (int i : arr) {
            if (ids.containsKey(i)) {
                ids.put(i, ids.get(i) + 1);
            } else {
                ids.put(i, 1);
            }
        }
        int lowestId = -1;
        int mostFreqSightings = 0;
        for (Map.Entry<Integer, Integer> i : ids.entrySet()) {
            int key = i.getKey();
            int value = i.getValue();
            if (value > mostFreqSightings) {
                lowestId = key;
                mostFreqSightings = value;
            }
        }
        return lowestId;
    }
}
