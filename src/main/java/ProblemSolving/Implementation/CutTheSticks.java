package ProblemSolving.Implementation;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 25/06/2021
 */
public class CutTheSticks
{
    /**
     * Cut the sticks problem: https://www.hackerrank.com/challenges/cut-the-sticks/problem
     *
     * @param arr The lengths of each stick.
     * @return The number of sticks after each iteration.
     */
    public static List<Integer> cutTheSticks(List<Integer> arr)
    {
        List<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr);
        LinkedHashMap<Integer, Integer> occurrences = getOccurrences(sortedArr);
        List<Integer> sticksCut = new ArrayList<>(Collections.singletonList(sortedArr.size()));
        int index = 0;
        int tmp = sortedArr.size();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            if (index == occurrences.size() - 1) break;
            tmp -= entry.getValue();
            sticksCut.add(tmp);
            index++;
        }
        return sticksCut;
    }

    private static LinkedHashMap<Integer, Integer> getOccurrences(List<Integer> list)
    {
        LinkedHashMap<Integer, Integer> occurrences = new LinkedHashMap<>();
        for (int l : list) {
            occurrences.put(l, occurrences.containsKey(l) ? occurrences.get(l) + 1 : 1);
        }
        return occurrences;
    }
}
