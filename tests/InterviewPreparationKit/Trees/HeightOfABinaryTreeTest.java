package InterviewPreparationKit.Trees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 06/09/2021
 */
class HeightOfABinaryTreeTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    private HeightOfABinaryTree.Node insert(HeightOfABinaryTree.Node root, int data)
    {
        if (root != null) {
            HeightOfABinaryTree.Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
        return new HeightOfABinaryTree.Node(data);
    }

    private HeightOfABinaryTree.Node getRoot(int[] array)
    {
        HeightOfABinaryTree.Node root = null;
        for (int i : array) {
            root = insert(root, i);
        }
        return root;
    }

    @Test
    void height_1()
    {
        assertEquals(2, HeightOfABinaryTree.height(getRoot(new int[]{4, 2, 6, 1, 3, 5, 7})));
    }

    @Test
    void height_2()
    {
        assertEquals(3, HeightOfABinaryTree.height(getRoot(new int[]{3, 5, 2, 1, 4, 6, 7})));
    }

    @Test
    void height_3()
    {
        assertEquals(0, HeightOfABinaryTree.height(getRoot(new int[]{15})));
    }

    @Test
    void height_4()
    {
        assertEquals(3, HeightOfABinaryTree.height(getRoot(new int[]{3, 1, 7, 5, 4})));
    }
}