package InterviewPreparationKit.StacksAndQueues.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 19/08/2021
 */
class CastleOnTheGridTest
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
    void minimumMoves_1()
    {
        assertEquals(2, CastleOnTheGrid.minimumMoves(
                Arrays.asList(
                        "...",
                        ".X.",
                        "..."
                ),
                0, 0, 1, 2
        ));
    }

    @Test
    void minimumMoves_2()
    {
        assertEquals(3, CastleOnTheGrid.minimumMoves(
                Arrays.asList(
                        ".X.",
                        ".X.",
                        "..."
                ),
                0, 0, 0, 2
        ));
    }

    @Test
    void minimumMoves_3()
    {
        assertEquals(3, CastleOnTheGrid.minimumMoves(
                Arrays.asList(
                        ".X..XX...X",
                        "X.........",
                        ".X.......X",
                        "..........",
                        "........X.",
                        ".X...XXX..",
                        ".....X..XX",
                        ".....X.X..",
                        "..........",
                        ".....X..XX"
                ),
                9, 1, 9, 6
        ));
    }

    @Test
    void minimumMoves_4()
    {
        assertEquals(1, CastleOnTheGrid.minimumMoves(
                Arrays.asList(
                        ".X..XX...X",
                        "X.........",
                        ".X.......X",
                        "..........",
                        "........X.",
                        ".X...XXX..",
                        ".....X..XX",
                        ".....X.X..",
                        "..........",
                        ".....X..XX"
                ),
                8, 6, 9, 6
        ));
    }

    @Test
    void minimumMoves_5()
    {
        assertEquals(2, CastleOnTheGrid.minimumMoves(
                Arrays.asList(
                        ".X..XX...X",
                        "X.........",
                        ".X.......X",
                        "..........",
                        "........X.",
                        ".X...XXX..",
                        ".....X..XX",
                        ".....X.X..",
                        "..........",
                        ".....X..XX"
                ),
                8, 1, 9, 6
        ));
    }

    @Test
    void minimumMoves_6()
    {
        assertEquals(9, CastleOnTheGrid.minimumMoves(
                Arrays.asList(
                        "...X......XX.X...........XX....X.XX.....",
                        ".X..............X...XX..X...X........X.X",
                        "......X....X....X.........X...........X.",
                        ".X.X.X..X........X.....X.X...X.....X..X.",
                        "....X.X.X...X..........X..........X.....",
                        "..X......X....X....X...X....X.X.X....XX.",
                        "...X....X.......X..XXX.......X.X.....X..",
                        "...X.X.........X.X....X...X.........X...",
                        "XXXX..X......X.XX......X.X......XX.X..XX",
                        ".X........X....X.X......X..X....XX....X.",
                        "...X.X..X.X.....X...X....X..X....X......",
                        "....XX.X.....X.XX.X...X.X.....X.X.......",
                        ".X.X.X..............X.....XX..X.........",
                        "..X...............X......X........XX...X",
                        ".X......X...X.XXXX.....XX...........X..X",
                        "...X....XX....X...XX.X..X..X..X.....X..X",
                        "...X...X.X.....X.....X.....XXXX.........",
                        "X.....XX..X.............X.XX.X.XXX......",
                        ".....X.X..X..........X.X..X...X.X......X",
                        "...X.....X..X.............X......X..X..X",
                        "........X.....................X....X.X..",
                        "..........X.....XXX...XX.X..............",
                        "........X..X..........X.XXXX..X.........",
                        "..X..X...X.......XX...X.....X...XXX..X..",
                        ".X.......X..............X....X...X....X.",
                        ".................X.....X......X.....X...",
                        ".......X.X.XX..X.XXX.X.....X..........X.",
                        "X..X......X..............X..X.X.......X.",
                        "X........X.....X.....X....XX.......XX...",
                        "X.....X.................X.....X..X...XXX",
                        "XXX..X..X.X.XX..X....X.....XXX..X......X",
                        "..........X.....X.....XX................",
                        "..X.........X..X.........X...X.....X....",
                        ".X.X....X...XX....X...............X.....",
                        ".X....X....XX.XX........X..X............",
                        "X...X.X................XX......X..X.....",
                        "..X.X.......X.X..X.....XX.........X..X..",
                        "........................X..X.XX..X......",
                        "........X..X.X.....X.....X......X.......",
                        ".X..X....X.X......XX...................."
                ),
                34, 28, 16, 8
        ));
    }
}