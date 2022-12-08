import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scores extends Alphabet {
	static private int combo = 0;
	static private int highestcombo = 0;
	static private double accuracy = 0;
	static private double score = 0;
	static private String difficulty = "";

	static private int correct = 0;

	static final private int alphabetsize = 26;

	final private double accuracy_portion = 0.3;
	final private double combo_portion = 0.7;

	static  ArrayList<Scores> ScoreboardArray = new ArrayList<Scores>();


    public Scores(String difficulty, double accuracy, double score, int highestcombo) {
		Scores.difficulty = difficulty;
		Scores.accuracy = accuracy;
		Scores.score = score;
		Scores.highestcombo = highestcombo;
		ScoreboardArray.add(this);
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

	//TODO: here

	public static void writeScoreboard() throws IOException {
        String ScoreS = "" + score;
        String ComboS = "" + combo;
        String AccuracyS = "" + accuracy;
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt"));
		writer.write(difficulty);
        writer.newLine();
        writer.write(ScoreS);
        writer.newLine();
        writer.write(ComboS);
        writer.newLine();
        writer.write(AccuracyS);
        writer.newLine();
        writer.flush();
        writer.close();
    }

    public void addData() throws IOException {
		String ScoreS = "" + score;
        String ComboS = "" + combo;
        String AccuracyS = "" + accuracy;
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt", true));
		writer.write(difficulty);
        writer.newLine();
        writer.write(ScoreS);
        writer.newLine();
        writer.write(ComboS);
        writer.newLine();
        writer.write(AccuracyS);
        writer.newLine();
        writer.flush();
        writer.close();
    }

    public void readScoreboard() {
        try {
            File Scoreboard = new File ("Scoreboard.txt");
            Scanner ScoreboardReader = new Scanner (Scoreboard);
            while (ScoreboardReader.hasNextLine()) {
                String DifficultyInput = ScoreboardReader.next();
                if (DifficultyInput.charAt(0) == 'M') {
                    DifficultyInput = "Matching Mode";
                }
                if (DifficultyInput.charAt(0) == 'F') {
                    DifficultyInput = "Fun Mode";
                }
                String ScoreInput = ScoreboardReader.next();
                String ComboInput = ScoreboardReader.next();
                String AccuracyInput = ScoreboardReader.next();
                try {
                    Double ScoreConverted = Double.parseDouble(ScoreInput);
                    Integer ComboConverted = Integer.parseInt(ComboInput);
                    Double AccuracyConverted = Double.parseDouble(AccuracyInput);
                    new Scores (DifficultyInput, AccuracyConverted, ScoreConverted, ComboConverted);
                } catch (Exception e) {
                    System.out.println("Parse Error");
                }
            }
            ScoreboardReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find file! Make a new Scoreboard!");
        } 
    }

}
