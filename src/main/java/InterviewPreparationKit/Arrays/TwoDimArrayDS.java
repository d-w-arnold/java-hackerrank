package InterviewPreparationKit.Arrays;

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
        int largestSum = Integer.MIN_VALUE;
        for (int i = 0; i < (arr.get(0).size() - 2); i++) {
            for (int j = 0; j < (arr.size() - 2); j++) {
                largestSum = Math.max(largestSum, sumTwoDimArrayList(Objects.requireNonNull(getHourGlass(arr, i, j))));
            }
        }
        return largestSum;
    }

    private static List<List<Integer>> getHourGlass(List<List<Integer>> twoDimArrayList, int x, int y)
    {
        if (x >= twoDimArrayList.get(0).size() || y >= twoDimArrayList.size()) return null;
        List<List<Integer>> hourGlass = new ArrayList<>();
        List<Integer> tmpRow = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tmpRow.add(twoDimArrayList.get(x).get(y + i));
        }
        hourGlass.add(tmpRow);
        hourGlass.add(Arrays.asList(0, twoDimArrayList.get(x + 1).get(y + 1), 0));
        tmpRow = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tmpRow.add(twoDimArrayList.get(x + 2).get(y + i));
        }
        hourGlass.add(tmpRow);
        return hourGlass;
    }

    private static int sumTwoDimArrayList(List<List<Integer>> twoDimArrayList)
    {
        int total = 0;
        for (List<Integer> integers : twoDimArrayList) {
            for (Integer integer : integers) {
                total += integer;
            }
        }
        return total;
    }
}
