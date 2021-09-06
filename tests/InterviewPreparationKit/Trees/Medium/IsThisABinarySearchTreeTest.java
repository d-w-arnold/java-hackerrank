package InterviewPreparationKit.Trees.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author David W. Arnold
 * @version 06/09/2021
 */
class IsThisABinarySearchTreeTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    private IsThisABinarySearchTree.Node buildBinaryTree(int[] array)
    {
        int median = array.length / 2;
        if (array[median] == -1) return null;
        IsThisABinarySearchTree.Node node = new IsThisABinarySearchTree.Node(array[median]);
        if (array.length >= 3) {
            node.left = buildBinaryTree(Arrays.copyOfRange(array, 0, median));
            node.right = buildBinaryTree(Arrays.copyOfRange(array, median + 1, array.length));
        }
        return node;
    }

    @Test
    void checkBST_1()
    {
        assertFalse(IsThisABinarySearchTree.checkBST(buildBinaryTree(new int[]{1, 2, -1, 3, 5, 4, 6})));
    }

    @Test
    void checkBST_2()
    {
        assertFalse(IsThisABinarySearchTree.checkBST(buildBinaryTree(new int[]{1, 2, -1, 3, 6, 5, 1})));
    }

    @Test
    void checkBST_3()
    {
        assertTrue(IsThisABinarySearchTree.checkBST(buildBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7})));
    }

    @Test
    void checkBST_4()
    {
        assertFalse(IsThisABinarySearchTree.checkBST(buildBinaryTree(new int[]{1, 2, 4, 3, 5, 6, 7})));
    }

    @Test
    void checkBST_5()
    {
        assertTrue(IsThisABinarySearchTree.checkBST(buildBinaryTree(new int[]{3, 5, 7, 9, 11, 13, 15})));
    }
}