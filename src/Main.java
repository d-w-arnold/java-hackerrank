import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        extraLongFactorials();
        jumpingOnTheClouds();
        repeatedString();
        twoDimArrayDS();
        arraysLeftRotation();
        hashTablesRansomNote();
        twoStrings();
        sortingBubbleSort();
        markAndToys();
        stringsMakingAnagrams();
        alternatingCharacters();
    }

    private static void printClassName(String className)
    {
        System.out.println("\n" + className + " : ");
    }

    private static void extraLongFactorials()
    {
        printClassName(ExtraLongFactorials.class.getName());

        ExtraLongFactorials.extraLongFactorials(50);
        ExtraLongFactorials.extraLongFactorials(100);
    }

    private static void jumpingOnTheClouds()
    {
        printClassName(JumpingOnTheClouds.class.getName());

        System.out.println(JumpingOnTheClouds.jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0, 1, 0))));
        System.out.println(JumpingOnTheClouds.jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 1, 0))));
        System.out.println(JumpingOnTheClouds.jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 0))));
    }

    private static void repeatedString()
    {
        printClassName(RepeatedString.class.getName());

        System.out.println(RepeatedString.repeatedString("abcac", 10));
        System.out.println(RepeatedString.repeatedString("aba", 10));
        System.out.println(RepeatedString.repeatedString("a", 1000000000000L));
        System.out.println(RepeatedString.repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L));
    }

    private static void twoDimArrayDS()
    {
        printClassName(TwoDimArrayDS.class.getName());

        Integer[][] twoDimArray1 = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println(TwoDimArrayDS.hourglassSum(TwoDimArrayDS.covertTwoDimArrayToArrayList(twoDimArray1)));

        Integer[][] twoDimArray2 = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println(TwoDimArrayDS.hourglassSum(TwoDimArrayDS.covertTwoDimArrayToArrayList(twoDimArray2)));

        Integer[][] twoDimArray3 = {
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}
        };
        System.out.println(TwoDimArrayDS.hourglassSum(TwoDimArrayDS.covertTwoDimArrayToArrayList(twoDimArray3)));

        Integer[][] twoDimArray4 = {
                {0, -4, -6, 0, -7, -6},
                {-1, -2, -6, -8, -3, -1},
                {-8, -4, -2, -8, -8, -6},
                {-3, -1, -2, -5, -7, -4},
                {-3, -5, -3, -6, -6, -6},
                {-3, -6, 0, -8, -6, -7}
        };
        System.out.println(TwoDimArrayDS.hourglassSum(TwoDimArrayDS.covertTwoDimArrayToArrayList(twoDimArray4)));
    }

    private static void arraysLeftRotation()
    {
        printClassName(ArraysLeftRotation.class.getName());

        System.out.println(ArraysLeftRotation.rotLeft(Arrays.asList(1, 2, 3, 4, 5), 2));
        System.out.println(ArraysLeftRotation.rotLeft(Arrays.asList(1, 2, 3, 4, 5), 4));
        System.out.println(ArraysLeftRotation.rotLeft(Arrays.asList(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51), 10));
        System.out.println(ArraysLeftRotation.rotLeft(Arrays.asList(33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97), 13));
    }

    private static void hashTablesRansomNote()
    {
        printClassName(HashTablesRansomNote.class.getName());

        HashTablesRansomNote.checkMagazine(
                HashTablesRansomNote.getWords("attack at dawn"),
                HashTablesRansomNote.getWords("Attack at dawn")); // No
        HashTablesRansomNote.checkMagazine(
                HashTablesRansomNote.getWords("give me one grand today night"),
                HashTablesRansomNote.getWords("give one grand today")); // Yes
        HashTablesRansomNote.checkMagazine(
                HashTablesRansomNote.getWords("two times three is not four"),
                HashTablesRansomNote.getWords("two times two is four")); // No
        HashTablesRansomNote.checkMagazine(
                HashTablesRansomNote.getWords("ive got a lovely bunch of coconuts"),
                HashTablesRansomNote.getWords("ive got some coconuts")); // No
    }

    private static void twoStrings()
    {
        printClassName(TwoStrings.class.getName());

        System.out.println(TwoStrings.twoStrings("and", "art")); // YES
        System.out.println(TwoStrings.twoStrings("be", "cat")); // NO
        System.out.println(TwoStrings.twoStrings("hello", "world")); // YES
        System.out.println(TwoStrings.twoStrings("hi", "world")); // NO
    }

    private static void sortingBubbleSort()
    {
        printClassName(SortingBubbleSort.class.getName());

        SortingBubbleSort.countSwaps(Arrays.asList(6, 4, 1));
        /*
          Array is sorted in 3 swaps.
          First Element: 1
          Last Element: 6
         */
        SortingBubbleSort.countSwaps(Arrays.asList(1, 2, 3));
        /*
          Array is sorted in 0 swaps.
          First Element: 1
          Last Element: 3
         */
        SortingBubbleSort.countSwaps(Arrays.asList(3, 2, 1));
        /*
          Array is sorted in 3 swaps.
          First Element: 1
          Last Element: 3
         */
    }

    private static void markAndToys()
    {
        printClassName(MarkAndToys.class.getName());

        System.out.println(MarkAndToys.maximumToys(Arrays.asList(1, 2, 3, 4), 7)); // 3
        System.out.println(MarkAndToys.maximumToys(Arrays.asList(1, 12, 5, 111, 200, 1000, 10), 50)); // 4
    }

    private static void stringsMakingAnagrams()
    {
        printClassName(StringsMakingAnagrams.class.getName());

        System.out.println(StringsMakingAnagrams.makeAnagram("cde", "dcf")); // 2
        System.out.println(StringsMakingAnagrams.makeAnagram("cde", "abc")); // 4
    }

    private static void alternatingCharacters()
    {
        printClassName(AlternatingCharacters.class.getName());

        System.out.println(AlternatingCharacters.alternatingCharacters("AABAAB")); // 2
        System.out.println(AlternatingCharacters.alternatingCharacters("AAAA")); // 3
        System.out.println(AlternatingCharacters.alternatingCharacters("BBBBB")); // 4
        System.out.println(AlternatingCharacters.alternatingCharacters("ABABABAB")); // 0
        System.out.println(AlternatingCharacters.alternatingCharacters("BABABA")); // 0
        System.out.println(AlternatingCharacters.alternatingCharacters("AAABBB")); // 4
    }
}
