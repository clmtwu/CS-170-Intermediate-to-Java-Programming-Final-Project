import java.util.*;
public class Gameplay {
    ArrayList<String> answer = new ArrayList<String>(Arrays.asList
    ("a", "b ", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x" , "y", "z"));
    final double accuracy_portion = 0.3;
    final double combo_portion = 0.7;
    double total_score;

    public void updateScore(double accuracy, double combo) {
        total_score = 1000000 * ((accuracy * accuracy_portion) + (combo / answer.size() * combo_portion)); 
    }
}