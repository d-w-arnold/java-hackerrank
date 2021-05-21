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
}
