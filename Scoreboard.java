import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scoreboard {
    

    public void writeScoreboard(int difficulty, double score, int combo, double accuracy) throws IOException {
        String ScoreS = "" + score;
        String ComboS = "" + combo;
        String AccuracyS = "" + accuracy;
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt"));
        writer.newLine();
        switch (difficulty) {
        case 0: writer.write("L");
            writer.newLine();
            break;
        case 1: writer.write("F");
            writer.newLine();
            break;
        case 2: writer.write("M");
            writer.newLine();
            break;
        }
        writer.write(ScoreS);
        writer.newLine();
        writer.write(ComboS);
        writer.newLine();
        writer.write(AccuracyS);
        writer.newLine();
        writer.flush(); //???
        writer.close();
    }
    /**
     * 
     * 
     */
    public void addData(int difficulty, double score, int combo, double accuracy) throws IOException {
        String ScoreS = "" + score;
        String ComboS = "" + combo;
        String AccuracyS = "" + accuracy;
        BufferedWriter writer = new BufferedWriter(new FileWriter("Scoreboard.txt", true));
        writer.newLine();
        switch (difficulty) {
        case 0: writer.write("L");
            writer.newLine();
            break;
        case 1: writer.write("F");
            writer.newLine();
            break;
        case 2: writer.write("M");
            writer.newLine();
            break;
        }
        writer.write(ScoreS);
        writer.newLine();
        writer.write(ComboS);
        writer.newLine();
        writer.write(AccuracyS);
        writer.newLine();
        writer.flush(); //???
        writer.close();
    }

    public void readScoreboard() {
        try {
            File Scoreboard = new File ("Scoreboard.txt");
            Scanner ScoreboardReader = new Scanner (Scoreboard);
            while (ScoreboardReader.hasNextLine()) {
                String DifficultyInput = ScoreboardReader.next();
                if (DifficultyInput.charAt(0) == 'L') {
                    DifficultyInput = "Learning Mode";
                }
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
