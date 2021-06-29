package ProblemSolving.Strings.Expert;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 29/06/2021
 */
public class HowManySubstrings
{
    /**
     * How Many Substrings? problem: https://www.hackerrank.com/challenges/how-many-substrings/problem
     * TODO: Improve on 30/100 score, look into using Ukkonen's algorithm.
     *
     * @param s       A string of 'n' characters.
     * @param queries A list of queries in the form of two integer indices: left and right.
     * @return A list of the number of different substrings in the inclusive range between index left and index right.
     */
    public static List<Integer> countSubstrings(String s, List<List<Integer>> queries)
    {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (List<Integer> query : queries) {
            int left = query.get(0);
            int right = query.get(1);
            String tmpPair = getStrPair(left, right);
            if (map.containsKey(tmpPair)) { // Already seen pair found
                ans.add(map.get(tmpPair));
            } else if (left == right) { // Not already seen pair found, and only 1 substring possible
                ans.add(1);
                map.put(tmpPair, 1);
            } else { // Not already seen pair found, and more than 1 substring possible
                int numOfSubstring = getNumOfSubstrings(s.substring(left, right + 1));
                ans.add(numOfSubstring);
                map.put(tmpPair, numOfSubstring);
            }
        }
        return ans;
    }

    private static String getStrPair(int left, int right)
    {
        return left + "-" + right;
    }

    private static int getNumOfSubstrings(String str)
    {
        Set<String> substrings = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                substrings.add(str.substring(i, j + 1));
            }
        }
        return substrings.size();
    }
}
