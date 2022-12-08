import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Scores extends Alphabet {
	static private int combo = 0;
	static private int highestcombo = 0;
	static private double accuracy = 0;
	static private double score = 0;
	static private String difficulty = "";

	static private int correct = 0;
	static private int answerindex = 0;
	static final private int alphabetsize = 26;

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
		Scores.highestcombo = highestcombo;
		ScoreboardArray.add(this);
	}

	public static void check (JButton i, int j) {
		checkanswer.add(i);
		if (j != answer[answerindex]) {
			JOptionPane.showMessageDialog(null, "So Close! The right answer was " + answerS.get(answerindex).toUpperCase() + "!"); //prompt to correct error
			checkanswer.remove(i);
			miss();
			return;
		}
		correct++;
		combo++;
		if (combo > highestcombo) {
			highestcombo = combo;
		}
		System.out.println(highestcombo);
		MatchingMode.removebutton(i);
		answerindex++;
		System.out.println(combo);
		if (answerindex == 26) {
			JOptionPane.showMessageDialog(null, "Congradulations! You have won!");
			MatchingMode.clear();
			return;
		}
    }

    public static int getCombo() {
		return highestcombo;
	}

    public String getDifficulty() {
        return difficulty;
    }

    public static double getAccuracy() {
		return accuracy;
	}

	public static double getScore() {
		return score;
	}

	public static void setDifficulty(String difficulty) {
		Scores.difficulty = difficulty;
	}


	public static void miss() {
		combo = 0;
	}

	public void calculateAccuracy() {
		if (correct == 0) {
			accuracy = 0;
		}
		else {
			accuracy = correct / alphabetsize;
		}
	}

	public void calculateScore() {
		score = 1000000 * ((accuracy * accuracy_portion) + (combo / alphabetsize * combo_portion));
	}

}
