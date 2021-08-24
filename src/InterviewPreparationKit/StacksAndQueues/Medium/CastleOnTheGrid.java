package InterviewPreparationKit.StacksAndQueues.Medium;

import java.util.*;

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
        if (grid.get(startX).charAt(startY) == 'X' || grid.get(goalX).charAt(goalY) == 'X') return minimumMoves;
        final Map<Character, Character> oppMoves = new HashMap<>();
        oppMoves.put('L', 'R');
        oppMoves.put('R', 'L');
        oppMoves.put('U', 'D');
        oppMoves.put('D', 'U');
        final Set<String> blockedCells = getBlockedCells(grid);
        List<Integer[]> queue = simulateMoves(grid, oppMoves, blockedCells, new Integer[]{0, (int) 'F', goalX, goalY}, startX, startY);
        while (!queue.isEmpty()) {
            Integer[] entry = queue.remove(0);
            if (minimumMoves == -1 || entry[0] < minimumMoves) {
                if (startX == entry[2] && startY == entry[3]) {
                    minimumMoves = entry[0];
                } else queue.addAll(simulateMoves(grid, oppMoves, blockedCells, entry, goalX, goalY));
            }
        }
        return minimumMoves;
    }

    private static Set<String> getBlockedCells(List<String> grid)
    {
        Set<String> blockedCells = new HashSet<>();
        for (int i = 0; i < grid.size(); i++) {
            String row = grid.get(i);
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == 'X') blockedCells.add(i + "-" + j);
            }
        }
        return blockedCells;
    }

    private static List<Integer[]> simulateMoves(List<String> grid, Map<Character, Character> oppMoves, Set<String> blockedCells, Integer[] queueEntry, int startX, int startY)
    {
        List<Integer[]> possibleMoves = new ArrayList<>();
        int currX = queueEntry[2];
        int currY = queueEntry[3];
        List<Character> movesOrder = new ArrayList<>();
        for (char c : getMovesOrder(grid, oppMoves, currX, currY, startX - currX, startY - currY)) {
            if (validMove(grid, oppMoves, blockedCells, c, queueEntry[1], currX, currY)) movesOrder.add(c);
        }
        Integer[] tmpQueueEntry;
        for (char c : movesOrder) {
            tmpQueueEntry = Arrays.copyOf(queueEntry, queueEntry.length);
            if (c == 'L') {
                tmpQueueEntry[3] -= 1;
                possibleMoves.add(simulateMove('L', tmpQueueEntry));
            } else if (c == 'R') {
                tmpQueueEntry[3] += 1;
                possibleMoves.add(simulateMove('R', tmpQueueEntry));
            } else if (c == 'U') {
                tmpQueueEntry[2] -= 1;
                possibleMoves.add(simulateMove('U', tmpQueueEntry));
            } else if (c == 'D') {
                tmpQueueEntry[2] += 1;
                possibleMoves.add(simulateMove('D', tmpQueueEntry));
            }
        }
        return possibleMoves;
    }

    private static List<Character> getMovesOrder(List<String> grid, Map<Character, Character> oppMoves, int currX, int currY, int diffX, int diffY)
    {
        List<Character> moves = new ArrayList<>();
        if (diffX != 0 && diffY != 0) {
            if (diffX < 0 && diffY < 0) {
                moves.add('U');
                moves.add('L');
            } else if (diffX < 0 && diffY > 0) {
                moves.add('U');
                moves.add('R');
            } else if (diffX > 0 && diffY < 0) {
                moves.add('D');
                moves.add('L');
            } else if (diffX > 0 && diffY > 0) {
                moves.add('D');
                moves.add('R');
            }
            if (Math.abs(diffX) < Math.abs(diffY)) Collections.reverse(moves);
            for (int i = new ArrayList<>(moves).size() - 1; i >= 0; i--) {
                moves.add(oppMoves.get(moves.get(i)));
            }
        } else if (diffX != 0) {
            moves.add(diffX < 0 ? 'U' : 'D');
            moves.add(currY > ((grid.get(0).length() - 1) / 2) ? 'L' : 'R');
            moves.add(currY > ((grid.get(0).length() - 1) / 2) ? 'R' : 'L');
            moves.add(diffX < 0 ? 'D' : 'U');
        } else if (diffY != 0) {
            moves.add(diffY < 0 ? 'L' : 'R');
            moves.add(currX > ((grid.size() - 1) / 2) ? 'U' : 'D');
            moves.add(currX > ((grid.size() - 1) / 2) ? 'D' : 'U');
            moves.add(diffY < 0 ? 'R' : 'L');
        }
        return moves;
    }

    private static boolean validMove(List<String> grid, Map<Character, Character> oppMoves, Set<String> blockedCells, char direction, int pastMove, int currX, int currY)
    {
        return pastMove != oppMoves.get(direction) && isInbounds(grid, direction, currX, currY) &&
                !blockedCells.contains(getAdj(direction, currX, currY));
    }

    private static boolean isInbounds(List<String> grid, char direction, int currX, int currY)
    {
        if (direction == 'L') return currY - 1 >= 0;
        else if (direction == 'R') return currY + 1 < grid.get(currX).length();
        else if (direction == 'U') return currX - 1 >= 0;
        else if (direction == 'D') return currX + 1 < grid.size();
        return false;
    }

    private static String getAdj(char direction, int currX, int currY)
    {
        if (direction == 'L') return currX + "-" + (currY - 1);
        else if (direction == 'R') return currX + "-" + (currY + 1);
        else if (direction == 'U') return (currX - 1) + "-" + currY;
        else if (direction == 'D') return (currX + 1) + "-" + currY;
        return null;
    }

    private static Integer[] simulateMove(char direction, Integer[] queueEntry)
    {
        int newPastMoves = queueEntry[0];
        if (queueEntry[1] != (int) direction) newPastMoves++;
        return new Integer[]{newPastMoves, (int) direction, queueEntry[2], queueEntry[3]};
    }
}
