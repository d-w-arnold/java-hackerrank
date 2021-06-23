package ProblemSolving.Implementation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
public class SequenceEquation
{
    /**
     * Sequence Equation problem: https://www.hackerrank.com/challenges/permutation-equation/problem
     *
     * @param p An array of integers.
     * @return The values of 'y' for all 'x' in the arithmetic sequence 1 to 'n'.
     */
    public static List<Integer> permutationEquation(List<Integer> p)
    {
        Map<Integer, Integer> pos = new LinkedHashMap<>();
        for (int i = 0; i < p.size(); i++) {
            pos.put(p.get(i), i + 1);
        }
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            order.add(pos.get(pos.get(i + 1)));
        }
        return order;
    }
}
