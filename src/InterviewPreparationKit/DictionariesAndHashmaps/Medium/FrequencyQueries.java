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
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> array = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (List<Integer> query : queries) {
            switch (query.get(0)) {
                case 1:
                    opOne(query.get(1), freqMap, array);
                    break;
                case 2:
                    opTwo(query.get(1), freqMap, array);
                    break;
                case 3:
                    opThree(query.get(1), freqMap, output);
                    break;
            }
        }
        return output;
    }

    private static void opOne(int n, Map<Integer, Integer> freqMap, List<Integer> array)
    {
        array.add(n);
        freqMap.put(n, freqMap.containsKey(n) ? freqMap.get(n) + 1 : 1);
    }

    private static void opTwo(int n, Map<Integer, Integer> freqMap, List<Integer> array)
    {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == n) {
                array.remove(i);
                freqMap.put(n, freqMap.get(n) - 1);
                return;
            }
        }
    }

    private static void opThree(int n, Map<Integer, Integer> freqMap, List<Integer> output)
    {
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == n) {
                output.add(1);
                return;
            }
        }
        output.add(0);
    }
}
