package InterviewPreparationKit.StacksAndQueues.Medium;

import java.util.ArrayList;
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
        if (grid.get(startX).charAt(startY) == 'X') return -1;
        int minimumMoves = -1;
        List<Integer[]> queue = getPossibleMoves(grid, new Integer[]{0, (int) 'S', startX, startY}, goalX, goalY);
        while (!queue.isEmpty()) {
            Integer[] entry = queue.remove(0);
            if (entry[1] == (int) 'F') { // 'F' denotes finished (currentX == goalX) and (currentY == goalY).
                minimumMoves = minimumMoves != -1 ? Math.min(entry[0], minimumMoves) : entry[0];
            } else {
                queue.addAll(getPossibleMoves(grid, entry, goalX, goalY));
            }
        }
        return minimumMoves;
    }

    private static List<Integer[]> getPossibleMoves(List<String> grid, Integer[] queueEntry, int goalX, int goalY)
    {
        int pastMoves = queueEntry[0]; // How many moves previously made by this queueEntry.
        int pastMove = queueEntry[1]; // The char value of the last move made Up/Down/Left/Right.
        int currentX = queueEntry[2];
        int currentY = queueEntry[3];
        List<Integer[]> possibleMoves = new ArrayList<>();
        if (pastMove == (int) 'S' || pastMove == (int) 'U' || pastMove == (int) 'D') { // Start/Up/Down
            if (currentY - 1 >= 0 && grid.get(currentX).charAt(currentY - 1) != 'X')
                possibleMoves.add(simulateMove(grid, pastMoves, 'L', currentX, currentY - 1, goalX, goalY));
            if (currentY + 1 < grid.get(currentX).length() && grid.get(currentX).charAt(currentY + 1) != 'X')
                possibleMoves.add(simulateMove(grid, pastMoves, 'R', currentX, currentY + 1, goalX, goalY));
        }
        if (pastMove == (int) 'S' || pastMove == (int) 'L' || pastMove == (int) 'R') { // Start/Left/Right
            if (currentX - 1 >= 0 && grid.get(currentX - 1).charAt(currentY) != 'X')
                possibleMoves.add(simulateMove(grid, pastMoves, 'U', currentX - 1, currentY, goalX, goalY));
            if (currentX + 1 < grid.size() && grid.get(currentX + 1).charAt(currentY) != 'X')
                possibleMoves.add(simulateMove(grid, pastMoves, 'D', currentX + 1, currentY, goalX, goalY));
        }
        return possibleMoves;
    }

    private static Integer[] simulateMove(List<String> grid, int pastMoves, char direction, int currentX, int currentY, int goalX, int goalY)
    {
        int i;
        if (direction == 'R') {
            for (i = currentY; i < grid.get(currentX).length(); i++) {
                if (currentX == goalX && i == goalY) return new Integer[]{pastMoves + 1, (int) 'F', currentX, i};
                if (grid.get(currentX).charAt(i) == 'X') break;
            }
            return new Integer[]{pastMoves + 1, (int) direction, currentX, i - 1};
        } else if (direction == 'D') {
            for (i = currentX; i < grid.size(); i++) {
                if (i == goalX && currentY == goalY) return new Integer[]{pastMoves + 1, (int) 'F', i, currentY};
                if (grid.get(i).charAt(currentY) == 'X') break;
            }
            return new Integer[]{pastMoves + 1, (int) direction, i - 1, currentY};
        } else if (direction == 'L') {
            for (i = currentY; i >= 0; i--) {
                if (currentX == goalX && i == goalY) return new Integer[]{pastMoves + 1, (int) 'F', currentX, i};
                if (grid.get(currentX).charAt(i) == 'X') break;
            }
            return new Integer[]{pastMoves + 1, (int) direction, currentX, i + 1};
        } else if (direction == 'U') {
            for (i = currentX; i >= 0; i--) {
                if (i == goalX && currentY == goalY) return new Integer[]{pastMoves + 1, (int) 'F', i, currentY};
                if (grid.get(i).charAt(currentY) == 'X') break;
            }
            return new Integer[]{pastMoves + 1, (int) direction, i + 1, currentY};
        }
        return null;
    }
}
