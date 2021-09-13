package InterviewPreparationKit.StringManipulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
public class AlternatingCharacters
{
    /**
     * Alternating Characters problem: https://www.hackerrank.com/challenges/alternating-characters/problem
     *
     * @param s A String.
     * @return The minimum number of deletions required.
     */
    public static int alternatingCharacters(String s)
    {
        if (s.length() > 1) {
            List<Character> characterList = new ArrayList<>();
            for (char c : s.toCharArray()) {
                characterList.add(c);
            }
            boolean firstChar = true;
            char current = 0;
            int deleted = 0;
            Iterator<Character> it = characterList.iterator();
            while (it.hasNext()) {
                char nextChar = it.next();
                if (firstChar) {
                    current = nextChar;
                    firstChar = false;
                    continue;
                }
                if (current == nextChar) {
                    it.remove();
                    deleted++;
                } else {
                    current = nextChar;
                }
            }
            return deleted;
        }
        return 0;
    }
}
