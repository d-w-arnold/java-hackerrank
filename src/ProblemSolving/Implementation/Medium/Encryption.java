package ProblemSolving.Implementation.Medium;

import java.util.LinkedHashMap;

/**
 * @author David W. Arnold
 * @version 08/07/2021
 */
public class Encryption
{
    /**
     * Encryption (transposition cipher) problem: https://www.hackerrank.com/challenges/encryption/problem
     *
     * @param s A string to encrypt.
     * @return The encrypted string.
     */
    public static String encryption(String s)
    {
        int row, col;
        int sr = (int) Math.sqrt(s.length());
        if (isPerfectSquare(s.length())) {
            row = sr;
            col = sr;
        } else {
            row = sr;
            col = row + 1;
        }
        LinkedHashMap<Integer, String> cols = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            int colIndex = i % col;
            if (cols.containsKey(colIndex)) {
                cols.put(colIndex, cols.get(colIndex) + tmp);
            } else {
                cols.put(colIndex, String.valueOf(tmp));
            }
        }
        return String.join(" ", cols.values());
    }

    private static boolean isPerfectSquare(int s)
    {
        if (s >= 0) {
            int sr = (int) Math.sqrt(s);
            System.out.println();
            return ((sr * sr) == s);
        }
        return false;
    }
}
