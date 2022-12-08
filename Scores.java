import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scores extends Alphabet {
	private double score = 0;
	private String name = "";
	private String difficulty = "";

    int counter = 0;

	static ArrayList<Scores> ScoreboardArray = new ArrayList<Scores>();

	static JFrame Leaderboard = new JFrame();

    public Scores(String name, String difficulty, int score) {
		this.difficulty = difficulty;
		this.name = name;
		this.score = score;
		ScoreboardArray.add(this);
	}

    public double getScores() {
        return score;
    }

    public double arrayScores(int index) {
        return ScoreboardArray.get(index).getScores();
    }

    public String getName() {
        return name;
    }

    public String arrayName(int index) {
        return ScoreboardArray.get(index).getName();
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String arrayDifficulty(int index) {
        return ScoreboardArray.get(index).getDifficulty();
    }

    public String toString(int index) {
        return ScoreboardArray.get(index).getName() + " " + ScoreboardArray.get(index).getDifficulty() + " " +  ScoreboardArray.get(index).getScores();
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
