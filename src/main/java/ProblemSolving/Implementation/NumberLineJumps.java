package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
public class NumberLineJumps
{
    /**
     * Number Line Jumps problem: https://www.hackerrank.com/challenges/kangaroo/problem
     *
     * @param x1 Starting position for kangaroo 1.
     * @param v1 Jump distance for kangaroo 1.
     * @param x2 Starting position for kangaroo 2.
     * @param v2 Jump distance for kangaroo 2.
     * @return Either YES or NO.
     */
    public static String kangaroo(int x1, int v1, int x2, int v2)
    {
        String yesMsg = "YES";
        String noMsg = "NO";
        if (v1 == v2) return x1 == x2 ? yesMsg : noMsg;
        else if (x1 == x2) return noMsg;
        else if (x1 > x2) return sameLocationPossible(x1, v1, x2, v2) ? yesMsg : noMsg;
        else return sameLocationPossible(x2, v2, x1, v1) ? yesMsg : noMsg;
    }

    private static boolean sameLocationPossible(int leadStart, int leadJump, int tailStart, int tailJump)
    {
        if (leadJump <= tailJump) {
            int leadPos = leadStart, tailPos = tailStart, diff = leadStart - tailStart;
            while (true) {
                if (diff <= 0) return diff == 0;
                leadPos += leadJump;
                tailPos += tailJump;
                diff = leadPos - tailPos;
            }
        }
        return false;
    }
}
