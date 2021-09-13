package InterviewPreparationKit.Trees.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 06/09/2021
 */
class HuffmanDecodingTest
{
    private final PrintStream STANDARD_OUT = System.out;
    private final ByteArrayOutputStream OUTPUT_STREAM_CAPTOR = new ByteArrayOutputStream();

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

    private HuffmanDecoding.Node buildTree(int[] charFreq)
    {
        PriorityQueue<HuffmanDecoding.Node> trees = new PriorityQueue<>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] > 0) trees.offer(new HuffmanDecoding.HuffmanLeaf(charFreq[i], (char) i));
        }
        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with the least frequency
            HuffmanDecoding.Node a = trees.poll();
            HuffmanDecoding.Node b = trees.poll();
            // put into new node and re-insert into queue
            assert b != null;
            trees.offer(new HuffmanDecoding.HuffmanNode(a, b));
        }
        return trees.poll();
    }

    private HuffmanDecoding.Node buildHuffManTree(String test)
    {
        int[] charFreq = new int[256];
        for (char c : test.toCharArray()) {
            charFreq[c]++;
        }
        return buildTree(charFreq);
    }

    @Test
    void decode_1()
    {
        String expected = "ABACA";
        HuffmanDecoding.decode("1001011", buildHuffManTree(expected));
        assertEquals(expected, OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void decode_2()
    {
        String expected = "Rumpelstiltskin";
        HuffmanDecoding.decode("010000100011110101010111111011000111011111100100000", buildHuffManTree(expected));
        assertEquals(expected, OUTPUT_STREAM_CAPTOR.toString().trim());
    }

    @Test
    void decode_3()
    {
        String expected = "howmuchwoodwouldawoodchuckchuckifawoodchuckcouldchuckwood?";
        HuffmanDecoding.decode("0100001111100010011001001100001111011001001011011111011101100001111110010100110101011001010011010101110011110111011101100001111110010100110101011000100101101111110010100110101001100001111111010", buildHuffManTree(expected));
        assertEquals(expected, OUTPUT_STREAM_CAPTOR.toString().trim());
    }
}