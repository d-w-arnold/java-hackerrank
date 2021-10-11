package InterviewPreparationKit.Miscellaneous.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 04/10/2021
 */
public class MaximumXor
{
    /**
     * Maximum Xor problem: https://www.hackerrank.com/challenges/maximum-xor/problem
     *
     * @param arr     An array of integers.
     * @param queries An array of integers to query.
     * @return An array of integers, each representing the maximum xor value for each element queries[j] against all elements of arr.
     */
    public static int[] maxXor(int[] arr, int[] queries)
    {
        int[] ans = new int[queries.length];
        Node trie = new Node();
        Node node;
        List<Integer> arrQueries = new ArrayList<>();
        for (int a : arr) {
            arrQueries.add(a);
        }
        for (int q : queries) {
            arrQueries.add(q);
        }
        int k = Integer.toBinaryString(Collections.max(arrQueries)).length();
        String formatStr = "";
        List<String> numbers = new ArrayList<>();
        for (int a : arr) {
            formatStr = "%" + String.format("%d", k) + "s";
            numbers.add(String.format(formatStr, Integer.toBinaryString(a)).replace(' ', '0'));
        }
        for (String number : numbers) {
            node = trie;
            for (char c : number.toCharArray()) {
                if (c == '0') {
                    if (node.zero == null) node.zero = new Node();
                    node = node.zero;
                } else if (c == '1') {
                    if (node.one == null) node.one = new Node();
                    node = node.one;
                }
            }
        }
        int index = 0;
        String tmp;
        StringBuilder s;
        for (int n : queries) {
            node = trie;
            s = new StringBuilder();
            for (char c : String.format(formatStr, Integer.toBinaryString(n)).replace(' ', '0').toCharArray()) {
                tmp = Integer.toString(Integer.parseInt(Character.toString(c)) ^ 1);
                if (tmp.equals("0")) tmp = node.zero != null ? tmp : Character.toString(c);
                else if (tmp.equals("1")) tmp = node.one != null ? tmp : Character.toString(c);
                s.append(tmp);
                if (tmp.equals("0")) node = node.zero;
                else if (tmp.equals("1")) node = node.one;
            }
            ans[index] = Integer.parseInt(s.toString(), 2) ^ n;
            index++;
        }
        return ans;
    }

    static class Node
    {
        Node zero, one;

        public Node()
        {
            this.zero = null;
            this.one = null;
        }
    }
}
