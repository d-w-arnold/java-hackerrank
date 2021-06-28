package ProblemSolving.Implementation.Medium;

import java.util.*;

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
        int total = (n - 1) * 2;
        total += Math.min(n - r_q, c_q - 1); // Top left diagonal
        total += Math.min(n - r_q, n - c_q); // Top right diagonal
        total += Math.min(r_q - 1, c_q - 1); // Bottom left diagonal
        total += Math.min(r_q - 1, n - c_q); // Bottom right diagonal
        System.out.println();
        // Reduce total to account for obstacles.
        if (k != 0) {
            Set<List<Integer>> obstructedCells = new HashSet<>();
            for (List<Integer> obstacle : obstacles) {
                if (!obstructedCells.contains(new ArrayList<>(obstacle)) && isObstructing(r_q, c_q, obstacle.get(0), obstacle.get(1))) {
                    updateObstructedCells(obstructedCells, n, r_q, c_q, obstacle.get(0), obstacle.get(1));
                }
            }
            return total - obstructedCells.size();
        } else {
            return total;
        }
    }

    private static void updateObstructedCells(Set<List<Integer>> obstructedCells, int n, int r_q, int c_q, int r_obs, int c_obs)
    {
        int r_diff = r_obs - r_q;
        int c_diff = c_obs - c_q;
        if (r_diff == 0) { // Same row
            if (c_diff < 0) { // Left of queen
                c_diff = -1;
            } else { // Right of queen
                c_diff = 1;
            }
            updateObstructedCellsHelper(obstructedCells, n, r_obs, c_obs, r_diff, c_diff);
        } else if (c_diff == 0) { // Same col
            if (r_diff > 0) { // Above queen
                r_diff = 1;
            } else { // Below queen
                r_diff = -1;
            }
            updateObstructedCellsHelper(obstructedCells, n, r_obs, c_obs, r_diff, c_diff);
        } else { // Must be on diag
            if ((r_diff > 0 && c_diff < 0) || (r_diff < 0 && c_diff > 0)) { // Bottom left to top right diag
                if (r_diff > 0) { // Above left of queen
                    r_diff = 1;
                    c_diff = -1;
                } else { // Below right of queen
                    r_diff = -1;
                    c_diff = 1;
                }
                updateObstructedCellsHelper(obstructedCells, n, r_obs, c_obs, r_diff, c_diff);
            } else { // Top left to bottom right diag
                if (r_diff > 0) { // Above right of queen
                    r_diff = 1;
                    c_diff = 1;
                } else { // Below left of queen
                    r_diff = -1;
                    c_diff = -1;
                }
                updateObstructedCellsHelper(obstructedCells, n, r_obs, c_obs, r_diff, c_diff);
            }
        }
    }

    private static void updateObstructedCellsHelper(Set<List<Integer>> obstructedCells, int n, int r_obs, int c_obs, int r_diff, int c_diff)
    {
        while (0 < r_obs && r_obs <= n && 0 < c_obs && c_obs <= n) {
            obstructedCells.add(new ArrayList<>(Arrays.asList(r_obs, c_obs)));
            r_obs += r_diff;
            c_obs += c_diff;
        }
    }

    private static boolean isObstructing(int r_q, int c_q, int r_obs, int c_obs)
    {
        return r_q == r_obs || c_q == c_obs || Math.abs(r_q - r_obs) == Math.abs(c_q - c_obs);
    }
}
