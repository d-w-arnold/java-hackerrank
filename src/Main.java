import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        extraLongFactorials();

        jumpingOnClouds();

        repeatedString();

        hourglassSum();

        arraysLeftRotation();

        checkMagazine();
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

    private static void jumpingOnClouds()
    {
        printClassName(JumpingOnClouds.class.getName());

        System.out.println(JumpingOnClouds.jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0, 1, 0))));
        System.out.println(JumpingOnClouds.jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 1, 0))));
        System.out.println(JumpingOnClouds.jumpingOnClouds(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 0))));
    }

    private static void repeatedString()
    {
        printClassName(RepeatedString.class.getName());

        System.out.println(RepeatedString.repeatedString("abcac", 10));
        System.out.println(RepeatedString.repeatedString("aba", 10));
        System.out.println(RepeatedString.repeatedString("a", 1000000000000L));
        System.out.println(RepeatedString.repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L));
    }

    private static void hourglassSum()
    {
        printClassName(HourGlassSum.class.getName());

        Integer[][] twoDimArray1 = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println(HourGlassSum.hourglassSum(HourGlassSum.covertTwoDimArrayToArrayList(twoDimArray1)));

        Integer[][] twoDimArray2 = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        System.out.println(HourGlassSum.hourglassSum(HourGlassSum.covertTwoDimArrayToArrayList(twoDimArray2)));

        Integer[][] twoDimArray3 = {
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}
        };
        System.out.println(HourGlassSum.hourglassSum(HourGlassSum.covertTwoDimArrayToArrayList(twoDimArray3)));

        Integer[][] twoDimArray4 = {
                {0, -4, -6, 0, -7, -6},
                {-1, -2, -6, -8, -3, -1},
                {-8, -4, -2, -8, -8, -6},
                {-3, -1, -2, -5, -7, -4},
                {-3, -5, -3, -6, -6, -6},
                {-3, -6, 0, -8, -6, -7}
        };
        System.out.println(HourGlassSum.hourglassSum(HourGlassSum.covertTwoDimArrayToArrayList(twoDimArray4)));
    }

    private static void arraysLeftRotation()
    {
        printClassName(ArraysLeftRotation.class.getName());

        System.out.println(ArraysLeftRotation.arraysLeftRotation(Arrays.asList(1, 2, 3, 4, 5), 2));
        System.out.println(ArraysLeftRotation.arraysLeftRotation(Arrays.asList(1, 2, 3, 4, 5), 4));
        System.out.println(ArraysLeftRotation.arraysLeftRotation(Arrays.asList(41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51), 10));
        System.out.println(ArraysLeftRotation.arraysLeftRotation(Arrays.asList(33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97), 13));
    }

    private static void checkMagazine()
    {
        printClassName(CheckMagazine.class.getName());

        CheckMagazine.checkMagazine(
                CheckMagazine.getWords("attack at dawn"),
                CheckMagazine.getWords("Attack at dawn")); // No
        CheckMagazine.checkMagazine(
                CheckMagazine.getWords("give me one grand today night"),
                CheckMagazine.getWords("give one grand today")); // Yes
        CheckMagazine.checkMagazine(
                CheckMagazine.getWords("two times three is not four"),
                CheckMagazine.getWords("two times two is four")); // No
        CheckMagazine.checkMagazine(
                CheckMagazine.getWords("ive got a lovely bunch of coconuts"),
                CheckMagazine.getWords("ive got some coconuts")); // No
    }
}
