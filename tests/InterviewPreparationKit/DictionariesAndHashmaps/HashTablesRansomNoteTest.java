package InterviewPreparationKit.DictionariesAndHashmaps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
class HashTablesRansomNoteTest
{
    private final PrintStream STANDARD_OUT = System.out;
    private final ByteArrayOutputStream OUTPUT_STREAM_CAPTOR = new ByteArrayOutputStream();
    private final String YES_MSG = "Yes";
    private final String NO_MSG = "No";
    private final String MAGAZINE_1 = "attack at dawn";
    private final String NOTE_1 = "Attack at dawn";
    private final String MAGAZINE_2 = "give me one grand today night";
    private final String NOTE_2 = "give one grand today";
    private final String MAGAZINE_3 = "two times three is not four";
    private final String NOTE_3 = "two times two is four";
    private final String MAGAZINE_4 = "ive got a lovely bunch of coconuts";
    private final String NOTE_4 = "ive got some coconuts";

    @BeforeEach
    void setUp()
    {
        System.setOut(new PrintStream(OUTPUT_STREAM_CAPTOR));
    }

    @AfterEach
    void tearDown()
    {
        System.setOut(STANDARD_OUT);
    }

    @Test
    void getWords_1()
    {
        assertEquals(Arrays.asList("attack", "at", "dawn"), HashTablesRansomNote.getWords(MAGAZINE_1));
    }

    @Test
    void getWords_2()
    {
        assertEquals(Arrays.asList("Attack", "at", "dawn"), HashTablesRansomNote.getWords(NOTE_1));
    }

    @Test
    void getWords_3()
    {
        assertEquals(Arrays.asList("give", "me", "one", "grand", "today", "night"), HashTablesRansomNote.getWords(MAGAZINE_2));
    }

    @Test
    void getWords_4()
    {
        assertEquals(Arrays.asList("give", "one", "grand", "today"), HashTablesRansomNote.getWords(NOTE_2));
    }

    @Test
    void getWords_5()
    {
        assertEquals(Arrays.asList("two", "times", "three", "is", "not", "four"), HashTablesRansomNote.getWords(MAGAZINE_3));
    }

    @Test
    void getWords_6()
    {
        assertEquals(Arrays.asList("two", "times", "two", "is", "four"), HashTablesRansomNote.getWords(NOTE_3));
    }

    @Test
    void getWords_7()
    {
        assertEquals(Arrays.asList("ive", "got", "a", "lovely", "bunch", "of", "coconuts"), HashTablesRansomNote.getWords(MAGAZINE_4));
    }

    @Test
    void getWords_8()
    {
        assertEquals(Arrays.asList("ive", "got", "some", "coconuts"), HashTablesRansomNote.getWords(NOTE_4));
    }

    @Test
    void checkMagazine_1()
    {
        HashTablesRansomNote.checkMagazine(HashTablesRansomNote.getWords(MAGAZINE_1), HashTablesRansomNote.getWords(NOTE_1));
        assertEquals(NO_MSG, OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void checkMagazine_2()
    {
        HashTablesRansomNote.checkMagazine(HashTablesRansomNote.getWords(MAGAZINE_2), HashTablesRansomNote.getWords(NOTE_2));
        assertEquals(YES_MSG, OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void checkMagazine_3()
    {
        HashTablesRansomNote.checkMagazine(HashTablesRansomNote.getWords(MAGAZINE_3), HashTablesRansomNote.getWords(NOTE_3));
        assertEquals(NO_MSG, OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void checkMagazine_4()
    {
        HashTablesRansomNote.checkMagazine(HashTablesRansomNote.getWords(MAGAZINE_4), HashTablesRansomNote.getWords(NOTE_4));
        assertEquals(NO_MSG, OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}