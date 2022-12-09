/********************************************************************************* 
Name: Hengjin, Clement, Eric
Course: CS170-01
Lab #: project
Submission Date: 10:00pm thurs 12/8/2022 
Brief Description:  This class houses all the code for the Matching game mode, it creates the frames and calls the music/image from the sound and alphabet class.
*********************************************************************************/ 
package stuff;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.Color;

public class MatchingMode extends Alphabet {
	//fields
    static JFrame MMFrame = new JFrame();
	static JFrame AlphabetPrint = new JFrame();
	static JFrame ResultFrame = new JFrame();

	static private String difficulty = "Matching Mode";
    static private String name = "";
	static private int correct = 0;

	static final private int alphabetsize = 26;
    static private int answerindex = 0;
    //end of fields
	private static JLabel MMPrompt = new JLabel ("Arrange the Alphabet in order!", SwingConstants.CENTER);//Jlabel promt
	JButton MMConfirm = new JButton ("Return to Menu");//button to return to menu

	static JLabel MMScore = new JLabel ("Your score was: " + correct); 

	static JButton Confirm = new JButton ("Return to home screen!");
	static JButton Replay = new JButton ("Play Again!");
	private final JLabel lblNewLabel = new JLabel("");

	public MatchingMode() {//start of MatchingMode method
		name = JOptionPane.showInputDialog("Please enter your name! ");
		setUp();
		MMPrompt.setForeground(Color.GREEN);//sets text color
		MMFrame.getContentPane().add(MMPrompt, BorderLayout.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MatchingMode.class.getResource("/images/Questionmark.jpeg")));//sets a image 
		
		MMFrame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		MMFrame.getContentPane().setBackground(Color.BLUE); //sets background color
		MMFrame.setVisible(true);
		AlphabetPrint.getContentPane().setLayout(new GridLayout(alphabet.size(), 1));//sets up the alphabet in terms of the Arraylist
		for (int i = 0; i < alphabetsize; i++) {//loops to display the araylist
			AlphabetPrint.getContentPane().add(alphabet.get(reference[i]));
		}//end of loop
        AlphabetPrint.setVisible(true);
	}//end of MatchingMode method

	public void setUp() {//start of setUp method
		MMFrame.setSize(400, 600); 
        MMFrame.setTitle("Matching Mode - Control Panel!");
        MMFrame.getContentPane().setLayout(LMFrameLayout);
        MMFrame.setResizable(false);
        MMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

		ResultFrame.setSize(400, 400); 
        ResultFrame.setTitle("Matching Mode - Results!");
        ResultFrame.getContentPane().setLayout(LMFrameLayout);
        ResultFrame.setResizable(false);
		ResultFrame.setLocationRelativeTo(null);
        ResultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

		AlphabetPrint.setSize(70, 900); 
        AlphabetPrint.setTitle("Matching Mode - Match!");
        AlphabetPrint.setResizable(false);
        AlphabetPrint.setLocationRelativeTo(null);
        AlphabetPrint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

		Confirm.setPreferredSize(StandardJButtonSize);
		Replay.setPreferredSize(StandardJButtonSize);
		MMConfirm.setForeground(Color.GREEN); //sets text color
		
		MMConfirm.setPreferredSize(StandardJButtonSize);
		MMPrompt.setBorder(TitleBorder);

		Alphabet.OrderedInt();
		setAnswers();
		Alphabet.setUpAlphabet();
		Alphabet.RandomInt();
		MMFrame.getContentPane().add(MMConfirm);
		 MMConfirm.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
	            public void actionPerformed(ActionEvent e){ //method of execution
	                AlphabetPrint.setVisible(false);
	                AlphabetPrint.dispose();
	                MMFrame.setVisible(false); //you can't see me!
	                MMFrame.dispose(); //Destroy the JFrame object
	                Arrays.fill(reference, null);
	                Arrays.fill(answer, null);
	                checkanswer.clear();//clears arraylist
	                alphabet.clear();//clears arraylist
	                sound.stop();//stops music
	                new Frame();//launches main menu
	            }
	        });
	}//end of setUp method
	public static void check (JButton i, int j) {//start of check method
		checkanswer.add(i);
		if (j != answer[answerindex]) {
			JOptionPane.showMessageDialog(null, "So Close! The right answer was " + answerS.get(answerindex).toUpperCase() + "!"); //prompt to correct error
			checkanswer.remove(i);
			return;
		}
		correct++;
		MatchingMode.removebutton(i);
		answerindex++;
		if (answerindex == 26) {
			JOptionPane.showMessageDialog(null, "Congradulations! You have won!");
			AlphabetPrint.setVisible(false); //you can't see me!
			AlphabetPrint.dispose(); //Destroy the JFrame object
			MMFrame.setVisible(false); //you can't see me!
			MMFrame.dispose(); //Destroy the JFrame object
			ResultFrame.getContentPane().add(MMScore);
			ResultFrame.getContentPane().add(Confirm);
			ResultFrame.getContentPane().add(Replay);
			ResultFrame.setVisible(true);
			new Scores(name, difficulty, correct);
			ResultFrame.setVisible(false); //you can't see me!
			ResultFrame.dispose(); //Destroy the JFrame object
			new Frame();
		}
    }//end of check method

	public static void removebutton(JButton i) {
		AlphabetPrint.remove(i);
	}

	public static void setAnswers() {
        A.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(A, 0);
            }
        });
        B.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(B, 1);
            }
        });
        C.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(C, 2);
            }
        });
        D.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(D, 3);
            }
        });
        E.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(E, 4);
            }
        });
        F.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(F, 5);
            }
        });
        G.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(G, 6);
            }
        });
        H.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(H, 7);
            }
        });
        I.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(I, 8);
            }
        });
        J.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(J, 9);
            }
        });
        K.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(K, 10);
            }
        });
        L.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(L, 11);
            }
        });
        M.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(M, 12);
            }
        });
        N.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(N, 13);
            }
        });
        O.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(O, 14);
            }
        });
        P.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(P, 15);
            }
        });
        Q.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(Q, 16);
            }
        });
        R.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(R, 17);
            }
        });
        S.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(S, 18);
            }
        });
        T.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(T, 19);
            }
        });
        U.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(U, 20);
            }
        });
        V.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(V, 21);
            }
        });
        W.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(W, 22);
            }
        });
        X.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(X, 23);
            }
        });
        Y.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(Y, 24);
            }
        });
        Z.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                MatchingMode.check(Z, 25);
            }
        });
    }

	public static void main(String[] args) {
		new MatchingMode();
	}
}