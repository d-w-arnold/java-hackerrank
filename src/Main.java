import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("\nextraLongFactorials");

        extraLongFactorials(50);
        extraLongFactorials(100);

        System.out.println("\njumpingOnClouds");

        Integer[] array1 = {0, 0, 1, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(new ArrayList<>(Arrays.asList(array1))));
        Integer[] array2 = {0, 1, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(new ArrayList<>(Arrays.asList(array2))));
        Integer[] array3 = {0, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(new ArrayList<>(Arrays.asList(array3))));

        System.out.println("\nrepeatedString");

        System.out.println(repeatedString("abcac", 10));
        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 1000000000000L));
        System.out.println(repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L));

        System.out.println("\nhourglassSum");

        Integer[][] twoDimArray1 = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println(hourglassSum(covertTwoDimArrayToArrayList(twoDimArray1)));
        Integer[][] twoDimArray2 = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println(hourglassSum(covertTwoDimArrayToArrayList(twoDimArray2)));
        Integer[][] twoDimArray3 = {
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}
        };
        System.out.println(hourglassSum(covertTwoDimArrayToArrayList(twoDimArray3)));
        Integer[][] twoDimArray4 = {
                {0, -4, -6, 0, -7, -6},
                {-1, -2, -6, -8, -3, -1},
                {-8, -4, -2, -8, -8, -6},
                {-3, -1, -2, -5, -7, -4},
                {-3, -5, -3, -6, -6, -6},
                {-3, -6, 0, -8, -6, -7}
        };
        System.out.println(hourglassSum(covertTwoDimArrayToArrayList(twoDimArray4)));

        System.out.println("\n");
    }

    /**
     * Get n factorial (n!)
     *
     * @param n Input between 0-100
     */
    private static void extraLongFactorials(int n)
    {
        BigInteger bigInt = new BigInteger(String.valueOf(n));
        for (int i = n - 1; i > 0; i--) {
            bigInt = bigInt.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(bigInt);
    }

    /**
     * Cloud hoping game problem: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
     *
     * @param c The list of binary numbers denoting good and bad clouds.
     * @return The smallest number of hops.
     */
    public static int jumpingOnClouds(List<Integer> c)
    {
        System.out.println(c);
        int goodCloud = 0;
        int badCloud = 1;
        int[] validMoves = {1, 2};
        int index = 0;
        int hops = 0;
        while (index != (c.size() - 1)) {
            for (int i = validMoves.length - 1; i >= 0; i--) {
                int move = validMoves[i];
                if ((index + move) < c.size() && c.get(index + move) != badCloud && c.get(index + move) == goodCloud) {
                    index += move;
                    hops++;
                    break;
                }
            }
        }
        return hops;
    }

    /**
     * Repeated string problem: https://www.hackerrank.com/challenges/repeated-string/problem
     *
     * @param s The string to be repeated.
     * @param n The number of characters to consider.
     * @return The number of times the letter 'a' appears in the string of characters considered.
     */
    public static long repeatedString(String s, long n)
    {
        char aChar = 'a';
        if (s.length() <= 1) {
            if (s.length() == 0) {
                return 0;
            } else if (s.charAt(0) == aChar) {
                return s.length() * n;
            }
        }
        long count = 0;
        long remainder = n % s.length();
        long times = (n - remainder) / s.length();
        if (times > 0) {
            for (int i = 0; i < s.length(); i++) {
                char letter = s.charAt(i);
                if (letter == aChar) {
                    count++;
                }
            }
            count *= times;
        }
        if (remainder > 0) {
            for (int i = 0; i < remainder; i++) {
                char letter = s.charAt(i);
                if (letter == aChar) {
                    count++;
                }
            }
        }
        return count;
    }

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

    private static List<List<Integer>> covertTwoDimArrayToArrayList(Integer[][] twoDimArray)
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
