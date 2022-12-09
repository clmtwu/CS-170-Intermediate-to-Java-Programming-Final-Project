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
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //importing required libraries

public class Scores extends Alphabet { 
	private int score = 0; //private instance variables
	private String name = "";
	private String difficulty = "";
	private final JLabel lblNewLabel = new JLabel("");
	
	static ArrayList<Scores> ScoreboardArray = new ArrayList<Scores>(); //main array to hold score objects
    ArrayList<Scores> TopFive = new ArrayList<Scores>(5); //temporary array to hold sorted score objects

	JFrame Leaderboard = new JFrame(); //three frames to show different things, abstraction and easier manipulation
    JFrame SaveFile = new JFrame();
    JFrame Results = new JFrame();

    JLabel Title = new JLabel("Leaderboard:"); //titles for jframes

    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300); //dimensions for each item
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);

    Dimension JButtonSize = new Dimension (200, 100);
    Dimension LongJButtonSize = new Dimension (250, 100);
    Dimension MainPicture = new Dimension (800, 800);

    JButton New = new JButton("Create a new file!"); //buttons with prompts 
    JButton Existing = new JButton ("I have a save file!");
    JButton Confirm = new JButton ("OK!");
    JButton Append = new JButton ("Add new scores to old scores!");
    JButton Keep = new JButton ("Display only old scores!");
    
    public Scores() { //main run that set up entire class
        setUp();
        Leaderboard.setVisible(true);
        Leaderboard.add(Title);
        Leaderboard.add(New);
        Leaderboard.add(Existing);
        lblNewLabel.setIcon(new ImageIcon(MatchingMode.class.getResource("/images/Podium.jpg")));
        Leaderboard.add(lblNewLabel);
    }

    public Scores(String name, String difficulty, int score) { //initializing new object with parameters
        this.name = name;
		this.difficulty = difficulty;
		this.score = score;
		ScoreboardArray.add(this);
	}

    public int getScores() { //getters and setters for array index and actual returns
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

    public void setUp() { //setting up diagrams to conversions
        Leaderboard.setSize(800, 900);
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
        Keep.setPreferredSize(JButtonSize);
        Append.setPreferredSize(JButtonSize);

        Title.setBorder(TitleBorder);

        Confirm.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for confirm button
            public void actionPerformed(ActionEvent e) {
                Leaderboard.setVisible(false); //you can't see me!
                Leaderboard.dispose(); //Destroy the JFrame object
                new Frame(); //back to main
            }
        });

        New.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for new button
            public void actionPerformed(ActionEvent e) {
                try {
                    if (ScoreboardArray.size() <= 5) { //directly writing score if there are less than or equal to 5 scores
                        writeScoreboard();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "You have more than five scores! Saving only the top five scores...");
                        compare(); //prompt to display that there are more than 5 scores and calling method to call more files
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void compare() throws IOException { //comparing original arraylist for the highest scores, NOT importing anything
        Integer [] temporary = new Integer [6]; //new integer array to hold index
        for (int i = 0; i < ScoreboardArray.size(); i++) { //adding scores to temporary index
            temporary[i] = ScoreboardArray.get(i).getScores();
        } 
        Arrays.sort(temporary); //works
        Collections.reverse(Arrays.asList(temporary)); //works

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < ScoreboardArray.size(); j++) {
                if (temporary[i] == ScoreboardArray.get(j).getScores()) { //adding objects if they fit from integers
                    TopFive.add(ScoreboardArray.get(i));
                }
            }
        }
        writeScoreboard(TopFive); //writing new updated arraylist
    }

	public void writeScoreboard() throws IOException { //writing default scoreboard
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt")); //new writer with destination file name
        for (int i = 0; i < ScoreboardArray.size(); i++) {
            writer.write(ScoreboardArray.get(i).toString(i)); //calling to string for every single object, writing, and flushing to output
            writer.flush();
        }
        writer.close();
        JOptionPane.showMessageDialog(null, "Writing was successful!");
    }

    public void writeScoreboard(ArrayList<Scores> newlist) throws IOException { //writing updated scoreboard with 5 highest scores, same function as above
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt"));
        for (int i = 0; i < newlist.size(); i++) {
            writer.write(newlist.get(i).toString(i));
            writer.flush();
        }
        writer.close();
        JOptionPane.showMessageDialog(null, "Writing was successful!");
    }

    public void addScores() { //adding new labels with object details
        for (int i = 0; i < ScoreboardArray.size(); i++) {
            Results.add(new JLabel (ScoreboardArray.get(i).getName()));
            Results.add(new JLabel (ScoreboardArray.get(i).getDifficulty()));
            Results.add(new JLabel ("" + ScoreboardArray.get(i).getScores()));
        }
        Results.add(Confirm); //adding confirmation prompt
        Results.setVisible(true); //making it visible
    }

    public void readScoreboard() { //method to take in scoreboard.txt input and make it a new object
        try {
            File Scoreboard = new File ("Scoreboard.txt"); //reading file
            Scanner ScoreboardReader = new Scanner (Scoreboard); //adding scanner to file
            while (ScoreboardReader.hasNextLine()) { //if input is available, take in lines
                String NameInput = ScoreboardReader.next();
                String DifficultyInputWordOne = ScoreboardReader.next();
                String DifficultyInputWordTwo = ScoreboardReader.next();
                String ScoreInput = ScoreboardReader.next();
                Integer ScoreConverted = Integer.parseInt(ScoreInput);
                new Scores(NameInput, DifficultyInputWordOne + " " + DifficultyInputWordTwo, ScoreConverted); //passing in new scores
                if (ScoreboardArray.size() == 5) { //if full, displaying results, displaying prompt, going back to main, breaking
                    JOptionPane.showMessageDialog(null, "Loading was successful!");
                    addScores();
                    new Frame();
                    break;
                }
            }
            ScoreboardReader.close(); //closing
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find file! Make a new Scoreboard!"); //error prompt is file is not found
        } 
    }
}
