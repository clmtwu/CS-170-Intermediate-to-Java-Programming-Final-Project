import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.event.*; //importing awt for customization
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Frame extends JFrame implements ActionListener {
	
	JFrame Frame = new JFrame();
	
	
	final static int alphabetsize = 26;
    final static int titlefont = 25;
    final static int bodyfont = 15;

	ArrayList<Integer> parent = new ArrayList<Integer>(alphabetsize);
	ArrayList<JButton> alphabet = new ArrayList<JButton>(alphabetsize);

	FlowLayout FrameLayout = new FlowLayout(FlowLayout.CENTER);
    FlowLayout LMFrameLayout = new FlowLayout(FlowLayout.CENTER); 

	JButton LM = new JButton("Learning Mode!");
	JButton FM = new JButton("Fun Mode!");
	JButton MM = new JButton("Matching Mode!");
    JButton EXIT = new JButton ("Exit the program!");
    JButton LEADERBOARD = new JButton ("Show Leaderboard!");

    Dimension JButtonSize = new Dimension (200, 100);
    Dimension LongJButtonSize = new Dimension (250, 100);
    Dimension MainPicture = new Dimension (300, 300);

    JLabel FP1 = new JLabel ("Welcome to Alphabet Learning App!", SwingConstants.CENTER);
    JLabel FP2 = new JLabel("Turn your sound on for the best experience!", SwingConstants.CENTER);
    JLabel FP3 = new JLabel("Choose one game mode: ", SwingConstants.CENTER);
    JLabel FP4 = new JLabel("Or choose a system option:", SwingConstants.CENTER);

    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300);
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);

    Font CSMTitle = new Font("Comic Sans MS", Font.BOLD, titlefont);
    Font CSMBody = new Font ("Comic Sans MS", Font.PLAIN, bodyfont);

	public Frame() {
		setUp();
		Frame.setVisible(true);
		FramePrompt();
		LM.setForeground(Color.MAGENTA);	
		FM.setForeground(Color.CYAN);
		MM.setForeground(Color.blue);
		try {
			sound.RunMusic("sound\\MenuMusic.wav");
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
	
	}
    public void setUp() { //initializing buttons and labels to specific text type, color, and size
        Frame.setSize(800, 800);
        Frame.setTitle("Alphabet Game");
        Frame.setLayout(FrameLayout);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop
        Frame.setBackground(Color.GRAY);
        
        FP1.setFont(CSMTitle);
        FP2.setFont(CSMBody);
        FP3.setFont(CSMBody);
        FP4.setFont(CSMBody);

        FP1.setForeground(Color.BLUE);
        
        LM.setPreferredSize(JButtonSize);
        FM.setPreferredSize(JButtonSize);
        MM.setPreferredSize(JButtonSize);
        EXIT.setPreferredSize(JButtonSize);
        LEADERBOARD.setPreferredSize(JButtonSize);

        FP1.setBorder(TitleBorder);
        FP2.setBorder(RegularTextBorder);
        FP3.setBorder(TitleBorder);
        FP4.setBorder(RegularTextBorder);

        for (int i = 0; i < alphabetsize; i++) { //initializing reference array before program begins running
			parent.add(i);
		}
    } 

	public void FramePrompt() {
		Frame.add(FP1, BorderLayout.CENTER);
		Frame.add(FP2, BorderLayout.CENTER);
        Frame.add(FP3, BorderLayout.CENTER);
		Frame.add(LM);
		Frame.add(FM);
		Frame.add(MM);
        Frame.add(FP4, BorderLayout.CENTER);
        Frame.add(EXIT);
        Frame.add(LEADERBOARD);
        LM.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                Frame.setVisible(false); //you can't see me!
                Frame.dispose(); //Destroy the JFrame object
                new LearningMode();
                
                try {
    				sound.RunMusic("sound\\Recording.wav");
    			} catch (LineUnavailableException e1) {
    				e1.printStackTrace();
    			}
            }
        });
        FM.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                Frame.setVisible(false); //you can't see me!
                Frame.dispose(); //Destroy the JFrame object
                new FunMode();
                
                try {
                	
    				sound.RunMusic("sound\\FunModeMusic.wav");
    			} catch (LineUnavailableException e1) {
    				e1.printStackTrace();
    			}
            }
        });
        MM.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                Frame.setVisible(false); //you can't see me!
                Frame.dispose(); //Destroy the JFrame object
                new MatchingMode();
                
                try {
					sound.main(null);
				} catch (LineUnavailableException e1) {
					e1.printStackTrace();
				}
                
            }
        });
        EXIT.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                System.exit(0);        
            }
        });
        LEADERBOARD.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                Frame.setVisible(false); //you can't see me!
                Frame.dispose(); //Destroy the JFrame object
                try {
                    Scores.writeScoreboard();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
 
                try {
    				sound.RunMusic("sound\\LeaderboardMusic.wav");
    			} catch (LineUnavailableException e1) {
    				e1.printStackTrace();
    			}
            }
        });
	}

    public void actionPerformed(ActionEvent e) {
        for (char i = 65; i <= 90; i++) {
			String temp = Character.toString(i);
			alphabet.add(new JButton(temp));
		}
    }
}
