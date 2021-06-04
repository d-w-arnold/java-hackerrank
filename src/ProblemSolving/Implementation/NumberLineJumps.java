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
        if (v1 == v2) {
            // Both kangaroos jump the same distance.
            if (x1 == x2) {
                // Both kangaroos have the same starting point.
                return yesMsg;
            } else {
                // Both kangaroos don't have the same starting point.
                return noMsg;
            }
        } else if (x1 == x2) {
            // Both kangaroos have the same starting point, and don't jump the same distance.
            return noMsg;
        } else {
            // Both kangaroos don't have the same starting point, and don't jump the same distance.
            if (x1 > x2) {
                // Kangaroo 1 starts in front of kangaroo 2.
                if (sameLocationPossible(x1, v1, x2, v2)) {
                    return yesMsg;
                } else {
                    return noMsg;
                }
            } else {
                // Kangaroo 2 starts in front of kangaroo 1.
                if (sameLocationPossible(x2, v2, x1, v1)) {
                    return yesMsg;
                } else {
                    return noMsg;
                }
            }
        }
    }

    private static boolean sameLocationPossible(int leadStart, int leadJump, int tailStart, int tailJump)
    {
        if (leadJump > tailJump) {
            // The leading kangaroo is going to be getting further away from the tailing kangaroo.
            return false;
        } else {
            // The tailing kangaroo is going to start getting closer to the leading kangaroo.
            int leadPos = leadStart;
            int tailPos = tailStart;
            int diff = leadStart - tailStart;
            while (true) {
                if (diff > 0) {
                    leadPos += leadJump;
                    tailPos += tailJump;
                    diff = leadPos - tailPos;
                } else {
                    return diff == 0;
                }
            }
        }
    }
}
