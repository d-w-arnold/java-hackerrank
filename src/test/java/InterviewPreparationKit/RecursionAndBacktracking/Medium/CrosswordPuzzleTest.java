package InterviewPreparationKit.RecursionAndBacktracking.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 22/09/2021
 */
class CrosswordPuzzleTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void crosswordPuzzle_1()
    {
        List<String> start = Arrays.asList(
                "++++++++++",
                "+------+++",
                "+++-++++++",
                "+++-++++++",
                "+++-----++",
                "+++-++-+++",
                "++++++-+++",
                "++++++-+++",
                "++++++-+++",
                "++++++++++"
        );
        String words = "POLAND;LHASA;SPAIN;INDIA";
        List<String> expected = Arrays.asList(
                "++++++++++",
                "+POLAND+++",
                "+++H++++++",
                "+++A++++++",
                "+++SPAIN++",
                "+++A++N+++",
                "++++++D+++",
                "++++++I+++",
                "++++++A+++",
                "++++++++++"
        );
        assertEquals(expected, CrosswordPuzzle.crosswordPuzzle(start, words));
    }

    @Test
    void crosswordPuzzle_2()
    {
        List<String> start = Arrays.asList(
                "+-++++++++",
                "+-++++++++",
                "+-++++++++",
                "+-----++++",
                "+-+++-++++",
                "+-+++-++++",
                "+++++-++++",
                "++------++",
                "+++++-++++",
                "+++++-++++"
        );
        String words = "LONDON;DELHI;ICELAND;ANKARA";
        List<String> expected = Arrays.asList(
                "+L++++++++",
                "+O++++++++",
                "+N++++++++",
                "+DELHI++++",
                "+O+++C++++",
                "+N+++E++++",
                "+++++L++++",
                "++ANKARA++",
                "+++++N++++",
                "+++++D++++"
        );
        assertEquals(expected, CrosswordPuzzle.crosswordPuzzle(start, words));
    }

    @Test
    void crosswordPuzzle_3()
    {
        List<String> start = Arrays.asList(
                "+-++++++++",
                "+-++++++++",
                "+-------++",
                "+-++++++++",
                "+-++++++++",
                "+------+++",
                "+-+++-++++",
                "+++++-++++",
                "+++++-++++",
                "++++++++++"
        );
        String words = "AGRA;NORWAY;ENGLAND;GWALIOR";
        List<String> expected = Arrays.asList(
                "+E++++++++",
                "+N++++++++",
                "+GWALIOR++",
                "+L++++++++",
                "+A++++++++",
                "+NORWAY+++",
                "+D+++G++++",
                "+++++R++++",
                "+++++A++++",
                "++++++++++"
        );
        assertEquals(expected, CrosswordPuzzle.crosswordPuzzle(start, words));
    }

    @Test
    void crosswordPuzzle_4()
    {
        List<String> start = Arrays.asList(
                "++++++-+++",
                "++------++",
                "++++++-+++",
                "++++++-+++",
                "+++------+",
                "++++++-+-+",
                "++++++-+-+",
                "++++++++-+",
                "++++++++-+",
                "++++++++-+"
        );
        String words = "ICELAND;MEXICO;PANAMA;ALMATY";
        List<String> expected = Arrays.asList(
                "++++++I+++",
                "++MEXICO++",
                "++++++E+++",
                "++++++L+++",
                "+++PANAMA+",
                "++++++N+L+",
                "++++++D+M+",
                "++++++++A+",
                "++++++++T+",
                "++++++++Y+"
        );
        assertEquals(expected, CrosswordPuzzle.crosswordPuzzle(start, words));
    }

    @Test
    void crosswordPuzzle_5()
    {
        List<String> start = Arrays.asList(
                "+-++++++++",
                "+-++-+++++",
                "+-------++",
                "+-++-+++++",
                "+-++-+++++",
                "+-++-+++++",
                "++++-+++++",
                "++++-+++++",
                "++++++++++",
                "----------"
        );
        String words = "CALIFORNIA;NIGERIA;CANADA;TELAVIV";
        List<String> expected = Arrays.asList(
                "+C++++++++",
                "+A++T+++++",
                "+NIGERIA++",
                "+A++L+++++",
                "+D++A+++++",
                "+A++V+++++",
                "++++I+++++",
                "++++V+++++",
                "++++++++++",
                "CALIFORNIA"
        );
        assertEquals(expected, CrosswordPuzzle.crosswordPuzzle(start, words));
    }

    @Test
    void crosswordPuzzle_6()
    {
        List<String> start = Arrays.asList(
                "+-++++++++",
                "+-++-+++++",
                "+-------++",
                "+-++-++-++",
                "+-++-++-++",
                "+-++-++-++",
                "++++-++-++",
                "+--------+",
                "++++++++++",
                "----------"
        );
        String words = "CALIFORNIA;LASVEGAS;NIGERIA;CANADA;TELAVIV;ALASKA";
        List<String> expected = Arrays.asList(
                "+C++++++++",
                "+A++T+++++",
                "+NIGERIA++",
                "+A++L++L++",
                "+D++A++A++",
                "+A++V++S++",
                "++++I++K++",
                "+LASVEGAS+",
                "++++++++++",
                "CALIFORNIA"
        );
        assertEquals(expected, CrosswordPuzzle.crosswordPuzzle(start, words));
    }

    @Test
    void crosswordPuzzle_7()
    {
        List<String> start = Arrays.asList(
                "+----+++++",
                "++++-+++++",
                "++++-+++++",
                "++++------",
                "++++-+++-+",
                "++++-+++-+",
                "++++-+++-+",
                "++++-+++-+",
                "++++-+++++",
                "++++++++++"
        );
        String words = "TREE;ELEPHANTS;PICKLE;LEMON";
        List<String> expected = Arrays.asList(
                "+TREE+++++",
                "++++L+++++",
                "++++E+++++",
                "++++PICKLE",
                "++++H+++E+",
                "++++A+++M+",
                "++++N+++O+",
                "++++T+++N+",
                "++++S+++++",
                "++++++++++"
        );
        assertEquals(expected, CrosswordPuzzle.crosswordPuzzle(start, words));
    }

    @Test
    void crosswordPuzzle_8()
    {
        List<String> start = Arrays.asList(
                "+-++++++++",
                "+-------++",
                "+-++-+++++",
                "+-------++",
                "+-++-++++-",
                "+-++-++++-",
                "+-++------",
                "+++++++++-",
                "++++++++++",
                "++++++++++"
        );
        String words = "ANDAMAN;MANIPUR;ICELAND;ALLEPY;YANGON;PUNE";
        List<String> expected = Arrays.asList(
                "+M++++++++",
                "+ANDAMAN++",
                "+N++L+++++",
                "+ICELAND++",
                "+P++E++++P",
                "+U++P++++U",
                "+R++YANGON",
                "+++++++++E",
                "++++++++++",
                "++++++++++"
        );
        assertEquals(expected, CrosswordPuzzle.crosswordPuzzle(start, words));
    }
}