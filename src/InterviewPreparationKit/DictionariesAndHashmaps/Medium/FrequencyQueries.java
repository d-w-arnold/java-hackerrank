package InterviewPreparationKit.DictionariesAndHashmaps.Medium;

import java.util.*;

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
        Map<Integer, Integer> numFreq = new HashMap<>();
        Map<Integer, Set<Integer>> freqNum = new HashMap<>();
        List<Integer> array = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (List<Integer> query : queries) {
            switch (query.get(0)) {
                case 1:
                    opOne(query.get(1), numFreq, freqNum, array);
                    break;
                case 2:
                    opTwo(query.get(1), numFreq, freqNum, array);
                    break;
                case 3:
                    opThree(query.get(1), freqNum, output);
                    break;
            }
        }
        return output;
    }

    private static void opOne(int n, Map<Integer, Integer> numFreq, Map<Integer, Set<Integer>> freqNum, List<Integer> array)
    {
        array.add(n);
        int newVal = numFreq.containsKey(n) ? numFreq.get(n) + 1 : 1;
        numFreq.put(n, newVal);
        addToFreqNum(n, newVal, freqNum);
        if (newVal > 1) freqNum.get(newVal - 1).remove(n);
    }

    private static void opTwo(int n, Map<Integer, Integer> numFreq, Map<Integer, Set<Integer>> freqNum, List<Integer> array)
    {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == n) {
                array.remove(i);
                int newVal = numFreq.get(n) - 1;
                numFreq.put(n, newVal);
                addToFreqNum(n, newVal, freqNum);
                freqNum.get(newVal + 1).remove(n);
                return;
            }
        }
    }

    private static void opThree(int n, Map<Integer, Set<Integer>> freqNum, List<Integer> output)
    {
        output.add(freqNum.containsKey(n) && freqNum.get(n).size() > 0 ? 1 : 0);
    }

    private static void addToFreqNum(int n, int newVal, Map<Integer, Set<Integer>> freqNum)
    {
        if (freqNum.containsKey(newVal)) {
            freqNum.get(newVal).add(n);
        } else {
            freqNum.put(newVal, new HashSet<>(Collections.singletonList(n)));
        }
    }
}
