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
        private final char BLANK = '-';
        private final String SEP = ":";
        private final char[][] CROSSWORD;
        private final Map<Integer, Integer[]> BLANK_WORDS;
        private final Queue<Integer> BLANK_WORDS_QUEUE;
        private final Set<List<String>> PERMS;
        private Set<String> words;
        private Map<Integer, Set<String>> wordsMap; // Word length -> List of words of that length
        private Stack<String> usedWords;
        private Map<Integer, String> nonBlankWords;
        private Map<String, Character> blankCells; // x:y -> Character in cell
        private Map<Integer, String> blankWordTemplates;
        private Map<Integer, Set<String>> blankWordPossibilities;

        public Puzzle(List<String> crossword, String words)
        {
            this.CROSSWORD = new char[crossword.size()][crossword.get(0).length()];
            this.BLANK_WORDS = new HashMap<>();
            this.BLANK_WORDS_QUEUE = new LinkedList<>();
            this.PERMS = new HashSet<>();
            this.words = new HashSet<>(Arrays.asList(words.split(";")));
            this.wordsMap = new HashMap<>();
            this.usedWords = new Stack<>();
            this.nonBlankWords = new HashMap<>();
            this.blankCells = new HashMap<>();
            this.blankWordTemplates = new LinkedHashMap<>();
            this.blankWordPossibilities = new HashMap<>();
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
                    this.CROSSWORD[i][j] = c;
                    if (c == BLANK) {
                        xSepY = i + SEP + j;
                        blankCells.put(xSepY, BLANK);
                        xSepYSepRight = xSepY + SEP + 0;
                        xSepYSepDown = xSepY + SEP + 1;
                        containsRight = false;
                        containsDown = false;
                        cRight = crossword.get(i).charAt(j + 1);
                        cDown = i + 1 < crossword.size() ? crossword.get(i + 1).charAt(j) : '+';
                        if (cache.containsKey(xSepYSepRight) || cache.containsKey(xSepYSepDown)) {
                            if (cache.containsKey(xSepYSepRight)) {
                                containsRight = true;
                                if (cRight == BLANK) {
                                    Integer[] value = cache.get(xSepYSepRight);
                                    value[3]++;
                                    cache.put(i + SEP + (j + 1) + SEP + 0, value);
                                } else {
                                    BLANK_WORDS.put(index, cache.get(xSepYSepRight));
                                    index++;
                                }
                                cache.remove(xSepYSepRight);
                            }
                            if (cache.containsKey(xSepYSepDown)) {
                                containsDown = true;
                                if (cDown == BLANK) {
                                    Integer[] value = cache.get(xSepYSepDown);
                                    value[3]++;
                                    cache.put((i + 1) + SEP + j + SEP + 1, value);
                                } else {
                                    BLANK_WORDS.put(index, cache.get(xSepYSepDown));
                                    index++;
                                }
                                cache.remove(xSepYSepDown);
                            }
                        }
                        if (cRight == BLANK || cDown == BLANK) {
                            if (cRight == BLANK && !containsRight)
                                cache.put(i + SEP + (j + 1) + SEP + 0, new Integer[]{i, j, 0, 2});
                            if (cDown == BLANK && !containsDown)
                                cache.put((i + 1) + SEP + j + SEP + 1, new Integer[]{i, j, 1, 2});
                        } else if (!containsRight && !containsDown) {
                            BLANK_WORDS.put(index, new Integer[]{i, j, 0, 1});
                            index++;
                        }
                    }
                }
            }
        }

        public void insertWords()
        {
            insertWordsOfUniqueLength();
            getBlankWordTemplatesAndPossibilities();
            List<String> matches;
            String blankWordTemplate, word;
            Integer[] i;
            int entry;
            while (!BLANK_WORDS_QUEUE.isEmpty()) {
                entry = BLANK_WORDS_QUEUE.remove();
                matches = new ArrayList<>();
                blankWordTemplate = blankWordTemplates.get(entry);
                for (String w : words) {
                    if (matchesTemplate(w, blankWordTemplate)) matches.add(w);
                }
                if (matches.size() == 1) {
                    word = matches.get(0);
                    i = BLANK_WORDS.get(entry);
                    updateBlankCells(word, i, entry);
                    getBlankWordTemplatesAndPossibilities();
                } else if (matches.size() > 1) blankWordPossibilities.get(entry).addAll(matches);
            }
            // TODO: Brute force any multiple matches for a given blankWord slot.
            permute(new ArrayList<>(words));
            Map<String, Character> tmpBlankCells = new HashMap<>(blankCells);
            Set<String> tmpWords = new HashSet<>(words);
            Stack<String> tmpUsedWords = new Stack<>();
            tmpUsedWords.addAll(usedWords);
            Map<Integer, Set<String>> tmpWordsMap = new HashMap<>(wordsMap);
            Map<Integer, String> tmpNonBlankWords = new HashMap<>(nonBlankWords);
            Map<Integer, Set<String>> tmpBlankWordPossibilities = new HashMap<>(blankWordPossibilities);
            Map<Integer, String> tmpBlankWordTemplates = new HashMap<>(blankWordTemplates);
            int index;
            nextPerm:
            for (List<String> perm : PERMS) {
                index = 0;
                getBlankWordTemplatesAndPossibilities();
                while (!BLANK_WORDS_QUEUE.isEmpty()) {
                    entry = BLANK_WORDS_QUEUE.remove();
                    blankWordTemplate = blankWordTemplates.get(entry);
                    word = perm.get(index);
                    if (matchesTemplate(word, blankWordTemplate)) {
                        i = BLANK_WORDS.get(entry);
                        updateBlankCells(word, i, entry);
                        getBlankWordTemplatesAndPossibilities();
                        index++;
                    } else {
                        this.blankCells = new HashMap<>(tmpBlankCells);
                        this.words = new HashSet<>(tmpWords);
                        this.usedWords = new Stack<>();
                        this.usedWords.addAll(tmpUsedWords);
                        this.wordsMap = new HashMap<>(tmpWordsMap);
                        this.nonBlankWords = new HashMap<>(tmpNonBlankWords);
                        this.blankWordPossibilities = new HashMap<>(tmpBlankWordPossibilities);
                        this.blankWordTemplates = new LinkedHashMap<>(tmpBlankWordTemplates);
                        break nextPerm;
                    }
                }
            }
            for (Map.Entry<String, Character> e : blankCells.entrySet()) {
                String[] s = e.getKey().split(SEP);
                CROSSWORD[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = e.getValue();
            }
        }

        private void permute(List<String> words)
        {
            permutation(0, words.size() - 1, words);
        }

        private void permutation(int start, int end, List<String> words)
        {
            if (start == end) PERMS.add(new ArrayList<>(words));
            for (int i = start; i <= end; i++) {
                PERMS.add(swap(words, start, i));
                permutation(start + 1, end, words);
                PERMS.add(swap(words, start, i));
            }
        }

        private List<String> swap(List<String> arr, int a, int b)
        {
            if (a == b) return new ArrayList<>(arr);
            String tmp = arr.get(b);
            arr.set(b, arr.get(a));
            arr.set(a, tmp);
            return new ArrayList<>(arr);
        }

        private void insertWordsOfUniqueLength()
        {
            int wordLen;
            for (int k = 0; k < BLANK_WORDS.size(); k++) {
                if (!nonBlankWords.containsKey(k) && BLANK_WORDS.containsKey(k)) {
                    Integer[] i = BLANK_WORDS.get(k);
                    wordLen = i[3];
                    if (wordsMap.containsKey(wordLen) && wordsMap.get(wordLen).size() == 1)
                        updateBlankCells(wordsMap.get(wordLen).iterator().next(), i, k);
                }
            }
        }

        private void updateBlankCells(String word, Integer[] i, int bwIndex)
        {
            int tmpX, tmpY;
            for (int j = 0; j < i[3]; j++) {
                tmpX = i[0];
                tmpY = i[1];
                if (i[2] == 0) tmpY += j;
                else if (i[2] == 1) tmpX += j;
                String xSepY = tmpX + SEP + tmpY;
                blankCells.put(xSepY, word.charAt(j));
            }
            words.remove(word);
            usedWords.add(word);
            wordsMap.get(i[3]).remove(word);
            nonBlankWords.put(bwIndex, word);
        }

        private void getBlankWordTemplatesAndPossibilities()
        {
            this.blankWordTemplates = new LinkedHashMap<>();
            this.blankWordPossibilities = new HashMap<>();
            Set<Integer> addedToQueue = new HashSet<>();
            Integer[] i;
            StringBuilder sb;
            int tmpX, tmpY;
            char c;
            for (int j = 0; j < BLANK_WORDS.size(); j++) {
                if (!nonBlankWords.containsKey(j) && BLANK_WORDS.containsKey(j)) {
                    i = BLANK_WORDS.get(j);
                    sb = new StringBuilder();
                    for (int k = 0; k < i[3]; k++) {
                        tmpX = i[0];
                        tmpY = i[1];
                        if (i[2] == 0) tmpY += k;
                        else if (i[2] == 1) tmpX += k;
                        c = blankCells.get(tmpX + SEP + tmpY);
                        System.out.println();
                        if (c != BLANK && !addedToQueue.contains(j)) {
                            BLANK_WORDS_QUEUE.add(j);
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
                if (c == BLANK) continue;
                if (c != word.charAt(i)) return false;
            }
            return true;
        }

        public List<String> printCrosswordPuzzle()
        {
            List<String> list = new ArrayList<>();
            for (char[] row : CROSSWORD) {
                list.add(String.valueOf(row));
            }
            return list;
        }
    }
}
