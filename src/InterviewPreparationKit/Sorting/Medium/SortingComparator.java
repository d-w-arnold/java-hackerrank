package InterviewPreparationKit.Sorting.Medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author David W. Arnold
 * @version 23/07/2021
 */
public class SortingComparator
{
    public static void sortingComparator(Player[] player)
    {
        Checker checker = new Checker();
        Arrays.sort(player, checker);
        for (Player p : player) {
            System.out.printf("%s %s\n", p.name, p.score);
        }
    }
}

class Checker implements Comparator<Player>
{
    @Override
    public int compare(Player a, Player b)
    {
        return 0;
    }
}

class Player
{
    String name;
    int score;

    Player(String name, int score)
    {
        this.name = name;
        this.score = score;
    }
}
