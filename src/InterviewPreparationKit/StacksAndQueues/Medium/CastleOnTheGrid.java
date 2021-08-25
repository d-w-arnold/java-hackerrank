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
        char bc = 'X';
        if (grid.get(startX).charAt(startY) == bc || grid.get(goalX).charAt(goalY) == bc) return minimumMoves;
        char[][] gridArray = getGridArray(grid);
        Set<GridXY> blockedCells = getBlockedCells(gridArray, bc);
        if (blockedCells.isEmpty()) return (startX != goalX ? 1 : 0) + (startY != goalY ? 1 : 0);
        final Map<Dir, Dir> oppMoves = new HashMap<>();
        oppMoves.put(Dir.L, Dir.R);
        oppMoves.put(Dir.R, Dir.L);
        oppMoves.put(Dir.U, Dir.D);
        oppMoves.put(Dir.D, Dir.U);
        Map<GridXY, GridXY> visited = new HashMap<>();
        List<GridXY> queue = simulateMoves(gridArray, blockedCells, oppMoves, visited, new GridXY(startX, startY), goalX, goalY);
        while (!queue.isEmpty()) {
            GridXY qi = queue.remove(0);
            if (minimumMoves == -1 || qi.numMoves < minimumMoves)
                if (goalX == qi.x && goalY == qi.y) minimumMoves = qi.numMoves;
                else queue.addAll(simulateMoves(gridArray, blockedCells, oppMoves, visited, qi, goalX, goalY));
        }
        return minimumMoves;
    }

    private static Set<GridXY> getBlockedCells(char[][] grid, char bc)
    {
        Set<GridXY> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            char[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == bc) set.add(new GridXY(i, j));
            }
        }
        return set;
    }

    private static char[][] getGridArray(List<String> grid)
    {
        char[][] array = new char[grid.size()][grid.get(0).length()];
        for (int i = 0; i < grid.size(); i++) {
            String row = grid.get(i);
            for (int j = 0; j < row.length(); j++) {
                array[i][j] = row.charAt(j);
            }
        }
        return array;
    }

    private static List<GridXY> simulateMoves(char[][] grid, Set<GridXY> blockedCells, Map<Dir, Dir> oppMoves, Map<GridXY, GridXY> visited, GridXY qi, int goalX, int goalY)
    {
        List<GridXY> possibleMoves = new ArrayList<>();
        List<Dir> movesOrder = new ArrayList<>();
        for (Dir d : getMovesOrder(grid, oppMoves, qi, goalX - qi.x, goalY - qi.y)) {
            if (validMove(grid, blockedCells, oppMoves, d, qi)) movesOrder.add(d);
        }
        for (Dir d : movesOrder) {
            if (d == Dir.L)
                possibleMoves.add(new GridXY(qi.lastMove == Dir.L ? qi.numMoves : qi.numMoves + 1, Dir.L, qi.x, qi.y - 1));
            else if (d == Dir.R)
                possibleMoves.add(new GridXY(qi.lastMove == Dir.R ? qi.numMoves : qi.numMoves + 1, Dir.R, qi.x, qi.y + 1));
            else if (d == Dir.U)
                possibleMoves.add(new GridXY(qi.lastMove == Dir.U ? qi.numMoves : qi.numMoves + 1, Dir.U, qi.x - 1, qi.y));
            else if (d == Dir.D)
                possibleMoves.add(new GridXY(qi.lastMove == Dir.D ? qi.numMoves : qi.numMoves + 1, Dir.D, qi.x + 1, qi.y));
        }
        Iterator<GridXY> it = possibleMoves.iterator();
        while (it.hasNext()) {
            GridXY i = it.next();
            if (!visited.containsKey(i) || visited.get(i).numMoves >= i.numMoves) visited.put(i, i);
            else it.remove();
        }
        return possibleMoves;
    }

    private static List<Dir> getMovesOrder(char[][] grid, Map<Dir, Dir> oppMoves, GridXY qi, int diffX, int diffY)
    {
        List<Dir> moves = new ArrayList<>();
        if (diffX != 0 && diffY != 0) {
            if (diffX < 0 && diffY < 0) {
                moves.add(Dir.U);
                moves.add(Dir.L);
            } else if (diffX < 0) {
                moves.add(Dir.U);
                moves.add(Dir.R);
            } else if (diffY < 0) {
                moves.add(Dir.D);
                moves.add(Dir.L);
            } else {
                moves.add(Dir.D);
                moves.add(Dir.R);
            }
            if (Math.abs(diffX) < Math.abs(diffY)) Collections.reverse(moves);
            for (int i = new ArrayList<>(moves).size() - 1; i >= 0; i--) {
                moves.add(oppMoves.get(moves.get(i)));
            }
        } else if (diffX != 0) {
            moves.add(diffX < 0 ? Dir.U : Dir.D);
            moves.add(qi.y > ((grid[0].length - 1) / 2) ? Dir.L : Dir.R);
            moves.add(qi.y > ((grid[0].length - 1) / 2) ? Dir.R : Dir.L);
            moves.add(diffX < 0 ? Dir.D : Dir.U);
        } else if (diffY != 0) {
            moves.add(diffY < 0 ? Dir.L : Dir.R);
            moves.add(qi.x > ((grid.length - 1) / 2) ? Dir.U : Dir.D);
            moves.add(qi.x > ((grid.length - 1) / 2) ? Dir.D : Dir.U);
            moves.add(diffY < 0 ? Dir.R : Dir.L);
        }
        return moves;
    }

    private static boolean validMove(char[][] grid, Set<GridXY> blockedCells, Map<Dir, Dir> oppMoves, Dir direction, GridXY qi)
    {
        if (qi.lastMove == oppMoves.get(direction)) return false;
        if (direction == Dir.L)
            return qi.y - 1 >= 0 && !blockedCells.contains(new GridXY(qi.x, qi.y - 1));
        else if (direction == Dir.R)
            return qi.y + 1 < grid[qi.x].length && !blockedCells.contains(new GridXY(qi.x, qi.y + 1));
        else if (direction == Dir.U)
            return qi.x - 1 >= 0 && !blockedCells.contains(new GridXY(qi.x - 1, qi.y));
        else if (direction == Dir.D)
            return qi.x + 1 < grid.length && !blockedCells.contains(new GridXY(qi.x + 1, qi.y));
        else return false;
    }

    private enum Dir
    {
        L, R, U, D
    }

    private static class GridXY
    {
        int numMoves;
        Dir lastMove;
        int x, y;

        public GridXY(int x, int y)
        {
            this.numMoves = 0;
            this.lastMove = null;
            this.x = x;
            this.y = y;
        }

        public GridXY(int hops, Dir dir, int x, int y)
        {
            this.numMoves = hops;
            this.lastMove = dir;
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GridXY gridXy = (GridXY) o;
            return x == gridXy.x && y == gridXy.y;
        }

        @Override
        public int hashCode()
        {
            return 31 * x + y;
        }
    }
}
