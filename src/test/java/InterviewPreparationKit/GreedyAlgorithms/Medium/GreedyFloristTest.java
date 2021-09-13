package InterviewPreparationKit.GreedyAlgorithms.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 11/08/2021
 */
class GreedyFloristTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void getMinimumCost_1()
    {
        assertEquals(11, GreedyFlorist.getMinimumCost(3, new int[]{1, 2, 3, 4}));
    }

    @Test
    void getMinimumCost_2()
    {
        assertEquals(13, GreedyFlorist.getMinimumCost(3, new int[]{2, 5, 6}));
    }

    @Test
    void getMinimumCost_3()
    {
        assertEquals(15, GreedyFlorist.getMinimumCost(2, new int[]{2, 5, 6}));
    }

    @Test
    void getMinimumCost_4()
    {
        assertEquals(29, GreedyFlorist.getMinimumCost(3, new int[]{1, 3, 5, 7, 9}));
    }

    @Test
    void getMinimumCost_5()
    {
        assertEquals(163578911, GreedyFlorist.getMinimumCost(3, new int[]{390225, 426456, 688267, 800389, 990107, 439248, 240638, 15991, 874479, 568754, 729927, 980985, 132244, 488186, 5037, 721765, 251885, 28458, 23710, 281490, 30935, 897665, 768945, 337228, 533277, 959855, 927447, 941485, 24242, 684459, 312855, 716170, 512600, 608266, 779912, 950103, 211756, 665028, 642996, 262173, 789020, 932421, 390745, 433434, 350262, 463568, 668809, 305781, 815771, 550800}));
    }

    @Test
    void getMinimumCost_6()
    {
        assertEquals(30352414, GreedyFlorist.getMinimumCost(34, new int[]{433515, 22221, 540709, 538312, 496949, 902471, 439983, 159332, 417327, 399306, 817804, 354682, 108825, 970689, 868286, 235070, 18732, 848955, 994152, 741000, 722232, 564879, 503093, 734475, 174795, 129065, 483929, 683440, 37645, 670198, 911023, 40334, 329513, 669160, 180034, 285512, 401190, 629798, 857703, 765572, 174164, 849299, 159367, 62467, 84449, 523962, 735995, 245666, 832139, 879827, 749840, 315756, 253168, 659252, 187178}));
    }
}