import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scores extends Alphabet {
    private int combo = 0;
	private int highestcombo = 0;
	private double accuracy = 0;
	private double score = 0;
	private String name = "";


	static  ArrayList<Scores> ScoreboardArray = new ArrayList<Scores>();


    public Scores(String name, double accuracy, double score, int highestcombo) {
		this.name = name;
		this.accuracy = accuracy;
		this.score = score;
		this.highestcombo = highestcombo;
		ScoreboardArray.add(this);
	}

	public void calculateScore() {
		score = combo;
	}

	//TODO: here

	public void writeScoreboard() throws IOException {
        String ScoreS = "" + score;
        String ComboS = "" + combo;
        String AccuracyS = "" + accuracy;
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt"));
		writer.write(name);
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
		writer.write(name);
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

    public static void readScoreboard() {
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
