import java.util.ArrayList;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 25/05/2021
 */
public class SortingBubbleSort
{
    /**
     * Sorting Bubble Sort problem: https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
     *
     * @param a An array of integers to sort.
     */
    public static void countSwaps(List<Integer> a)
    {
        List<Integer> list = new ArrayList<>(a);
        int swapCount = 0;
        boolean swapOccurred;
        do {
            swapOccurred = false;
            for (int i = 0; i < list.size() - 1; i++) {
                int current = list.get(i);
                int next = list.get(i + 1);
                if (current > next) {
                    list = swap(list, i, i + 1);
                    swapOccurred = true;
                    swapCount++;
                }
            }
        } while (swapOccurred);
        printMsg(swapCount, list.get(0), list.get(list.size() - 1));
    }

    private static List<Integer> swap(List<Integer> list, int i, int j)
    {
        List<Integer> newList = new ArrayList<>(list);
        newList.set(i, list.get(j));
        newList.set(j, list.get(i));
        return newList;
    }

    private static void printMsg(int numOfSwaps, int firstElement, int lastElement)
    {
        System.out.println("Array is sorted in " + numOfSwaps + " swaps.");
        System.out.println("First Element: " + firstElement);
        System.out.println("Last Element: " + lastElement);
    }
}
