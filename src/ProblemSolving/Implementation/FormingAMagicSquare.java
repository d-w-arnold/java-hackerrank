package ProblemSolving.Implementation;

import java.util.*;

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
            final int[][] originalS = toTwoDimArray(s);
            final int median = 5;
            final int magicConstant = 15;
            final int[][] oddEvenDistribution = { // odd = 1, even = 0
                    {0, 1, 0},
                    {1, 1, 1},
                    {0, 1, 0}
            };
            // Middle cell has to be median between 1-9 (e.g. 5).
            if (s.get(1).get(1) != median) {
                s.get(1).set(1, 5);
            }
            // Check for out of place odd and even cells.
            Map<Integer, Integer> numOccurrences = populateNumOccurrences(s);
            List<Integer> missingNumbers = populateMissingNums(numOccurrences);
            List<Integer[]> outOfPlaceCellsOddEven = populateOutOfPlaceCellsOddEven(s, oddEvenDistribution);
            do {
                for (Integer[] outOfPlaceCell : outOfPlaceCellsOddEven) {
                    int i = outOfPlaceCell[0];
                    int j = outOfPlaceCell[1];
                    int cellVal = s.get(i).get(j);
                    int nearestMissingVal = getNearestValidMissingVal(missingNumbers, cellVal, oddEvenDistribution[i][j]);
                    if (nearestMissingVal != cellVal) {
                        s.get(i).set(j, nearestMissingVal);
                        updateNumOccurrences(numOccurrences, cellVal, nearestMissingVal);
                        missingNumbers = populateMissingNums(numOccurrences);
                    }
                }
                outOfPlaceCellsOddEven = populateOutOfPlaceCellsOddEven(s, oddEvenDistribution);
            } while (outOfPlaceCellsOddEven.size() != 0);
            // Check for out of place cells which can be swapped.
            List<Integer> rowTotals = getRowTotals(s);
            List<Integer> colTotals = getColTotals(s);
            List<Integer> diaTotals = getDiaTotals(s); // [topLeftToBottomRight, topRightToBottomLeft]
            List<Integer[]> outOfPlaceCellsSwap = populateOutOfPlaceCellsSwap(s, rowTotals, colTotals, diaTotals, magicConstant);
            System.out.println();
            do {
                for (int i = 0; i < outOfPlaceCellsSwap.size(); i++) {
                    for (int j = 0; j < outOfPlaceCellsSwap.size(); j++) {
                        if (i == j) {
                            continue;
                        }
                        System.out.println();
                    }
                }
                outOfPlaceCellsSwap = populateOutOfPlaceCellsSwap(s, rowTotals, colTotals, diaTotals, magicConstant);
            } while (outOfPlaceCellsSwap.size() != 0);
            int ans = findMatrixDiff(originalS, s);
            System.out.println();
            return ans;
        }
        return -1;
    }

    public static int[][] toTwoDimArray(List<List<Integer>> s)
    {
        int[][] newArray = new int[s.size()][s.get(0).size()];
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.get(i).size(); j++) {
                newArray[i][j] = s.get(i).get(j);
            }
        }
        return newArray;
    }

    private static int findMatrixDiff(int[][] originalS, List<List<Integer>> s)
    {
        int count = 0;
        for (int i = 0; i < originalS.length; i++) {
            for (int j = 0; j < originalS[i].length; j++) {
                int oldVal = originalS[i][j];
                int newVal = s.get(i).get(j);
                if (oldVal != newVal) {
                    count += Math.abs(oldVal - newVal);
                }
            }
        }
        return count;
    }


    private static List<Integer[]> populateOutOfPlaceCellsOddEven(List<List<Integer>> s, int[][] oddEvenDistribution)
    {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.get(i).size(); j++) {
                if (s.get(i).get(j) % 2 != oddEvenDistribution[i][j]) {
                    list.add(new Integer[]{i, j});
                }
            }
        }
        return list;
    }

    private static List<Integer[]> populateOutOfPlaceCellsSwap(List<List<Integer>> s, List<Integer> rowTotals, List<Integer> colTotals, List<Integer> diaTotals, int magicConstant)
    {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.get(i).size(); j++) {
                int rowVal = rowTotals.get(i);
                int colVal = colTotals.get(j);
                if (rowVal == colVal) {
                    boolean topLeftToBottomRightDia = isDiag(i, j, 0);
                    boolean topRightToBottomLeftDia = isDiag(i, j, 1);
                    int k;
                    int diaVal;
                    if (topLeftToBottomRightDia || topRightToBottomLeftDia) {
                        // Compare row, col and dia to the magicConstant.
                        k = topLeftToBottomRightDia ? 0 : 1;
                        diaVal = diaTotals.get(k);
                        if (colVal == diaVal && diaVal != magicConstant) {
                            list.add(new Integer[]{i, j});
                        }
                    } else {
                        // Compare just row and col to the magicConstant.
                        if (colVal != magicConstant) {
                            list.add(new Integer[]{i, j});
                        }
                    }
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

    private static int getRowTotal(List<List<Integer>> s, int rowIndex)
    {
        int rowTotal = 0;
        for (int i : s.get(rowIndex)) {
            rowTotal += i;
        }
        return rowTotal;
    }

    private static List<Integer> getRowTotals(List<List<Integer>> s)
    {
        List<Integer> totals = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            totals.add(getRowTotal(s, i));
        }
        return totals;
    }

    private static int getColTotal(List<List<Integer>> s, int colIndex)
    {
        int colTotal = 0;
        for (List<Integer> row : s) {
            colTotal += row.get(colIndex);
        }
        return colTotal;
    }

    private static List<Integer> getColTotals(List<List<Integer>> s)
    {
        List<Integer> totals = new ArrayList<>();
        for (int i = 0; i < s.get(0).size(); i++) {
            totals.add(getColTotal(s, i));
        }
        return totals;
    }

    private static int getDiaTotal(List<List<Integer>> s, int diaIndex)
    {
        int diaTotal = 0;
        if (diaIndex == 0) {
            for (int i = 0; i < s.size(); i++) {
                diaTotal += s.get(i).get(i);
            }
        } else {
            for (int i = 0; i < s.size(); i++) {
                diaTotal += s.get(i).get((s.get(i).size() - 1) - i);
            }
        }
        return diaTotal;
    }

    private static List<Integer> getDiaTotals(List<List<Integer>> s)
    {
        return Arrays.asList(getDiaTotal(s, 0), getDiaTotal(s, 1));
    }

    private static int getNearestValidMissingVal(List<Integer> missingNumbers, int num, int isOddEven)
    {
        int closestNum = -1;
        int smallestDiff = 0;
        for (int missingNumber : missingNumbers) {
            // Check if missingNumber would be valid (i.e. odd or even cell).
            if ((isOddEven == 0 && missingNumber % 2 == 0) || (isOddEven == 1 && missingNumber % 2 == 1)) {
                if (closestNum == -1 || Math.abs(num - missingNumber) < smallestDiff) {
                    closestNum = missingNumber;
                    smallestDiff = Math.abs(num - missingNumber);
                }
            }
        }
        return closestNum != -1 ? closestNum : num;
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
