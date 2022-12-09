import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Arrays;
public class FunMode extends Alphabet {
	//fields
    static JFrame FMFrame = new JFrame();
	static JFrame AlphabetPrint = new JFrame();
	static JFrame ResultFrame = new JFrame();

	static private String difficulty = "Fun Mode";
    static private String name = "";
	static private int correct = 0;

	static final private int alphabetsize = 26;
    static private int answerindex = 0;
    //end of fields
    
	private static JLabel FMPrompt = new JLabel ("Arrange the Alphabet... but Backwards!", SwingConstants.CENTER);

	static JLabel FMScore = new JLabel ("Your score was: " + correct);
	JButton FMConfirm = new JButton ("Return to Menu");
	static JButton Confirm = new JButton ("Return to home screen!");
	static JButton Replay = new JButton ("Play Again!");

	public FunMode() {
        name = JOptionPane.showInputDialog("Please enter your name! ");//name prompt
		setUp();
		FMFrame.getContentPane().add(FMPrompt, BorderLayout.CENTER);//first pulls up the name prompt
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FunMode.class.getResource("/images/Funmode.jpeg")));//sets up a picture
		FMFrame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		FMFrame.getContentPane().setBackground(Color.ORANGE);//sets background color
		FMFrame.setVisible(true);
		AlphabetPrint.getContentPane().setLayout(new GridLayout(alphabet.size(), 1));
		for (int i = 0; i < alphabetsize; i++) {	//forloop that prints out the alphabet buttons
			AlphabetPrint.getContentPane().add(alphabet.get(reference[i]));
		}//end of forloop
        AlphabetPrint.setVisible(true);
        FMConfirm.setForeground(Color.GREEN); //sets text color
        
        FMConfirm.setPreferredSize(StandardJButtonSize);
        FMFrame.getContentPane().add(FMConfirm);
        FMConfirm.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                AlphabetPrint.setVisible(false);
                AlphabetPrint.dispose();
                FMFrame.setVisible(false); //you can't see me!
                FMFrame.dispose(); //Destroy the JFrame object
                Arrays.fill(reference, null);
                Arrays.fill(answer, null);
                checkanswer.clear();//clears arraylist
                alphabet.clear();//clears arraylist
                sound.stop();//stops current music
                new Frame();//runs main menu
            }
        });
	}

	public void setUp() {
		FMFrame.setSize(400, 700); 
        FMFrame.setTitle("Fun Mode - Control Panel!");
        FMFrame.getContentPane().setLayout(LMFrameLayout);
        FMFrame.setResizable(false);
        FMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

		ResultFrame.setSize(400, 400); 
        ResultFrame.setTitle("Fun Mode - Results!");
        ResultFrame.getContentPane().setLayout(LMFrameLayout);
        ResultFrame.setResizable(false);
		ResultFrame.setLocationRelativeTo(null);
        ResultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

		AlphabetPrint.setSize(70, 900); 
        AlphabetPrint.setTitle("Fun Mode - Match!");
        AlphabetPrint.setResizable(false);
        AlphabetPrint.setLocationRelativeTo(null);
        AlphabetPrint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

		Confirm.setPreferredSize(StandardJButtonSize);
		Replay.setPreferredSize(StandardJButtonSize);

		FMPrompt.setBorder(TitleBorder);

		Alphabet.ReversedInt();
		setAnswers(); //setting buttons to have actionlisteners
		Alphabet.reverseAlphabet(); 
		Alphabet.RandomInt();
	}

    public static void check (JButton i, int j) {//this method checks the answer and gives a response
		checkanswer.add(i);
		if (j != answer[answerindex]) {
			JOptionPane.showMessageDialog(null, "So Close! The right answer was " + answerSR.get(answerindex).toUpperCase() + "!"); //prompt to correct error
			checkanswer.remove(i);
			return;
		}//end of check
		correct++;
		FunMode.removebutton(i);//makes it so the same button cant be pressed again if correct
		answerindex++;
		if (answerindex == 26) {//if all 26 buttons are pressed then game ends
			JOptionPane.showMessageDialog(null, "Congradulations! You have won!");
            AlphabetPrint.setVisible(false); //you can't see me!
            AlphabetPrint.dispose(); //Destroy the JFrame object
            FMFrame.setVisible(false); //you can't see me!
            FMFrame.dispose(); //Destroy the JFrame object
            ResultFrame.getContentPane().add(FMScore);
            ResultFrame.getContentPane().add(Confirm);
            ResultFrame.getContentPane().add(Replay);
            ResultFrame.setVisible(true);
            new Scores(name, difficulty, correct);
            ResultFrame.setVisible(false); //you can't see me!
			ResultFrame.dispose(); //Destroy the JFrame object
			 Arrays.fill(reference, null);
	            Arrays.fill(answer, null);
	            checkanswer.clear();
	            alphabet.clear();
			new Frame();
		}
    }//end of check

	public static void removebutton(JButton i) {//method removes the button from being pressed
		AlphabetPrint.remove(i);
	}//end of removebutton

    public static void setAnswers() {
        A.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(A, 0);
            }
        });
        B.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(B, 1);
            }
        });
        C.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(C, 2);
            }
        });
        D.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(D, 3);
            }
        });
        E.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(E, 4);
            }
        });
        F.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(F, 5);
            }
        });
        G.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(G, 6);
            }
        });
        H.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(H, 7);
            }
        });
        I.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(I, 8);
            }
        });
        J.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(J, 9);
            }
        });
        K.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(K, 10);
            }
        });
        L.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(L, 11);
            }
        });
        M.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(M, 12);
            }
        });
        N.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(N, 13);
            }
        });
        O.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(O, 14);
            }
        });
        P.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(P, 15);
            }
        });
        Q.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(Q, 16);
            }
        });
        R.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(R, 17);
            }
        });
        S.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(S, 18);
            }
        });
        T.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(T, 19);
            }
        });
        U.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(U, 20);
            }
        });
        V.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(V, 21);
            }
        });
        W.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(W, 22);
            }
        });
        X.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(X, 23);
            }
        });
        Y.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(Y, 24);
            }
        });
        Z.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                FunMode.check(Z, 25);
            }
        });
    }//end of setAnswers method

	public static void main(String[] args) {
		new FunMode();
	}
}
