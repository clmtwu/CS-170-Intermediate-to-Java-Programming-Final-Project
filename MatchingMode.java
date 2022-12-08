import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MatchingMode extends Alphabet {
    static JFrame MMFrame = new JFrame();
	static JFrame AlphabetPrint = new JFrame();
	static JFrame ResultFrame = new JFrame();

	static private int answerindex = 0;
	static private int combo = 0;
	static private int highestcombo = 0;
	static private double accuracy = 0;
	static private double score = 0;
	static private String difficulty = "Matching Mode";
	

	static private int correct = 0;

	private static JLabel MMPrompt = new JLabel ("Arrange the Alphabet in order!", SwingConstants.CENTER);

	static JLabel MMCombo = new JLabel ("Your highest combo: " + combo);
	static JLabel MMAccuracy = new JLabel ("Your accuracy: " + accuracy);
	static JLabel MMScore = new JLabel ("Your score was: " + score);

	static JButton Confirm = new JButton ("Return to home screen!");
	static JButton Replay = new JButton ("Play Again!");

	public MatchingMode() {
		setUp();
		MMFrame.add(MMPrompt, BorderLayout.CENTER);
		MMFrame.setVisible(true);
		randomizealphabet();
	}

	public void setUp() {
		MMFrame.setSize(400, 150); 
        MMFrame.setTitle("Matching Mode - Control Panel!");
        MMFrame.setLayout(LMFrameLayout);
        MMFrame.setResizable(false);
        MMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

		ResultFrame.setSize(400, 400); 
        ResultFrame.setTitle("Matching Mode - Results!");
        ResultFrame.setLayout(LMFrameLayout);
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

		MMPrompt.setBorder(TitleBorder);

		Alphabet.OrderedInt();
		setAnswers();
		Alphabet.setUpAlphabet();
		Alphabet.RandomInt();
	}

    public void randomizealphabet() {
		AlphabetPrint.setLayout(new GridLayout(alphabet.size(), 1));
		for (int i = 0; i < alphabetsize; i++) {
			AlphabetPrint.add(alphabet.get(reference[i]));
		}
        AlphabetPrint.setVisible(true);
	}

	public static void check (JButton i, int j) {
		checkanswer.add(i);
		if (j != answer[answerindex]) {
			JOptionPane.showMessageDialog(null, "So Close! The right answer was " + answerS.get(answerindex).toUpperCase() + "!"); //prompt to correct error
			checkanswer.remove(i);
			combo = 0;
			return;
		}
		correct++;
		combo++;
		if (combo > highestcombo) {
			highestcombo = combo;
		}
		System.out.println(highestcombo);
		MatchingMode.removebutton(i);
		answerindex++;
		if (answerindex == 26) {
			JOptionPane.showMessageDialog(null, "Congradulations! You have won!");
			MatchingMode.clear();
			return;

		}
    }

	public static void clear() {
		AlphabetPrint.setVisible(false); //you can't see me!
		AlphabetPrint.dispose(); //Destroy the JFrame object
		MMFrame.setVisible(false); //you can't see me!
		MMFrame.dispose(); //Destroy the JFrame object
		displayresults();
	}

	public static void displayresults() {
		ResultFrame.add(MMCombo);
		ResultFrame.add(MMAccuracy);
		ResultFrame.add(MMScore);
		ResultFrame.add(Confirm);
		ResultFrame.add(Replay);
		ResultFrame.setVisible(true);
	}

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
