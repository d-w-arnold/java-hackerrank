package InterviewPreparationKit.StringManipulation.Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 07/08/2021
 */
public class SpecialStringAgain
{
    /**
     * Special String Again problem: https://www.hackerrank.com/challenges/special-palindrome-again/problem
     *
     * @param n The length of string s.
     * @param s A string.
     * @return The number of special substrings.
     */
    public static long substrCount(int n, String s)
    {
        s += " ";
        List<Point> l = new ArrayList<>();
        long count = 1;
        char c = s.charAt(0);
        for (int i = 1; i <= n; i++) {
            if (c == s.charAt(i)) count++;
            else {
                l.add(new Point(c, count));
                count = 1;
                c = s.charAt(i);
            }
        }
        count = 0;
        if (l.size() >= 3) {
            Iterator<Point> itr = l.iterator();
            Point prev, curr, next;
            curr = itr.next();
            next = itr.next();
            count = (curr.COUNT * (curr.COUNT + 1)) / 2;
            for (int i = 1; i < l.size() - 1; i++) {
                prev = curr;
                curr = next;
                next = itr.next();
                count += (curr.COUNT * (curr.COUNT + 1)) / 2;
                if (prev.KEY == next.KEY && curr.COUNT == 1) count += Math.min(prev.COUNT, next.COUNT);
            }
            count += (next.COUNT * (next.COUNT + 1)) / 2;
        } else {
            for (Point curr : l) {
                count += (curr.COUNT * (curr.COUNT + 1)) / 2;
            }
        }
        return count;
    }

    private static class Point
    {
        private final char KEY;
        private final long COUNT;

        public Point(char x, long y)
        {
            KEY = x;
            COUNT = y;
        }
    }
}
