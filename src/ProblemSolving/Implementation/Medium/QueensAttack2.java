package ProblemSolving.Implementation.Medium;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 28/06/2021
 */
public class QueensAttack2
{
    /**
     * Queen's Attack II problem: https://www.hackerrank.com/challenges/queens-attack-2/problem
     *
     * @param n         The number of rows and columns in the board.
     * @param k         The number of obstacles on the board.
     * @param r_q       The row number of the queen's position.
     * @param c_q       The column number of the queen's position.
     * @param obstacles Each element is an array of 2 integers, the row and column of an obstacle.
     * @return The number of squares the queen can attack.
     */
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles)
    {
        // Calculate starting number of squares the queen can attack without any obstacles.
        // Reduce total to account for obstacles.
        return -2;
    }
}
