package ProblemSolving.Advanced.Medium;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 08/10/2021
 */
public class JimAndTheSkyscrapers
{
    /**
     * Jim and the Skyscrapers problem: https://www.hackerrank.com/challenges/jim-and-the-skyscrapers/problem
     *
     * @param arr The array of skyscraper heights.
     * @return An integer that denotes the number of valid routes.
     */
    public static int solve(List<Integer> arr)
    {
        int ans = 0, numI, numJ;
        outerLoop:
        for (int i = 0; i < arr.size(); i++) {
            numI = arr.get(i);
            for (int j = i + 1; j < arr.size(); j++) {
                numJ = arr.get(j);
                if (numI < numJ) continue outerLoop;
                if (numI == numJ) ans++;
            }
        }
        return ans * 2;
    }
}
