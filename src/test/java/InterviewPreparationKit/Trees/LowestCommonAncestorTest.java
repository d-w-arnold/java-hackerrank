package InterviewPreparationKit.Trees;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 06/09/2021
 */
class LowestCommonAncestorTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    private LowestCommonAncestor.Node insert(LowestCommonAncestor.Node root, int data)
    {
        if (root != null) {
            LowestCommonAncestor.Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
        return new LowestCommonAncestor.Node(data);
    }

    private LowestCommonAncestor.Node getRoot(int[] array)
    {
        LowestCommonAncestor.Node root = null;
        for (int i : array) {
            root = insert(root, i);
        }
        return root;
    }

    @Test
    void lca_1()
    {
        assertEquals(4, LowestCommonAncestor.lca(getRoot(new int[]{4, 2, 7, 1, 3, 6}), 1, 7).data);
    }

    @Test
    void lca_2()
    {
        assertEquals(1, LowestCommonAncestor.lca(getRoot(new int[]{1, 2}), 1, 2).data);
    }

    @Test
    void lca_3()
    {
        assertEquals(5, LowestCommonAncestor.lca(getRoot(new int[]{5, 3, 8, 2, 4, 6, 7}), 7, 3).data);
    }
}