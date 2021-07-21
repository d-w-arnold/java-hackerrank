package InterviewPreparationKit.DictionariesAndHashmaps.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 21/07/2021
 */
public class FrequencyQueries
{
    /**
     * Frequency Queries problem: https://www.hackerrank.com/challenges/frequency-queries/problem
     *
     * @param queries A 2-d array of integers.
     * @return The results of queries of type 3.
     */
    public static List<Integer> freqQuery(List<List<Integer>> queries)
    {
        List<Integer> array = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (List<Integer> query : queries) {
            switch (query.get(0)) {
                case 1:
                    array.add(query.get(1));
                    break;
                case 2:
                    opTwo(query.get(1), array);
                    break;
                case 3:
                    opThree(query.get(1), array, output);
                    break;
            }
        }
        return output;
    }

    private static void opTwo(int n, List<Integer> array)
    {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == n) {
                array.remove(i);
                return;
            }
        }
    }

    private static void opThree(int n, List<Integer> array, List<Integer> output)
    {
        Map<Integer, Integer> freqMap = getFreqMap(array);
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == n) {
                output.add(1);
                return;
            }
        }
        output.add(0);
    }

    private static Map<Integer, Integer> getFreqMap(List<Integer> list)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : list) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }
}
