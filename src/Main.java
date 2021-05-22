import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {
        extraLongFactorials(50);
        extraLongFactorials(100);

        Integer[] array1 = {0, 0, 1, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(new ArrayList<>(Arrays.asList(array1))) + "\n");
        Integer[] array2 = {0, 1, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(new ArrayList<>(Arrays.asList(array2))) + "\n");
        Integer[] array3 = {0, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(new ArrayList<>(Arrays.asList(array3))) + "\n");

        System.out.println(repeatedString("abcac", 10));
        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 1000000000000L));
        System.out.println(repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L));
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
        System.out.println(bigInt + "\n");
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
}
