package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
public class UtopianTree
{
    /**
     * Utopian Tree problem: https://www.hackerrank.com/challenges/utopian-tree/problem
     *
     * @param n The number of growth cycles to simulate.
     * @return The height of the tree after the given number of cycles.
     */
    public static int utopianTree(int n)
    {
        if (n <= 0) return 1;
        int height = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) height *= 2;
            else height++;
        }
        return height;
    }
}
