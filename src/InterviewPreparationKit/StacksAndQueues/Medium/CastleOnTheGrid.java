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
     * TODO: Achieve 100% score on Hackerrank, 4x tests failing due to timeout.
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
        char[][] gridArray = getGridArray(grid);
        GridXY curr = new GridXY(startX, startY);
        GridXY end = new GridXY(goalX, goalY);
        Set<GridXY> visited = new HashSet<>();
        visited.add(curr);
        Queue<GridXY> queue = new LinkedList<>();
        queue.add(curr);
        Queue<Integer> step = new LinkedList<>();
        step.add(0);
        while (!queue.isEmpty()) {
            GridXY nextGridXY = queue.remove();
            int hop = step.remove();
            if (nextGridXY.equals(end)) return hop;
            List<GridXY> next = getNext(gridArray, nextGridXY, visited);
            visited.addAll(next);
            queue.addAll(next);
            for (int i = 0; i < next.size(); i++) {
                step.add(hop + 1);
            }
        }
        return Integer.MAX_VALUE;
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

    private static List<GridXY> getNext(char[][] grid, GridXY curr, Set<GridXY> visited)
    {
        List<GridXY> next = new ArrayList<>();
        if (curr.dir == null || curr.dir == Dir.Y) {
            int x = curr.x;
            for (int i = x - 1; i >= 0; i--) {
                if (grid[i][curr.y] == 'X') break;
                final GridXY xy = new GridXY(i, curr.y, Dir.X);
                if (!visited.contains(xy)) next.add(xy);
            }
            for (int i = x + 1; i < grid.length; i++) {
                if (grid[i][curr.y] == 'X') break;
                final GridXY xy = new GridXY(i, curr.y, Dir.X);
                if (!visited.contains(xy)) next.add(xy);
            }
        }
        if (curr.dir == null || curr.dir == Dir.X) {
            int y = curr.y;
            for (int i = y - 1; i >= 0; i--) {
                if (grid[curr.x][i] == 'X') break;
                final GridXY xy = new GridXY(curr.x, i, Dir.Y);
                if (!visited.contains(xy)) next.add(xy);
            }
            for (int i = y + 1; i < grid.length; i++) {
                if (grid[curr.x][i] == 'X') break;
                final GridXY gridXy = new GridXY(curr.x, i, Dir.Y);
                if (!visited.contains(gridXy)) next.add(gridXy);
            }
        }
        return next;
    }

    private enum Dir
    {
        X, Y
    }

    private static class GridXY
    {
        int x, y;
        Dir dir;

        public GridXY(int x, int y)
        {
            this.x = x;
            this.y = y;
            dir = null;
        }

        public GridXY(int x, int y, Dir dir)
        {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GridXY gridXy = (GridXY) o;
            return x == gridXy.x && y == gridXy.y;
        }
    }
}
