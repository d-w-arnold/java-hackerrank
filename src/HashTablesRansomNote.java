import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 24/05/2021
 */
public class HashTablesRansomNote
{
    /**
     * Hash Tables: Ransom Note problem: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
     *
     * @param magazine The words in the magazine.
     * @param note     The words in the ransom note.
     */
    public static void checkMagazine(List<String> magazine, List<String> note)
    {
        String yesMsg = "Yes";
        String noMsg = "No";
        Map<String, Integer> magazineWords = populateMap(magazine);
        boolean validMagazine = true;
        for (String w : note) {
            if (!magazineWords.containsKey(w)) {
                validMagazine = false;
                break;
            } else {
                if (magazineWords.get(w) > 0) {
                    magazineWords.put(w, magazineWords.get(w) - 1);
                } else {
                    validMagazine = false;
                    break;
                }
            }
        }
        if (validMagazine) {
            System.out.println(yesMsg);
        } else {
            System.out.println(noMsg);
        }
    }

    public static List<String> getWords(String s)
    {
        return Arrays.asList(s.split(" "));
    }

    private static Map<String, Integer> populateMap(List<String> words)
    {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            if (!map.containsKey(w)) {
                map.put(w, 1);
            } else {
                map.put(w, map.get(w) + 1);
            }
        }
        return map;
    }
}
