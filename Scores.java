import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scores extends Alphabet {
	private int score = 0;
	private String name = "";
	private String difficulty = "";

	static ArrayList<Scores> ScoreboardArray = new ArrayList<Scores>();
    ArrayList<Scores> TopFive = new ArrayList<Scores>(5);

	JFrame Leaderboard = new JFrame();
    JFrame SaveFile = new JFrame();
    JFrame Results = new JFrame();

    JLabel Title = new JLabel("Leaderboard:");

    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300);
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);

    Dimension JButtonSize = new Dimension (200, 100);
    Dimension LongJButtonSize = new Dimension (250, 100);
    Dimension MainPicture = new Dimension (300, 300);

    JButton New = new JButton("Create a new file!");
    JButton Existing = new JButton ("I have a save file!");
    JButton Confirm = new JButton ("OK!");

    public Scores() {
        setUp();
        Leaderboard.setVisible(true);
        Leaderboard.add(Title);
        Leaderboard.add(New);
        Leaderboard.add(Existing);
    }

    public Scores(String name, String difficulty, int score) {
        this.name = name;
		this.difficulty = difficulty;
		this.score = score;
		ScoreboardArray.add(this);
	}

    public int getScores() {
        return score;
    }

    public int arrayScores(int index) {
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
        return ScoreboardArray.get(index).getName() + " " + ScoreboardArray.get(index).getDifficulty() + " " +  ScoreboardArray.get(index).getScores() + " ";
    }

    public Scores returnthouscore(int index) {
        return ScoreboardArray.get(index);
    }

    public void setUp() {
        Leaderboard.setSize(800, 800);
        Leaderboard.setTitle("Leaderboard");
        Leaderboard.setLayout(FrameLayout);
        Leaderboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop
        Leaderboard.setVisible(false);

        SaveFile.setSize(800, 800);
        SaveFile.setTitle("Save File");
        SaveFile.setLayout(FrameLayout);
        SaveFile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop
        SaveFile.setVisible(false);

        Results.setSize(800, 800);
        Results.setTitle("Results");
        Results.setLayout(FrameLayout);
        Results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop
        Results.setVisible(false);
        
        New.setPreferredSize(JButtonSize);
        Existing.setPreferredSize(JButtonSize);
        Confirm.setPreferredSize(JButtonSize);

        Title.setBorder(TitleBorder);

        Confirm.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Leaderboard.setVisible(false); //you can't see me!
                Leaderboard.dispose(); //Destroy the JFrame object
                new Frame();
            }
        });

        New.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ScoreboardArray.size() <= 5) {
                        writeScoreboard();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "You have more than five scores! Saving only the top five scores...");
                        compare();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        Existing.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                readScoreboard();
            }
        });
    }

    public void compare() throws IOException { //comparing original arraylist for the highest scores, NOT importing anything
        Integer [] temporary = new Integer [6];
        for (int i = 0; i < ScoreboardArray.size(); i++) {
            temporary[i] = ScoreboardArray.get(i).getScores();
            
        } 
        Arrays.sort(temporary); //works
        Collections.reverse(Arrays.asList(temporary)); //works

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < ScoreboardArray.size(); j++) {
                if (temporary[i] == ScoreboardArray.get(j).getScores()) {
                    TopFive.add(ScoreboardArray.get(i));
                }
            }
        }
        writeScoreboard(TopFive);
    }

	public void writeScoreboard() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt"));
        for (int i = 0; i < ScoreboardArray.size(); i++) {
            writer.write(ScoreboardArray.get(i).toString(i));
            writer.flush();
        }
        writer.close();
        JOptionPane.showMessageDialog(null, "Writing was successful!");
    }

    public void writeScoreboard(ArrayList<Scores> newlist) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt"));
        for (int i = 0; i < newlist.size(); i++) {
            writer.write(newlist.get(i).toString(i));
            writer.flush();
        }
        writer.close();
        JOptionPane.showMessageDialog(null, "Writing was successful!");
    }

    public void addScores() {
        for (int i = 0; i < ScoreboardArray.size(); i++) {
            Results.add(new JLabel (ScoreboardArray.get(i).getName()));
            Results.add(new JLabel (ScoreboardArray.get(i).getDifficulty()));
            Results.add(new JLabel ("" + ScoreboardArray.get(i).getScores()));
        }
        Results.add(Confirm);
        Results.setVisible(true);
    }

    public void addScores(ArrayList<Scores> arr) {
        for (int i = 0; i < arr.size(); i++) {
            Results.add(new JLabel (arr.get(i).getName()));
            Results.add(new JLabel (arr.get(i).getDifficulty()));
            Results.add(new JLabel ("" + arr.get(i).getScores()));
        }
        Results.add(Confirm);
        Results.setVisible(true);
    }

    public void addData(int count) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt", true));
        for (int i = count; i < 5; i++) {
            writer.write(ScoreboardArray.get(i).toString(i));
            writer.flush();
        }
        writer.close();
    }

    public void readScoreboard() {
        try {
            File Scoreboard = new File ("Scoreboard.txt");
            Scanner ScoreboardReader = new Scanner (Scoreboard);
            while (ScoreboardReader.hasNextLine()) {
                String NameInput = ScoreboardReader.next();
                String DifficultyInputWordOne = ScoreboardReader.next();
                String DifficultyInputWordTwo = ScoreboardReader.next();
                String ScoreInput = ScoreboardReader.next();
                Integer ScoreConverted = Integer.parseInt(ScoreInput);
                new Scores(NameInput, DifficultyInputWordOne + DifficultyInputWordTwo, ScoreConverted);
                if (ScoreboardArray.size() == 5) {
                    JOptionPane.showMessageDialog(null, "Loading was successful!");
                    new Frame();
                    break;
                }
            }
            ScoreboardReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find file! Make a new Scoreboard!");
        } 
    }
}
