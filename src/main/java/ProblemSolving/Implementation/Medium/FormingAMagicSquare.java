package ProblemSolving.Implementation.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            int ans = Integer.MAX_VALUE;
            List<List<Integer>> magicSquares = new ArrayList<>();
            findMagicSquares(magicSquares);
            for (List<Integer> magicSquare : magicSquares) {
                ans = Math.min(ans, findMatrixDiff(s, listToTwoDimMatrix(magicSquare)));
            }
            return ans;
        }
        return -1;
    }

    private static void findMagicSquares(List<List<Integer>> magicSquares)
    {
        List<Integer> elements = IntStream.rangeClosed(1, 9).boxed().collect(Collectors.toList());
        getMagicSquares(elements.size(), elements, magicSquares, elements.get(9 / 2));
    }

    public static void getMagicSquares(int n, List<Integer> elements, List<List<Integer>> magicSquares, int median)
    {
        if (n == 1) {
            if (elements.get(median - 1) == median && isMagicSquare(elements)) {
                magicSquares.add(new ArrayList<>(elements));
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                getMagicSquares(n - 1, elements, magicSquares, median);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            getMagicSquares(n - 1, elements, magicSquares, median);
        }
    }

    private static void swap(List<Integer> input, int a, int b)
    {
        int tmp = input.get(a);
        input.set(a, input.get(b));
        input.set(b, tmp);
    }

    private static boolean isMagicSquare(List<Integer> list)
    {
        // Convert list into 3 x 3 matrix.
        int[][] a = listToTwoDimMatrix(list);
        // Get the total of the first row.
        int s = 0;
        for (int j = 0; j < 3; ++j) {
            s += a[0][j];
        }
        // Checking if each row sum is same.
        for (int i = 1; i <= 2; ++i) {
            int tmp = 0;
            for (int j = 0; j < 3; ++j) {
                tmp += a[i][j];
            }
            if (tmp != s) return false;
        }
        // Checking if each column sum is same.
        for (int j = 0; j < 3; ++j) {
            int tmp = 0;
            for (int i = 0; i < 3; ++i) {
                tmp += a[i][j];
            }
            if (tmp != s) return false;
        }
        // Checking if diagonal 'top left to bottom right' sum is same.
        int tmp = 0;
        for (int i = 0; i < 3; ++i) {
            tmp += a[i][i];
        }
        if (tmp != s) return false;
        // Checking if diagonal 'top right to bottom left' sum is same.
        tmp = 0;
        for (int i = 0; i < 3; ++i) {
            tmp += a[2 - i][i];
        }
        return tmp == s;
    }

    private static int[][] listToTwoDimMatrix(List<Integer> list)
    {
        int[][] twoDimMatrix = new int[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                twoDimMatrix[i][j] = list.get(3 * i + j);
            }
        }
        return twoDimMatrix;
    }

    private static int findMatrixDiff(List<List<Integer>> oldS, int[][] newS)
    {
        int count = 0;
        for (int i = 0; i < oldS.size(); i++) {
            for (int j = 0; j < oldS.get(i).size(); j++) {
                int oldVal = oldS.get(i).get(j);
                int newVal = newS[i][j];
                if (oldVal != newVal) count += Math.abs(oldVal - newVal);
            }
        }
        return count;
    }
}
