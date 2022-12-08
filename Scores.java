import java.util.ArrayList;

import javax.swing.JButton;

public class Scores extends Alphabet {
    static private int combo = 0;
	static private int highestcombo = 0;
	static private double accuracy = 0;
	static private double score = 0;
	static private String difficulty = "";

	static private int correct = 0;
	final private int alphabetsize = 26;

	final private double accuracy_portion = 0.3;
	final private double combo_portion = 0.7;

	static  ArrayList<Scores> ScoreboardArray = new ArrayList<Scores>();

    public Scores() {
		difficulty = "Learning Mode";
	}

    public Scores(String difficulty, double accuracy, double score, int highestcombo) {
		Scores.difficulty = difficulty;
		Scores.accuracy = accuracy;
		Scores.score = score;
		combo = highestcombo;
		ScoreboardArray.add(this);
	}

	public static void check (JButton i, int j) {
        checkanswer.add(i);
        if (checkanswer.size() == 0) {
            if (i == A) {
				addCorrect();
            }
        }
		if (i != alphabet.get(j)) {
			checkanswer.clear();
		}
        
        
    }

    public int getCombo() {
		return combo;
	}

    public String getDifficulty() {
        return difficulty;
    }

    public double getAccuracy() {
		return accuracy;
	}

	public double getScore() {
		return score;
	}

	public void setDifficulty(String difficulty) {
		Scores.difficulty = difficulty;
	}

	public static void addCorrect() {
		correct++;
		combo++;
	}

	public void miss() {
		if (highestcombo == 0) {
			highestcombo = combo;
		}

		if (combo >= highestcombo) {
			highestcombo = combo;
		}
		combo = 0;
	}

	public void calculateAccuracy() {
		if (correct == 0) {
			System.out.println("correct is 0");
			return;
		}
		accuracy = correct / alphabetsize;
	}

	public void calculateScore() {
		score = 1000000 * ((accuracy * accuracy_portion) + (combo / alphabetsize * combo_portion));
	}

}
