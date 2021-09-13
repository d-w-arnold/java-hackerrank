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
        if (root.data > v1 && root.data > v2) return lca(root.left, v1, v2);
        if (root.data < v1 && root.data < v2) return lca(root.right, v1, v2);
        return root;
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
