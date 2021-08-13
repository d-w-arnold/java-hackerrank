package InterviewPreparationKit.Search.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author David W. Arnold
 * @version 13/08/2021
 */
public class SwapNodesAlgo
{
    /**
     * Swap Nodes [Algo] problem: https://www.hackerrank.com/challenges/swap-nodes-algo/problem
     *
     * @param indexes An array of integers representing index values of each node[i], beginning with node[1], the first element, as the root.
     * @param queries An array of integers, each representing a 'k' value.
     * @return A 2-D array where each element is an array of integers representing the node indices of an in-order traversal after a swap operation.
     */
    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries)
    {
        List<List<Integer>> ans = new ArrayList<>();
        BinaryTree tree = new BinaryTree(indexes);
        for (int k : queries) {
            tree.swap(k);
            ans.add(tree.getListFromInOrderString());
        }
        return ans;
    }

    private static class BinaryTree
    {
        Node root;
        String inOrderString;

        public BinaryTree(List<List<Integer>> indexes)
        {
            this.root = constructBinaryTree(indexes);
            genInOrderString();
        }

        public void genInOrderString()
        {
            this.inOrderString = "";
            genInOrderStringHelper(this.root);
        }

        public void swap(int k)
        {
            List<Node> currentDepth = new ArrayList<>();
            List<Node> nextDepth = new ArrayList<>();
            int depth = 1;
            Node tmp;
            currentDepth.add(this.root);
            while (!currentDepth.isEmpty()) {
                tmp = currentDepth.get(currentDepth.size() - 1);
                currentDepth.remove(currentDepth.size() - 1);
                if (tmp.left != null) nextDepth.add(tmp.left);
                if (tmp.right != null) nextDepth.add(tmp.right);
                if (depth % k == 0) {
                    Node n = tmp.left;
                    tmp.left = tmp.right;
                    tmp.right = n;
                }
                if (currentDepth.isEmpty()) {
                    List<Node> t = currentDepth;
                    currentDepth = nextDepth;
                    nextDepth = t;
                    depth++;
                }
            }
            genInOrderString();
        }

        public List<Integer> getListFromInOrderString()
        {
            return Arrays.stream(inOrderString.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        }

        private Node constructBinaryTree(List<List<Integer>> indexes)
        {
            Node root = new Node(1);
            List<Node> q = new LinkedList<>();
            q.add(root);
            for (List<Integer> pair : indexes) {
                Node left, right;
                left = pair.get(0) != -1 ? new Node(pair.get(0)) : null;
                right = pair.get(1) != -1 ? new Node(pair.get(1)) : null;
                Node tmp = q.remove(0);
                tmp.left = left;
                tmp.right = right;
                if (left != null) q.add(left);
                if (right != null) q.add(right);
            }
            return root;
        }

        private void genInOrderStringHelper(Node root)
        {
            if (root == null) return;
            genInOrderStringHelper(root.left);
            this.inOrderString += root.data + ",";
            genInOrderStringHelper(root.right);
        }

        private static class Node
        {
            int data;
            Node left;
            Node right;

            Node(int data)
            {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }
    }
}
