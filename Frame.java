import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.event.*; //importing awt for customization
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Frame extends JFrame implements ActionListener {
	//fields
	JFrame Frame = new JFrame();
			
	final static int alphabetsize = 26;
    final static int titlefont = 25;
    final static int bodyfont = 15;
    //arraylist
	ArrayList<Integer> parent = new ArrayList<Integer>(alphabetsize);
	ArrayList<JButton> alphabet = new ArrayList<JButton>(alphabetsize);
	//layout
	FlowLayout FrameLayout = new FlowLayout(FlowLayout.CENTER);
    FlowLayout LMFrameLayout = new FlowLayout(FlowLayout.CENTER); 
    //buttons
	JButton LM = new JButton("Learning Mode!");
	JButton FM = new JButton("Fun Mode!");
	JButton MM = new JButton("Matching Mode!");
    JButton EXIT = new JButton ("Exit the program!");
    JButton LEADERBOARD = new JButton ("Show Leaderboard!");
    //sizes
    Dimension JButtonSize = new Dimension (200, 100);
    Dimension LongJButtonSize = new Dimension (250, 100);
    Dimension MainPicture = new Dimension (300, 300);
    //labels for
    JLabel FP1 = new JLabel ("Welcome to Alphabet Learning App!", SwingConstants.CENTER);
    JLabel FP2 = new JLabel("Turn your sound on for the best experience!", SwingConstants.CENTER);
    JLabel FP3 = new JLabel("Choose one game mode: ", SwingConstants.CENTER);
    JLabel FP4 = new JLabel("Or choose a system option:", SwingConstants.CENTER);
    //borders
    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300);
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);
    //fonts
    Font CSMTitle = new Font("Comic Sans MS", Font.BOLD, titlefont);
    Font CSMBody = new Font ("Comic Sans MS", Font.PLAIN, bodyfont);
    private final JLabel lblNewLabel = new JLabel("");
    private final JPanel panel = new JPanel();

	public Frame() { //method for setting up the frame
		setUp(); //sets it up
		Frame.getContentPane().setBackground(Color.GRAY);//setbackgorund
		Frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/images/Icon.jpg")));//sets the icon
		Frame.setVisible(true);//sets it to visible
		FramePrompt();
		LM.setBackground(Color.LIGHT_GRAY); //background for background
		LM.setForeground(Color.MAGENTA);	//background for text
		FM.setBackground(Color.LIGHT_GRAY);//background for background
		FM.setForeground(Color.CYAN);		//background for text
		MM.setBackground(Color.LIGHT_GRAY);//background for background
		MM.setForeground(Color.blue);	//background for text
		try {//try catch to handle exceptions for music
			sound.RunMusic("sound\\MenuMusic.wav");//plays music
		} catch (LineUnavailableException e1) {//catches exception
			e1.printStackTrace();
		}
	
	}//end of frame
    public void setUp() { //initializing buttons and labels to specific text type, color, and size
        Frame.setSize(800, 1000);
        Frame.setTitle("Alphabet Game");
        Frame.getContentPane().setLayout(FrameLayout);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop
        Frame.setBackground(Color.GRAY); 
        
        //sets the font/color for the JLabel and buttons
        FP1.setFont(CSMTitle);
        FP2.setForeground(Color.ORANGE);
        FP2.setFont(CSMBody);
        FP3.setForeground(new Color(0, 128, 0));
        FP3.setFont(CSMBody);
        FP4.setForeground(Color.BLACK);
        FP4.setBackground(new Color(240, 240, 240));
        FP4.setFont(CSMBody);

        FP1.setForeground(Color.BLUE);
        
        LM.setPreferredSize(JButtonSize);
        FM.setPreferredSize(JButtonSize);
        MM.setPreferredSize(JButtonSize);
        EXIT.setForeground(Color.RED);
        EXIT.setBackground(Color.LIGHT_GRAY);
        EXIT.setPreferredSize(JButtonSize);
        LEADERBOARD.setForeground(Color.DARK_GRAY);
        LEADERBOARD.setBackground(Color.LIGHT_GRAY);
        LEADERBOARD.setPreferredSize(JButtonSize);

        FP1.setBorder(TitleBorder);
        FP2.setBorder(RegularTextBorder);
        FP3.setBorder(TitleBorder);
        FP4.setBorder(RegularTextBorder);

        for (int i = 0; i < alphabetsize; i++) { //initializing reference array before program begins running
			parent.add(i);
		}
    }//end of setup

	public void FramePrompt() { //the method for 
		Frame.getContentPane().add(FP1, BorderLayout.CENTER);
		
		Frame.getContentPane().add(panel);
		lblNewLabel.setBackground(new Color(255, 128, 255));
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Frame.class.getResource("/images/Cartoonkids.jpg"))); //sets images for the frame
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//adds all the buttons 
		Frame.getContentPane().add(FP2, BorderLayout.CENTER);
        Frame.getContentPane().add(FP3, BorderLayout.CENTER);
		Frame.getContentPane().add(LM);
		Frame.getContentPane().add(FM);
		Frame.getContentPane().add(MM);
        Frame.getContentPane().add(FP4, BorderLayout.CENTER);
        Frame.getContentPane().add(EXIT);
        Frame.getContentPane().add(LEADERBOARD);
        LM.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                Frame.setVisible(false); //you can't see me!
                Frame.dispose(); //Destroy the JFrame object
                new LearningMode();
               
                sound.stop();//stops the music
                
                try { 
    				sound.RunMusic("sound\\Recording.wav"); //runs the new music
    			} catch (LineUnavailableException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			} 
            }
        });
        FM.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                Frame.setVisible(false); //you can't see me!
                Frame.dispose(); //Destroy the JFrame object
                new FunMode();//calls the funmode method 
                sound.stop();//stops current music
                try {
                	
    				sound.RunMusic("sound\\FunModeMusic.wav");//plays funmode music
    			} catch (LineUnavailableException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            }
        });
        MM.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                Frame.setVisible(false); //you can't see me!
                Frame.dispose(); //Destroy the JFrame object
                new MatchingMode();
                sound.stop();//stops current music
                try {
					sound.RunMusic("sound\\MatchingModeMusic.wav");//plays matchingmode music music
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
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
                sound.stop();//stops current music
                try {
    				sound.RunMusic("sound\\LeaderboardMusic.wav");//plays leaderboard music
    			} catch (LineUnavailableException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
            }
        });
	}//end of frameprompt class
    public void actionPerformed(ActionEvent e) {
        for (char i = 65; i <= 90; i++) {
			String temp = Character.toString(i);
			alphabet.add(new JButton(temp));
		}
    }
}//Frame class
