import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scores extends Alphabet {
	private double score = 0;
	private String name = "";
	private String difficulty = "";

	static  ArrayList<Scores> ScoreboardArray = new ArrayList<Scores>();

    public Scores(String name, String difficulty, int score) {
		this.difficulty = difficulty;
		this.name = name;
		this.score = score;
		ScoreboardArray.add(this);
	}

	public void writeScoreboard() throws IOException {
        String ScoreS = "" + score;
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt"));
		writer.write(name);
        writer.newLine();
        writer.write(ScoreS);
        writer.newLine();
		writer.write(difficulty);
        writer.newLine();
        writer.flush();
        writer.close();
    }

    public void addData() throws IOException {
		String ScoreS = "" + score;
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt", true));
		writer.write(name);
        writer.newLine();
        writer.write(ScoreS);
        writer.newLine();
		writer.write(difficulty);
        writer.newLine();
        writer.flush();
        writer.close();
    }

    public static void readScoreboard() {
        try {
            File Scoreboard = new File ("Scoreboard.txt");
            Scanner ScoreboardReader = new Scanner (Scoreboard);
            while (ScoreboardReader.hasNextLine()) {
                String ScoreInput = ScoreboardReader.next();
                String ComboInput = ScoreboardReader.next();
                String AccuracyInput = ScoreboardReader.next();
                try {
                    Double ScoreConverted = Double.parseDouble(ScoreInput);
                    Integer ComboConverted = Integer.parseInt(ComboInput);
                    Double AccuracyConverted = Double.parseDouble(AccuracyInput);
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
