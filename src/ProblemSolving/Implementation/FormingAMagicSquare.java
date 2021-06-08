package ProblemSolving.Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            final int median = 5;
            final int magicConstant = 15;
            // Middle cell has to be median between 1-9 (e.g. 5).
            if (s.get(1).get(1) != median) {
                minimalTotalCost += Math.abs(s.get(1).get(1) - median);
            }
            Map<Integer, Integer> numOccurrences = populateNumOccurrences(s);
            List<Integer> rowTotals = populateRows(s);
            List<Integer> colTotals = populateCols(s);
            List<Integer> diaTotals = populateDias(s); // [topLeftToBottomRight, topRightToBottomLeft]
            do {
                for (int i = 0; i < rowTotals.size(); i++) {
                    for (int j = 0; j < colTotals.size(); j++) {
                        for (int k = 0; k < diaTotals.size(); k++) {
                            int rowVal = rowTotals.get(i);
                            int colVal = colTotals.get(j);
                            if (rowVal == colVal) {
                                if (isDiag(i, j, k)) {
                                    // Compare row, col and dia.
                                    int diaVal = diaTotals.get(k);
                                    if (colVal == diaVal && diaVal != magicConstant) {
                                        int tmp = magicConstant - diaVal;
                                        rowTotals.set(i, rowTotals.get(i) + tmp);
                                        colTotals.set(j, colTotals.get(j) + tmp);
                                        diaTotals.set(k, diaTotals.get(k) + tmp);
                                        minimalTotalCost += tmp;
                                    }
                                } else {
                                    // Compare just row and col.
                                    if (colVal != magicConstant) {
                                        int tmp = magicConstant - colVal;
                                        rowTotals.set(i, rowTotals.get(i) + tmp);
                                        colTotals.set(j, colTotals.get(j) + tmp);
                                        minimalTotalCost += tmp;
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println();
            } while (!isMagicSquare(rowTotals, colTotals, diaTotals, magicConstant));
            return minimalTotalCost;
        }
        return -1;
    }

    private static Map<Integer, Integer> populateNumOccurrences(List<List<Integer>> s)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : s) {
            for (int i : row) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }
        }
        return map;
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

    private static boolean isDiag(int x, int y, int k)
    {
        if (k == 0) {
            // Check to see if the coordinates exist on the topLeftToBottomRight diagonal.
            return x == y;
        } else if (k == 1) {
            // Check to see if the coordinates exist on the bottomLeftToTopRight diagonal.
            return (x + y) + 1 == 3;
        }
        return false;
    }

    private static boolean isMagicSquare(List<Integer> rows, List<Integer> cols, List<Integer> dias, int magicConstant)
    {
        for (int r : rows) {
            if (r != magicConstant) {
                return false;
            }
        }
        for (int c : cols) {
            if (c != magicConstant) {
                return false;
            }
        }
        for (int d : dias) {
            if (d != magicConstant) {
                return false;
            }
        }
        return true;
    }
}
