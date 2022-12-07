import java.util.ArrayList;

public class Scores {
    private int combo = 0;
	private int highestcombo = 0;
	private double accuracy = 0;
	private double score = 0;
	private String difficulty = "";

	private int correct = 0;
	final private int alphabetsize = 26;

	final private double accuracy_portion = 0.3;
	final private double combo_portion = 0.7;

	static  ArrayList<Scores> ScoreboardArray = new ArrayList<Scores>();

    public Scores() {
		difficulty = "Learning Mode";
	}

    public Scores(String difficulty, double accuracy, double score, int highestcombo) {
		this.difficulty = difficulty;
		this.accuracy = accuracy;
		this.score = score;
		combo = highestcombo;
		ScoreboardArray.add(this);
	}


    public void add() {
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
		this.difficulty = difficulty;
	}

	public void addCorrect() {
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
