package ProblemSolving.Implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 08/06/2021
 */
public class FormingAMagicSquare
{
    /**
     * Forming a Magic Square problem: https://www.hackerrank.com/challenges/magic-square-forming/problem
     *
     * @param s A (3 x 3) array of integers.
     * @return The minimal total cost of converting the input square to a magic square.
     */
    public static int formingMagicSquare(List<List<Integer>> s)
    {
        if (s.size() == 3 && s.get(0).size() == 3) {
            int minimalTotalCost = 0;
            if (s.get(1).get(1) != 5) { // Middle cell has to be median between 1-9 (e.g. 5).
                minimalTotalCost += Math.abs(s.get(1).get(1) - 5);
            }
            List<Integer> rowTotals = populateRows(s);
            List<Integer> colTotals = populateCols(s);
            List<Integer> diaTotals = populateDias(s); // [topLeftToBottomRight, topRightToBottomLeft]
            return minimalTotalCost;
        }
        return -1;
    }

    private static List<Integer> populateRows(List<List<Integer>> s)
    {
        List<Integer> totals = new ArrayList<>();
        for (List<Integer> row : s) {
            int tmpTotal = 0;
            for (int i : row) {
                tmpTotal += i;
            }
            totals.add(tmpTotal);
        }
        return totals;
    }

    private static List<Integer> populateCols(List<List<Integer>> s)
    {
        List<Integer> totals = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.get(i).size(); j++) {
                if (i == 0) {
                    totals.add(s.get(i).get(j));
                } else {
                    totals.set(j, totals.get(j) + s.get(i).get(j));
                }
            }
        }
        return totals;
    }

    private static List<Integer> populateDias(List<List<Integer>> s)
    {
        List<Integer> totals = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            List<Integer> row = s.get(i);
            if (i == 0) {
                totals.add(row.get(i));
                totals.add(row.get((row.size() - 1) - i));
            } else {
                totals.set(0, totals.get(0) + row.get(i));
                totals.set(1, totals.get(1) + row.get((row.size() - 1) - i));
            }
        }
        return totals;
    }
}
