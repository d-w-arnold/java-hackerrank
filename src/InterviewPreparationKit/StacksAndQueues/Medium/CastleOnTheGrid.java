package InterviewPreparationKit.StacksAndQueues.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 19/08/2021
 */
public class CastleOnTheGrid
{
    /**
     * Castle on the Grid problem: https://www.hackerrank.com/challenges/castle-on-the-grid/problem
     *
     * @param grid   An array of strings that represent the rows of the grid.
     * @param startX Starting X coordinate.
     * @param startY Starting Y coordinate.
     * @param goalX  Ending X coordinate.
     * @param goalY  Ending Y coordinate.
     * @return The minimum moves to reach the goal.
     */
    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY)
    {
        int minimumMoves = -1;
        char s = 'S';
        char f = 'F';
        char bc = 'X';
        if (grid.get(startX).charAt(startY) == bc || grid.get(goalX).charAt(goalY) == bc) return -1;
        List<Integer[]> queue = getPossibleMoves(grid, new Integer[]{0, (int) s, startX, startY}, goalX, goalY, bc, f);
        while (!queue.isEmpty()) {
            Integer[] entry = queue.remove(0);
            if (entry[1] == (int) f)
                minimumMoves = minimumMoves != -1 ? Math.min(entry[0], minimumMoves) : entry[0];
            else queue.addAll(getPossibleMoves(grid, entry, goalX, goalY, bc, f));
        }
        return minimumMoves;
    }

    private static List<Integer[]> getPossibleMoves(List<String> grid, Integer[] queueEntry, int goalX, int goalY, char blockedCell, char finished)
    {
        char l = 'L'; // Left move
        char r = 'R'; // Right move
        char u = 'U'; // Up move
        char d = 'D'; // Down move
        int pastMove = queueEntry[1]; // The char value of the last move made Up/Down/Left/Right.
        int currX = queueEntry[2];
        int currY = queueEntry[3];
        List<Integer[]> possibleMoves = new ArrayList<>();
        if (pastMove != (int) r && currY - 1 >= 0
                && isNotBlockedCell(grid, l, currX, currY, blockedCell, l, r, u, d)) {
            Integer[] tmpQueueEntry = Arrays.copyOf(queueEntry, queueEntry.length);
            tmpQueueEntry[3] -= 1;
            possibleMoves.add(simulateMove(l, tmpQueueEntry, goalX, goalY, finished));
        }
        if (pastMove != (int) l && currY + 1 < grid.get(currX).length()
                && isNotBlockedCell(grid, r, currX, currY, blockedCell, l, r, u, d)) {
            Integer[] tmpQueueEntry = Arrays.copyOf(queueEntry, queueEntry.length);
            tmpQueueEntry[3] += 1;
            possibleMoves.add(simulateMove(r, tmpQueueEntry, goalX, goalY, finished));
        }
        if (pastMove != (int) d && currX - 1 >= 0
                && isNotBlockedCell(grid, u, currX, currY, blockedCell, l, r, u, d)) {
            Integer[] tmpQueueEntry = Arrays.copyOf(queueEntry, queueEntry.length);
            tmpQueueEntry[2] -= 1;
            possibleMoves.add(simulateMove(u, tmpQueueEntry, goalX, goalY, finished));
        }
        if (pastMove != (int) u && currX + 1 < grid.size()
                && isNotBlockedCell(grid, d, currX, currY, blockedCell, l, r, u, d)) {
            Integer[] tmpQueueEntry = Arrays.copyOf(queueEntry, queueEntry.length);
            tmpQueueEntry[2] += 1;
            possibleMoves.add(simulateMove(d, tmpQueueEntry, goalX, goalY, finished));
        }
        return possibleMoves;
    }

    private static boolean isNotBlockedCell(List<String> grid, char direction, int currX, int currY, char blockedCell, char l, char r, char u, char d)
    {
        if (direction == l) return grid.get(currX).charAt(currY - 1) != blockedCell;
        else if (direction == r) return grid.get(currX).charAt(currY + 1) != blockedCell;
        else if (direction == u) return grid.get(currX - 1).charAt(currY) != blockedCell;
        else if (direction == d) return grid.get(currX + 1).charAt(currY) != blockedCell;
        else return false;
    }

    private static Integer[] simulateMove(char direction, Integer[] queueEntry, int goalX, int goalY, char f)
    {
        int currX = queueEntry[2];
        int currY = queueEntry[3];
        int newPastMoves = queueEntry[0];
        int newDirection = direction;
        if (queueEntry[1] != (int) direction) newPastMoves++;
        if (currX == goalX && currY == goalY) newDirection = 'F';
        return new Integer[]{newPastMoves, newDirection, currX, currY};
    }
}
