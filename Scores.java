import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scores extends Alphabet {
	static private double score = 0;
	static private String name = "";
	static private String difficulty = "";

    static int counter = 0;
    static final int length = 5;

	static ArrayList<Scores> ScoreboardArray = new ArrayList<Scores>();

	static JFrame Leaderboard = new JFrame();

    JLabel Title = new JLabel("Leaderboard:");

    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300);
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);

    Dimension JButtonSize = new Dimension (200, 100);
    Dimension LongJButtonSize = new Dimension (250, 100);
    Dimension MainPicture = new Dimension (300, 300);

    JButton New = new JButton("Create a new file!");
    JButton Existing = new JButton ("I have a save file!");
    JButton Confirm = new JButton ("OK!");

    public Scores(String name, String difficulty, int score) {
        Scores.name = name;
		Scores.difficulty = difficulty;
		Scores.score = score;
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

    public static String toString(int index) {
        return ScoreboardArray.get(index).getName() + " " + ScoreboardArray.get(index).getDifficulty() + " " +  ScoreboardArray.get(index).getScores() + " ";
    }

    public void setUp() {
        Leaderboard.setSize(800, 800);
        Leaderboard.setTitle("Leaderboard");
        Leaderboard.setLayout(FrameLayout);
        Leaderboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop
        Leaderboard.setVisible(false);
        
        New.setPreferredSize(JButtonSize);
        Existing.setPreferredSize(JButtonSize);
        Confirm.setPreferredSize(JButtonSize);

        Title.setBorder(TitleBorder);
    }

	public static void writeScoreboard() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt"));
        for (int i = 0; i < ScoreboardArray.size(); i++) {
            writer.write(Scores.toString(i));
            writer.flush();
        }
        writer.close();
    }

    public void run() {
        setUp();
        Leaderboard.setVisible(true);
        Leaderboard.add(Title);
    }

    public void addScores() {

    }

    public void addData(int count) throws IOException {
        if (count >= length) {
            System.out.println("count is greater than 5");
        }
		BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt", true));
        for (int i = count; i < length; i++) {
            writer.write(Scores.toString(i));
            writer.flush();
        }
        writer.close();
    }

    public static void readScoreboard() {
        try {
            File Scoreboard = new File ("Scoreboard.txt");
            Scanner ScoreboardReader = new Scanner (Scoreboard);
            while (ScoreboardReader.hasNextLine()) {
                if (counter > 5) {
                    System.out.println("too many files");
                    break;
                }
                String NameInput = ScoreboardReader.next();
                String ScoreInput = ScoreboardReader.next();
                String DifficultyInput = ScoreboardReader.next();
                try {
                    Integer ScoreConverted = Integer.parseInt(ScoreInput);
                    new Scores(NameInput, DifficultyInput, ScoreConverted);
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

    public static void test() throws IOException {
        new Scores("Clement", "Matching Mode", 2);
        new Scores("Clement", "Matching Mode", 2);
        new Scores("Clement", "Matching Mode", 2);
        writeScoreboard();
    }
}
