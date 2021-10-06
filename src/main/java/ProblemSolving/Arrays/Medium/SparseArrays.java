package ProblemSolving.Arrays.Medium;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 06/10/2021
 */
public class SparseArrays
{
    /**
     * Sparse Arrays problem: https://www.hackerrank.com/challenges/sparse-arrays/problem
     *
     * @param strings An array of strings to search.
     * @param queries An array of query strings.
     * @return An array of results for each query.
     */
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries)
    {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String q : queries) {
            map.put(q, 0);
        }
        for (String s : strings) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
        }
        if (queries.size() == map.size()) return new ArrayList<>(map.values());
        List<Integer> ans = new ArrayList<>();
        for (String q : queries) {
            ans.add(map.get(q));
        }
        return ans;
    }
}
