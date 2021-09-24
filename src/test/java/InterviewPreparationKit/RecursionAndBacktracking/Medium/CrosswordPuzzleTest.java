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
}