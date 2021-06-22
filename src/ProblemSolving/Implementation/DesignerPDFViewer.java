package ProblemSolving.Implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
public class DesignerPDFViewer
{
    /**
     * Designer PDF Viewer problem: https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
     *
     * @param h    The heights of each letter.
     * @param word A string.
     * @return The size of the highlighted area.
     */
    public static int designerPdfViewer(List<Integer> h, String word)
    {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> heights = new HashMap<>();
        for (int i = 0; i < h.size(); i++) {
            heights.put(alphabet.charAt(i), h.get(i));
        }
        int tallestLetter = 0;
        for (char c : word.toCharArray()) {
            tallestLetter = Math.max(heights.get(c), tallestLetter);
        }
        return tallestLetter * word.length();
    }
}
