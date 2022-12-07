
import javax.swing.Timer;
import javax.swing.*;
import java.awt.event.*; //importing awt for customization
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


class Frame extends JFrame implements ActionListener {
	JFrame Frame = new JFrame();
    JFrame LMFrame = new JFrame();
    JFrame FMFrame = new JFrame();
    JFrame MMFrame = new JFrame();

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

    JButton LMConfirm = new JButton ("Okay, I got it!");
    JButton LMRepeat = new JButton ("Please repeat one more time!");

    Dimension JButtonSize = new Dimension (200, 100);
    Dimension LongJButtonSize = new Dimension (250, 100);
    Dimension MainPicture = new Dimension (300, 300);

    JLabel FP1 = new JLabel ("Welcome to Alphabet Learning App!", SwingConstants.CENTER);
    JLabel FP2 = new JLabel("Turn your sound on for the best experience!", SwingConstants.CENTER);
    JLabel FP3 = new JLabel("Choose one game mode: ", SwingConstants.CENTER);
    JLabel FP4 = new JLabel("Or choose a system option:", SwingConstants.CENTER);

    JLabel LMPrompt = new JLabel ("Here is the alphabet in order, with sound!", SwingConstants.CENTER);

    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300);
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);

    Font CSMTitle = new Font("Comic Sans MS", Font.BOLD, titlefont);
    Font CSMBody = new Font ("Comic Sans MS", Font.PLAIN, bodyfont);

    Random rand = new Random();


    
    

	public Frame() {
		setUp();
		Frame.setVisible(true);
		FramePrompt();
	}

    public void setUp() { //initializing buttons and labels to specific text type, color, and size
        
        
         // scale it the smooth way  
        

        Frame.setSize(800, 800);
        Frame.setTitle("Alphabet Game");
        Frame.setLayout(FrameLayout);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

        LMFrame.setSize(1000, 1000); 
        LMFrame.setTitle("Learning Mode - Alphabet Game");
        LMFrame.setLayout(LMFrameLayout);
        LMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

        FP1.setFont(CSMTitle);
        FP2.setFont(CSMBody);
        FP3.setFont(CSMBody);
        FP4.setFont(CSMBody);

        FP1.setForeground(Color.BLUE);
        
        LMConfirm.setForeground(Color.GREEN);
        LMRepeat.setForeground(Color.RED);

        LM.setPreferredSize(JButtonSize);
        FM.setPreferredSize(JButtonSize);
        MM.setPreferredSize(JButtonSize);
        EXIT.setPreferredSize(JButtonSize);
        LEADERBOARD.setPreferredSize(JButtonSize);

        LMConfirm.setPreferredSize(JButtonSize);
        LMRepeat.setPreferredSize(LongJButtonSize);

        FP1.setBorder(TitleBorder);
        FP2.setBorder(RegularTextBorder);
        FP3.setBorder(TitleBorder);
        FP4.setBorder(RegularTextBorder);

        LMPrompt.setBorder(TitleBorder);
        LMConfirm.setBorder(RegularTextBorder);

        

        for (int i = 0; i < alphabetsize; i++) { //initializing reference array before program begins running
			parent.add(i);
		}
    }

	public void FramePrompt() {
        ImageIcon furry = new ImageIcon("C:\\-121610049297jvnolytdyr.png");
        Image image = furry.getImage(); // transform it 
        Image newimg = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        furry = new ImageIcon(newimg);  // transform it back
        JButton FURRY = new JButton(furry);
        FURRY.setPreferredSize(MainPicture);
		Frame.add(FP1, BorderLayout.CENTER);
        Frame.add(FURRY);
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
                LearningMode();
            }
        });
        FM.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                FunMode();
            }
        });
        MM.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                MatchingMode();
            }
        });
        EXIT.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                System.exit(0);
            }
        });
        LEADERBOARD.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                Leaderboard();
            }
        });
	}

	public void LearningMode() {
        LMFrame.setVisible(true);
		LMFrame.add(LMPrompt);
        Timer Timer = new Timer(800, this);
        Timer.start();
        LMFrame.add(LMConfirm);
        LMFrame.add(LMRepeat);
        LMConfirm.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                LMFrame.setVisible(false); //you can't see me!
                LMFrame.dispose(); //Destroy the JFrame object
                new Frame();
            }
        });
        LMRepeat.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                LearningMode();
            }
        });
	}


    public void Leaderboard() {

    }

	public void FunMode() {
		Frame.add(new JLabel("Order the alphabet backwards!"));
	}

	public void MatchingMode() {
		Frame.add(new JLabel("Order the alphabet in order!"));
		randomizealphabet();
	}

	public void initializeParent() {
		for (int i = 0; i < alphabetsize; i++) {
			parent.add(i);
		}
	}

	public void randomizealphabet() {
        Frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 25)); 
		while (parent.size() > 0) {
			int index = rand.nextInt(parent.size());
			Frame.add(alphabet.get(index));
			parent.remove(index);
		}
		if (parent.size() == 0) {
			initializeParent();
		}
	}

    public void actionPerformed(ActionEvent e) {
        for (char i = 65; i <= 90; i++) {
			String temp = Character.toString(i);
			alphabet.add(new JButton(temp));
		}
    }
}
