package InterviewPreparationKit.Trees;

/**
 * @author David W. Arnold
 * @version 06/09/2021
 */
public class HeightOfABinaryTree
{
    /**
     * Tree: Height of a Binary Tree problem: https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
     *
     * @param root A reference to the root of a binary tree.
     * @return The height of a binary tree as an integer.
     */
    public static int height(Node root)
    {
        if (root == null) return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
