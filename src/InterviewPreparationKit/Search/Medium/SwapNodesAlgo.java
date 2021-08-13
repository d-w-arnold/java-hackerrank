package InterviewPreparationKit.Search.Medium;

import java.util.*;
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
            ans.add(getListFromInOrderString(tree.inOrderString));
        }
        return ans;
    }

    private static List<Integer> getListFromInOrderString(String str)
    {
        return Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static class BinaryTree
    {
        Node root;
        String inOrderString;

        public BinaryTree(List<List<Integer>> indexes)
        {
            this.root = insert(getArrayFromIndexes(indexes), null, 0);
            genInOrderString();
        }

        public Node insert(int[] arr, Node root, int i)
        {
            if (i < arr.length && arr[i] != -1) {
                root = new Node(arr[i]);
                root.left = insert(arr, root.left, 2 * i + 1);
                root.right = insert(arr, root.right, 2 * i + 2);
            }
            return root;
        }

        public void swap(int k)
        {
            swapHelper(this.root, 1, getSwapDepths(k, getTreeDepth()));
            genInOrderString();
        }

        public void genInOrderString()
        {
            this.inOrderString = "";
            genInOrderStringHelper(this.root);
        }

        private int[] getArrayFromIndexes(List<List<Integer>> indexes)
        {
            int[] newIndexes = new int[(indexes.size() * indexes.get(0).size()) + 1];
            newIndexes[0] = 1;
            int index = 1;
            for (List<Integer> list : indexes) {
                newIndexes[index++] = list.get(0);
                newIndexes[index++] = list.get(1);
            }
            return newIndexes;
        }

        private Set<Integer> getSwapDepths(int k, int treeDepth)
        {
            Set<Integer> list = new HashSet<>();
            if (k > 1) {
                int i = k;
                while (i <= treeDepth) {
                    list.add(i);
                    i *= k;
                }
            } else if (k == 1) {
                for (int i = 1; i <= treeDepth; i++) {
                    list.add(i);
                }
            }
            return list;
        }

        private int getTreeDepth()
        {
            return getTreeDepthHelper(this.root);
        }

        private void swapHelper(Node node, int depth, Set<Integer> swapDepths)
        {
            if (swapDepths.size() > 0) {
                if (swapDepths.contains(depth)) {
                    Node tmp = node.left;
                    node.left = node.right;
                    node.right = tmp;
                }
                if (node.left != null) swapHelper(node.left, depth + 1, swapDepths);
                if (node.right != null) swapHelper(node.right, depth + 1, swapDepths);
            }
        }

        private void genInOrderStringHelper(Node root)
        {
            if (root != null) {
                genInOrderStringHelper(root.left);
                this.inOrderString += root.data + ",";
                genInOrderStringHelper(root.right);
            }
        }

        private int getTreeDepthHelper(Node node)
        {
            if (node == null) return 0;
            int lDepth = getTreeDepthHelper(node.left);
            int rDepth = getTreeDepthHelper(node.right);
            return lDepth > rDepth ? (lDepth + 1) : (rDepth + 1);
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
