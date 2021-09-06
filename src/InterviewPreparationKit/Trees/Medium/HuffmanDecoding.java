package InterviewPreparationKit.Trees.Medium;

/**
 * @author David W. Arnold
 * @version 06/09/2021
 */
public class HuffmanDecoding
{
    /**
     * Tree: Huffman Decoding problem: https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
     *
     * @param s    A Huffman encoded string.
     * @param root A reference to the root node of the Huffman tree.
     */
    public static void decode(String s, Node root)
    {
        System.out.println("NULL");
    }

    abstract static class Node implements Comparable<Node>
    {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;

        public Node(int freq)
        {
            frequency = freq;
        }

        // compares on the frequency
        public int compareTo(Node tree)
        {
            return frequency - tree.frequency;
        }
    }

    static class HuffmanLeaf extends Node
    {
        public HuffmanLeaf(int freq, char val)
        {
            super(freq);
            data = val;
        }
    }

    static class HuffmanNode extends Node
    {
        public HuffmanNode(Node l, Node r)
        {
            super(l.frequency + r.frequency);
            left = l;
            right = r;
        }
    }
}
