package InterviewPreparationKit.Trees.Medium;

/**
 * @author David W. Arnold
 * @version 06/09/2021
 */
public class IsThisABinarySearchTree
{
    /**
     * Trees: Is This a Binary Search Tree? problem: https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
     *
     * @param root A reference to the root of a binary tree.
     * @return A boolean denoting whether the binary tree is a binary search tree.
     */
    public static boolean checkBST(Node root)
    {
        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBSTHelper(Node node, int min, int max)
    {
        return node == null || ((min < node.data && node.data < max) &&
                checkBSTHelper(node.left, min, node.data) &&
                checkBSTHelper(node.right, node.data, max));
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
