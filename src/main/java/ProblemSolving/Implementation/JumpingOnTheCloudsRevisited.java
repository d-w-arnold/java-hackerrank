package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 23/06/2021
 */
public class JumpingOnTheCloudsRevisited
{
    /**
     * Jumping on the Clouds (Revisited) problem: https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
     *
     * @param c The cloud types along the path.
     * @param k The length of one jump.
     * @return The energy level remaining.
     */
    public static int jumpingOnClouds(int[] c, int k)
    {
        int e = 100;
        int index = 0;
        do {
            index = (index + k) % c.length;
            e--;
            if (c[index] == 1) e -= 2;
        } while (index != 0);
        return e;
    }
}
