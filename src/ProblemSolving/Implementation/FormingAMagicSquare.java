package ProblemSolving.Implementation;

import Utils.Pair;

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
            final int median = 5;
            final int magicConstant = 15;
            final int[][] oddEvenDistribution = { // odd = 1, even = 0
                    {0, 1, 0},
                    {1, 1, 1},
                    {0, 1, 0}
            };
            int minimalTotalCost = 0;
            // Middle cell has to be median between 1-9 (e.g. 5).
            if (s.get(1).get(1) != median) {
                minimalTotalCost += Math.abs(s.get(1).get(1) - median);
                s.get(1).set(1, 5);
            }
            // Check for out of place odd and even cells
            Map<Integer, Integer> numOccurrences = populateNumOccurrences(s);
            List<Integer> missingNumbers = populateMissingNums(numOccurrences);
            List<Pair<Integer, Integer>> outOfPlaceCells = populateOutOfPlaceCells(s, oddEvenDistribution);
            do {
                for (Pair<Integer, Integer> outOfPlaceCell : outOfPlaceCells) {
                    int i = outOfPlaceCell.getLeft();
                    int j = outOfPlaceCell.getRight();
                    int cellVal = s.get(i).get(j);
                    int nearestMissingVal = getNearestMissingVal(missingNumbers, cellVal);
                    s.get(i).set(j, nearestMissingVal);
                    minimalTotalCost += Math.abs(nearestMissingVal - cellVal);
                    updateNumOccurrences(numOccurrences, cellVal, nearestMissingVal);
                    missingNumbers = populateMissingNums(numOccurrences);
                }
                outOfPlaceCells = populateOutOfPlaceCells(s, oddEvenDistribution);
            } while (outOfPlaceCells.size() != 0);
            // Check against totals equalling magicConstant and occurrences of numbers
            List<Integer> rowTotals = populateRows(s);
            List<Integer> colTotals = populateCols(s);
            List<Integer> diaTotals = populateDias(s); // [topLeftToBottomRight, topRightToBottomLeft]
            do {
                for (int i = 0; i < rowTotals.size(); i++) {
                    for (int j = 0; j < colTotals.size(); j++) {
                        int rowVal = rowTotals.get(i);
                        int colVal = colTotals.get(j);
                        if (rowVal == colVal) {
                            boolean topLeftToBottomRightDia = isDiag(i, j, 0);
                            boolean topRightToBottomLeftDia = isDiag(i, j, 1);
                            if (topLeftToBottomRightDia || topRightToBottomLeftDia) {
                                // Compare row, col and dia.
                                int k = topLeftToBottomRightDia ? 0 : 1;
                                int diaVal = diaTotals.get(k);
                                if (colVal == diaVal && diaVal != magicConstant) {
                                    int tmp = magicConstant - diaVal;
                                    int oldCellVal = s.get(i).get(j);
                                    int newCellVal = s.get(i).get(j) + tmp;
                                    if (numOccurrences.get(oldCellVal) > 1 && missingNumbers.contains(newCellVal)) {
                                        s.get(i).set(j, newCellVal);
                                        minimalTotalCost += Math.abs(newCellVal - oldCellVal);
                                        updateNumOccurrences(numOccurrences, oldCellVal, newCellVal);
                                        missingNumbers = populateMissingNums(numOccurrences);
                                        rowTotals = populateRows(s);
                                        colTotals = populateCols(s);
                                        diaTotals = populateDias(s);
                                    }
                                }
                            } else {
                                // Compare just row and col.
                                if (colVal != magicConstant) {
                                    int tmp = magicConstant - colVal;
                                    int oldCellVal = s.get(i).get(j);
                                    int newCellVal = s.get(i).get(j) + tmp;
                                    if (numOccurrences.get(oldCellVal) > 1 && missingNumbers.contains(newCellVal)) {
                                        s.get(i).set(j, newCellVal);
                                        minimalTotalCost += Math.abs(newCellVal - oldCellVal);
                                        updateNumOccurrences(numOccurrences, oldCellVal, newCellVal);
                                        missingNumbers = populateMissingNums(numOccurrences);
                                        rowTotals = populateRows(s);
                                        colTotals = populateCols(s);
                                        diaTotals = populateDias(s);
                                    }
                                }
                            }
                        }
                    }
                }
            } while (!isMagicSquare(rowTotals, colTotals, diaTotals, magicConstant) && s.size() < 9);
            return minimalTotalCost;
        }
        return -1;
    }


    private static List<Pair<Integer, Integer>> populateOutOfPlaceCells(List<List<Integer>> s, int[][] oddEvenDistribution)
    {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.get(i).size(); j++) {
                if (s.get(i).get(j) % 2 != oddEvenDistribution[i][j]) {
                    list.add(new Pair<>(i, j));
                }
            }
        }
        return list;
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

    private static List<Integer> populateMissingNums(Map<Integer, Integer> numOccurrences)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!numOccurrences.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
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

    private static int getNearestMissingVal(List<Integer> missingNumbers, int num)
    {
        int closestNum = -1;
        int smallestDiff = 0;
        for (var i : missingNumbers) {
            if (closestNum == -1 || Math.abs(num - i) < smallestDiff) {
                closestNum = i;
                smallestDiff = Math.abs(num - i);
            }
        }
        return closestNum;
    }

    private static void updateNumOccurrences(Map<Integer, Integer> map, int oldCellVal, int newCellVal)
    {
        // Remove old cell value.
        if (map.containsKey(oldCellVal) && map.get(oldCellVal) > 1) {
            map.put(oldCellVal, map.get(oldCellVal) - 1);
        } else {
            map.remove(oldCellVal);
        }
        // Add new cell value.
        if (!map.containsKey(newCellVal)) {
            map.put(newCellVal, 1);
        } else {
            map.put(newCellVal, map.get(newCellVal) + 1);
        }
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
