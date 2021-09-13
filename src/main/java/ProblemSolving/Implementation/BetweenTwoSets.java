package ProblemSolving.Implementation;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
public class BetweenTwoSets
{
    /**
     * Between Two Sets problem: https://www.hackerrank.com/challenges/between-two-sets/problem
     *
     * @param a An array of integers.
     * @param b An array of integers.
     * @return The number of integers that are between the sets.
     */
    public static int getTotalX(List<Integer> a, List<Integer> b)
    {
        // Get all factors of each int in 'b'
        List<List<Integer>> factorsList = new ArrayList<>();
        List<Set<Integer>> factorsSet = new ArrayList<>();
        for (int i : b) {
            List<Integer> list = getFactors(i);
            factorsList.add(list);
            factorsSet.add(new HashSet<>(list));
        }
        // Keep only commonFactors of all factors of each int in 'b'
        List<Integer> commonFactors = new ArrayList<>();
        Set<Integer> seenFactors = new HashSet<>();
        boolean common;
        for (int i = 0; i < factorsList.size(); i++) {
            List<Integer> factors = factorsList.get(i);
            for (int factor : factors) {
                if (!seenFactors.contains(factor)) {
                    seenFactors.add(factor);
                    common = true;
                    for (int k = 0; k < factorsSet.size(); k++) {
                        if (i != k) {
                            if (!factorsSet.get(k).contains(factor)) {
                                common = false;
                                break;
                            }
                        }
                    }
                    if (common) {
                        commonFactors.add(factor);
                    }
                }
            }
        }
        // Keep only commonFactors which have each int in 'a' as a factor
        List<Integer> commonBetweenTheTwoArrays = new ArrayList<>();
        outerLoop:
        for (int commonFactor : commonFactors) {
            for (int i : a) {
                if (commonFactor % i != 0) {
                    continue outerLoop;
                }
            }
            commonBetweenTheTwoArrays.add(commonFactor);
        }
        return commonBetweenTheTwoArrays.size();
    }

    private static List<Integer> getFactors(int n)
    {
        ArrayList<Integer> factors = new ArrayList<>();
        // Skip two if the number is odd
        int incrementer = n % 2 == 0 ? 1 : 2;
        for (int i = 1; i <= Math.sqrt(n); i += incrementer) {
            // If there is no remainder, then the number is a factor.
            if (n % i == 0) {
                factors.add(i);
                // Skip duplicates
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }
}
