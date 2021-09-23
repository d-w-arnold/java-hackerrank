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
        puzzle.insertWords();
        return puzzle.printCrosswordPuzzle();
    }

    static class Puzzle
    {
        private final char blank = '-';
        private final char nonBlank = '+';
        private final String sep = ":";
        private final char[][] crossword;
        private final Set<String> words;
        private final Stack<String> usedWords;
        private final Map<Integer, Set<String>> wordsMap; // Word length -> List of words of that length
        private final Map<Integer, Integer[]> blankWords;
        private final Map<Integer, String> nonBlankWords;
        private final Map<Integer, Set<String>> blankWordPossibilities;
        private final Queue<Integer> blankWordQueue;
        private final Map<String, Character> blankCells; // x:y -> character in cell
        private final Stack<String> updatedCells;
        private Map<Integer, String> blankWordTemplates;

        public Puzzle(List<String> crossword, String words)
        {
            this.crossword = new char[crossword.size()][crossword.get(0).length()];
            this.words = new HashSet<>(Arrays.asList(words.split(";")));
            this.wordsMap = new HashMap<>();
            this.usedWords = new Stack<>();
            this.blankWords = new HashMap<>();
            this.nonBlankWords = new HashMap<>();
            this.blankWordPossibilities = new HashMap<>();
            this.blankWordQueue = new LinkedList<>();
            this.blankCells = new HashMap<>();
            this.updatedCells = new Stack<>();
            this.blankWordTemplates = new HashMap<>();
            getWordsAndWordsMap();
            getBlankWordsAndCells(crossword);
        }

        private void getWordsAndWordsMap()
        {
            for (String word : this.words) {
                int wordLength = word.length();
                if (wordsMap.containsKey(wordLength)) wordsMap.get(wordLength).add(word);
                else wordsMap.put(wordLength, new HashSet<>(Collections.singletonList(word)));
            }
        }

        private void getBlankWordsAndCells(List<String> crossword)
        {
            Map<String, Integer[]> cache = new HashMap<>(); // x:y:{0=horiz/1=vert} -> [xStart, yStart, {0=horiz/1=vert}, charsLength]
            char c, cRight, cDown;
            String xSepY, xSepYSepRight, xSepYSepDown;
            boolean containsRight, containsDown;
            int index = 0;
            for (int i = 0; i < crossword.size(); i++) {
                for (int j = 0; j < crossword.get(i).length(); j++) {
                    c = crossword.get(i).charAt(j);
                    this.crossword[i][j] = c;
                    if (c == blank) {
                        xSepY = i + sep + j;
                        blankCells.put(xSepY, blank);
                        xSepYSepRight = xSepY + sep + 0;
                        xSepYSepDown = xSepY + sep + 1;
                        containsRight = false;
                        containsDown = false;
                        cRight = crossword.get(i).charAt(j + 1);
                        cDown = i + 1 < crossword.size() ? crossword.get(i + 1).charAt(j) : nonBlank;
                        if (cache.containsKey(xSepYSepRight) || cache.containsKey(xSepYSepDown)) {
                            if (cache.containsKey(xSepYSepRight)) {
                                containsRight = true;
                                if (cRight == blank) {
                                    Integer[] value = cache.get(xSepYSepRight);
                                    value[3]++;
                                    cache.put(i + sep + (j + 1) + sep + 0, value);
                                } else {
                                    blankWords.put(index, cache.get(xSepYSepRight));
                                    index++;
                                }
                                cache.remove(xSepYSepRight);
                            }
                            if (cache.containsKey(xSepYSepDown)) {
                                containsDown = true;
                                if (cDown == blank) {
                                    Integer[] value = cache.get(xSepYSepDown);
                                    value[3]++;
                                    cache.put((i + 1) + sep + j + sep + 1, value);
                                } else {
                                    blankWords.put(index, cache.get(xSepYSepDown));
                                    index++;
                                }
                                cache.remove(xSepYSepDown);
                            }
                        }
                        if (cRight == blank || cDown == blank) {
                            if (cRight == blank && !containsRight)
                                cache.put(i + sep + (j + 1) + sep + 0, new Integer[]{i, j, 0, 2});
                            if (cDown == blank && !containsDown)
                                cache.put((i + 1) + sep + j + sep + 1, new Integer[]{i, j, 1, 2});
                        } else if (!containsRight && !containsDown) {
                            blankWords.put(index, new Integer[]{i, j, 0, 1});
                            index++;
                        }
                    }
                }
            }
        }

        public void insertWords()
        {
            insertWordsOfUniqueLength();
            getBlankWordTemplates();
            List<String> matches;
            String blankWordTemplate;
            Integer[] i;
            int wordLen;
            while (!blankWordQueue.isEmpty()) {
                int entry = blankWordQueue.remove();
                matches = new ArrayList<>();
                blankWordTemplate = blankWordTemplates.get(entry);
                for (String word : words) {
                    if (matchesTemplate(word, blankWordTemplate)) matches.add(word);
                }
                if (matches.size() == 1) {
                    String word = matches.get(0);
                    i = blankWords.get(entry);
                    wordLen = i[3];
                    updateBlankCells(word, i, wordLen);
                    words.remove(word);
                    usedWords.add(word);
                    wordsMap.get(wordLen).remove(word);
                    nonBlankWords.put(entry, word);
                    blankWordPossibilities.remove(entry);
                    blankWordTemplates.remove(entry);
                } else if (matches.size() > 1) blankWordPossibilities.get(entry).addAll(matches);
            }
            // TODO: Brute force any multiple matches for a given blankWord slot.
            System.out.println();
            for (Map.Entry<String, Character> entry : blankCells.entrySet()) {
                String[] s = entry.getKey().split(sep);
                crossword[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = entry.getValue();
            }
        }

        private void insertWordsOfUniqueLength()
        {
            String word;
            int wordLen;
            for (int k = 0; k < blankWords.size(); k++) {
                if (!nonBlankWords.containsKey(k) && blankWords.containsKey(k)) {
                    Integer[] i = blankWords.get(k);
                    wordLen = i[3];
                    if (wordsMap.containsKey(wordLen) && wordsMap.get(wordLen).size() == 1) {
                        word = wordsMap.get(wordLen).iterator().next();
                        updateBlankCells(word, i, wordLen);
                        words.remove(word);
                        usedWords.add(word);
                        wordsMap.remove(wordLen);
                        nonBlankWords.put(k, word);
                    }
                }
            }
        }

        private void updateBlankCells(String word, Integer[] i, int wordLen)
        {
            int tmpX, tmpY;
            for (int j = 0; j < wordLen; j++) {
                tmpX = i[0];
                tmpY = i[1];
                if (i[2] == 0) tmpY += j;
                else if (i[2] == 1) tmpX += j;
                String xSepY = tmpX + sep + tmpY;
                blankCells.put(xSepY, word.charAt(j));
                updatedCells.add(xSepY);
            }
        }

        private void getBlankWordTemplates()
        {
            blankWordTemplates = new HashMap<>();
            Set<Integer> addedToQueue = new HashSet<>();
            Integer[] i;
            StringBuilder sb;
            int tmpX, tmpY;
            char c;
            for (int j = 0; j < blankWords.size(); j++) {
                if (!nonBlankWords.containsKey(j) && blankWords.containsKey(j)) {
                    i = blankWords.get(j);
                    sb = new StringBuilder();
                    for (int k = 0; k < i[3]; k++) {
                        tmpX = i[0];
                        tmpY = i[1];
                        if (i[2] == 0) tmpY += k;
                        else if (i[2] == 1) tmpX += k;
                        c = blankCells.get(tmpX + sep + tmpY);
                        if (c != blank && !addedToQueue.contains(j)) {
                            blankWordQueue.add(j);
                            addedToQueue.add(j);
                        }
                        sb.append(c);
                    }
                    blankWordTemplates.put(j, sb.toString());
                    blankWordPossibilities.put(j, new HashSet<>());
                }
            }
        }

        private boolean matchesTemplate(String word, String template)
        {
            if (template.length() != word.length()) return false;
            char c;
            for (int i = 0; i < template.length(); i++) {
                c = template.charAt(i);
                if (c == blank) continue;
                if (c != word.charAt(i)) return false;
            }
            return true;
        }

        public List<String> printCrosswordPuzzle()
        {
            List<String> list = new ArrayList<>();
            for (char[] row : crossword) {
                list.add(String.valueOf(row));
            }
            return list;
        }
    }
}
