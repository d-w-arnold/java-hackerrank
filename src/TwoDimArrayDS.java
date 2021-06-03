import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author David W. Arnold
 * @version 24/05/2021
 */
public class TwoDimArrayDS
{
    /**
     * Hour Glass Sum problem: https://www.hackerrank.com/challenges/2d-array/problem
     *
     * @param arr An array of integers.
     * @return The maximum hourglass sum.
     */
    public static int hourglassSum(List<List<Integer>> arr)
    {
        // Get all hourglass sums.
        List<List<Integer>> sums = new ArrayList<>();
        for (int i = 0; i < (arr.get(0).size() - 2); i++) {
            List<Integer> rowOfSums = new ArrayList<>();
            for (int j = 0; j < (arr.size() - 2); j++) {
                rowOfSums.add(sumTwoDimArrayList(Objects.requireNonNull(getHourGlass(arr, i, j))));
            }
            sums.add(rowOfSums);
        }
        // Find the maximum hourglass sum.
        int largestSum = 0;
        boolean firstSum = true;
        for (List<Integer> row : sums) {
            for (int sum : row) {
                if (firstSum) {
                    largestSum = sum;
                    firstSum = false;
                } else if (sum > largestSum) {
                    largestSum = sum;
                }
            }
        }
        return largestSum;
    }

    /**
     * Convert a 2D array into a 2D (array)list.
     *
     * @param twoDimArray The 2d array to be converted.
     * @return The converted (array)list.
     */
    public static List<List<Integer>> covertTwoDimArrayToArrayList(Integer[][] twoDimArray)
    {
        List<List<Integer>> twoDimArrayList = new ArrayList<>();
        for (Integer[] ints : twoDimArray) {
            twoDimArrayList.add(Arrays.asList(ints));
        }
        return twoDimArrayList;
    }

    private static List<List<Integer>> getHourGlass(List<List<Integer>> twoDimArrayList, int x, int y)
    {
        if (x >= twoDimArrayList.get(0).size() || y >= twoDimArrayList.size()) {
            return null;
        }
        List<List<Integer>> hourGlass = new ArrayList<>();
        // Get first row: a,b,c
        List<Integer> hourGlassFirstRow = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            hourGlassFirstRow.add(twoDimArrayList.get(x).get(y + i));
        }
        hourGlass.add(hourGlassFirstRow);
        // Get next row: d
        List<Integer> hourGlassSecondRow = new ArrayList<>();
        hourGlassSecondRow.add(0);
        hourGlassSecondRow.add(twoDimArrayList.get(x + 1).get(y + 1));
        hourGlassSecondRow.add(0);
        hourGlass.add(hourGlassSecondRow);
        // Get last row: e,f,g
        List<Integer> hourGlassThirdRow = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            hourGlassThirdRow.add(twoDimArrayList.get(x + 2).get(y + i));
        }
        hourGlass.add(hourGlassThirdRow);
        return hourGlass;
    }

    private static int sumTwoDimArrayList(List<List<Integer>> twoDimArrayList)
    {
        int total = 0;
        for (int i = 0; i < twoDimArrayList.get(0).size(); i++) {
            for (int j = 0; j < twoDimArrayList.size(); j++) {
                total += twoDimArrayList.get(i).get(j);
            }
        }
        return total;
    }
}
