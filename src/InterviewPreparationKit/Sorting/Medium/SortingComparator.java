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
        if (a.score < b.score) {
            return 1;
        } else if (a.score > b.score) {
            return -1;
        } else { // a.score == b.score
            for (int i = 0; i < (Math.min(a.name.length(), b.name.length())); i++) {
                char aChar = a.name.charAt(i);
                char bChar = b.name.charAt(i);
                if (aChar < bChar) {
                    return -1;
                } else if (aChar > bChar) {
                    return 1;
                }
            }
            return Integer.compare(a.name.length(), b.name.length());
        }
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
