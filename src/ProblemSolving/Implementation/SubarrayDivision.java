package ProblemSolving.Implementation;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
public class SubarrayDivision
{
    /**
     * Subarray Division problem: https://www.hackerrank.com/challenges/the-birthday-bar/problem
     *
     * @param s The numbers on each of the squares of chocolate.
     * @param d Ron's birth day.
     * @param m Ron's birth month.
     * @return The number of ways the bar can be divided.
     */
    public static int birthday(List<Integer> s, int d, int m)
    {
        int total = 0;
        if (m > s.size() || d > listTotal(s)) {
            return 0;
        }
        int index = 0;
        while (inRange(s.size(), index, m)) {
            int tmpTotal = 0;
            for (int i = index; i < index + m; i++) {
                tmpTotal += s.get(i);
            }
            if (tmpTotal == d) {
                total++;
            }
            index++;
        }
        return total;
    }

    private static int listTotal(List<Integer> list)
    {
        int total = 0;
        for (int i : list) {
            total += i;
        }
        return total;
    }

    private static boolean inRange(int listSize, int startingPoint, int size)
    {
        if (0 <= startingPoint && 0 < size) {
            return (startingPoint + (size - 1)) < listSize;
        }
        return false;
    }
}
