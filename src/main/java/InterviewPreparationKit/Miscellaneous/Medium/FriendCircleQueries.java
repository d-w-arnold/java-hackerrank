package InterviewPreparationKit.Miscellaneous.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 04/10/2021
 */
public class FriendCircleQueries
{
    /**
     * Friend Circle Queries problem: https://www.hackerrank.com/challenges/friend-circle-queries/problem
     *
     * @param queries An array of integer arrays, each with two elements indicating a new friendship.
     * @return Return an integer array of size q, whose value at index i is the size of the largest group present after processing the ith query.
     */
    public static int[] maxCircle(int[][] queries)
    {
        UnionFind uf = new UnionFind();
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            uf.union(queries[i][0], queries[i][1]);
            res[i] = uf.max;
        }
        return res;
    }

    private static class UnionFind
    {
        private final Map<Integer, Integer> PARENTS;
        private final Map<Integer, Integer> SIZES;
        private int max;

        public UnionFind()
        {
            PARENTS = new HashMap<>();
            SIZES = new HashMap<>();
            max = 0;
        }

        public void union(int v1, int v2)
        {
            if (!PARENTS.containsKey(v1)) {
                PARENTS.put(v1, v1);
                SIZES.put(v1, 1);
            }
            if (!PARENTS.containsKey(v2)) {
                PARENTS.put(v2, v2);
                SIZES.put(v2, 1);
            }
            int p1 = find(v1), p2 = find(v2);
            if (p1 == p2) return;
            int s1 = SIZES.get(p1), s2 = SIZES.get(p2);
            if (s1 < s2) {
                PARENTS.put(p1, p2);
                SIZES.put(p2, s1 + s2);
            } else {
                PARENTS.put(p2, p1);
                SIZES.put(p1, s1 + s2);
            }
            if (s1 + s2 > max) max = s1 + s2;
        }

        public int find(int v)
        {
            while (PARENTS.get(v) != v) {
                PARENTS.put(v, PARENTS.get(PARENTS.get(v)));
                v = PARENTS.get(v);
            }
            return v;
        }
    }
}
