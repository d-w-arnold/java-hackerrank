package InterviewPreparationKit.RecursionAndBacktracking.Medium;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 22/09/2021
 */
public class CrosswordPuzzle
{
    /**
     * Crossword Puzzle problem: https://www.hackerrank.com/challenges/crossword-puzzle/problem
     *
     * @param crossword An array of 10 strings of length 10 representing the empty grid.
     * @param words     A string consisting of semicolon delimited strings to fit into crossword.
     * @return An array of strings, each representing a row of the finished puzzle.
     */
    public static List<String> crosswordPuzzle(List<String> crossword, String words)
    {
        Puzzle puzzle = new Puzzle(crossword, words);
        puzzle.insertWordsOfUniqueLength();
        System.out.println();
        return Arrays.asList("NULL");
    }

    static class Puzzle
    {
        private char[][] crossword;
        private String[] words;
        private Map<Integer, List<String>> wordsMap; // Word length -> List of words of that length
        private List<Integer[]> blankWords;

        public Puzzle(List<String> crossword, String words)
        {
            this.crossword = new char[crossword.size()][crossword.get(0).length()];
            this.words = words.split(";");
            getWordsMap();
            getBlankWords(crossword);
        }

        private void getWordsMap()
        {
            this.wordsMap = new HashMap<>();
            for (String word : words) {
                int wordLength = word.length();
                if (wordsMap.containsKey(wordLength)) wordsMap.get(wordLength).add(word);
                else wordsMap.put(wordLength, new ArrayList<>(Collections.singletonList(word)));
            }
        }

        private void getBlankWords(List<String> crossword)
        {
            this.blankWords = new ArrayList<>();
            final char blank = '-';
            final String sep = ":";
            Map<String, Integer[]> cache = new HashMap<>(); // x:y:{0=horiz/1=vert} -> [xStart, yStart, {0=horiz/1=vert}, charsLength]
            char c, cRight, cDown;
            String xSepY, xSepYSepRight, xSepYSepDown;
            boolean containsRight, containsDown;
            for (int i = 0; i < crossword.size(); i++) {
                for (int j = 0; j < crossword.get(i).length(); j++) {
                    c = crossword.get(i).charAt(j);
                    this.crossword[i][j] = c;
                    if (c == blank) {
                        cRight = crossword.get(i).charAt(j + 1);
                        cDown = crossword.get(i + 1).charAt(j);
                        xSepY = i + sep + j;
                        xSepYSepRight = xSepY + sep + 0;
                        xSepYSepDown = xSepY + sep + 1;
                        containsRight = false;
                        containsDown = false;
                        if (cache.containsKey(xSepYSepRight) || cache.containsKey(xSepYSepDown)) {
                            if (cache.containsKey(xSepYSepRight)) {
                                containsRight = true;
                                if (cRight == blank) {
                                    Integer[] value = cache.get(xSepYSepRight);
                                    value[3]++;
                                    cache.put(i + sep + (j + 1) + sep + 0, value);
                                } else blankWords.add(cache.get(xSepYSepRight));
                                cache.remove(xSepYSepRight);
                            }
                            if (cache.containsKey(xSepYSepDown)) {
                                containsDown = true;
                                if (cDown == blank) {
                                    Integer[] value = cache.get(xSepYSepDown);
                                    value[3]++;
                                    cache.put((i + 1) + sep + j + sep + 1, value);
                                } else blankWords.add(cache.get(xSepYSepDown));
                                cache.remove(xSepYSepDown);
                            }
                        }
                        if (cRight == blank || cDown == blank) {
                            if (cRight == blank && !containsRight)
                                cache.put(i + sep + (j + 1) + sep + 0, new Integer[]{i, j, 0, 2});
                            if (cDown == blank && !containsDown)
                                cache.put((i + 1) + sep + j + sep + 1, new Integer[]{i, j, 1, 2});
                        } else if (!containsRight && !containsDown) blankWords.add(new Integer[]{i, j, 0, 1});
                    }
                }
            }
        }


        public void insertWordsOfUniqueLength()
        {
            String word;
            Iterator<Integer[]> it = blankWords.iterator();
            while (it.hasNext()) {
                Integer[] i = it.next();
                if (wordsMap.containsKey(i[3]) && wordsMap.get(i[3]).size() == 1) {
                    word = wordsMap.get(i[3]).get(0);
                    for (int j = 0; j < i[3]; j++) {
                        if (i[2] == 0) crossword[i[0]][i[1] + j] = word.charAt(j);
                        else if (i[2] == 1) crossword[i[0] + j][i[1]] = word.charAt(j);
                    }
                    it.remove();
                }
            }
        }
    }
}
