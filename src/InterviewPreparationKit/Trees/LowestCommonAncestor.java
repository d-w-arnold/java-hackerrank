package InterviewPreparationKit.Trees;

/**
 * @author David W. Arnold
 * @version 06/09/2021
 */
public class LowestCommonAncestor
{
    /**
     * Binary Search Tree : Lowest Common Ancestor: https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem
     *
     * @param root A pointer to the root node of a binary search tree.
     * @param v1   A node.data value.
     * @param v2   A node.data value.
     * @return A pointer to the lowest common ancestor node of the two values given.
     */
    public static Node lca(Node root, int v1, int v2)
    {
        return new Node(-2);
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
