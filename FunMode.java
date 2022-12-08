import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunMode extends Alphabet {
    static JFrame FMFrame = new JFrame();
	static JFrame AlphabetPrint = new JFrame();
	static JFrame ResultFrame = new JFrame();

	static private String difficulty = "Fun Mode";
    static private String name = "";
	static private int correct = 0;

	static final private int alphabetsize = 26;
    static private int answerindex = 0;
    

	private static JLabel FMPrompt = new JLabel ("Arrange the Alphabet... but Backwards!", SwingConstants.CENTER);

	static JLabel FMScore = new JLabel ("Your score was: " + correct);

	static JButton Confirm = new JButton ("Return to home screen!");
	static JButton Replay = new JButton ("Play Again!");

	public FunMode() {
        name = JOptionPane.showInputDialog("Please enter your name! ");
		setUp();
		FMFrame.add(FMPrompt, BorderLayout.CENTER);
		FMFrame.setVisible(true);
		GameplayWindow();
	}

	public void setUp() {
		FMFrame.setSize(400, 150); 
        FMFrame.setTitle("Fun Mode - Control Panel!");
        FMFrame.setLayout(LMFrameLayout);
        FMFrame.setResizable(false);
        FMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

		ResultFrame.setSize(400, 400); 
        ResultFrame.setTitle("Fun Mode - Results!");
        ResultFrame.setLayout(LMFrameLayout);
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

    public void GameplayWindow() {
		AlphabetPrint.setLayout(new GridLayout(alphabet.size(), 1));
		for (int i = 0; i < alphabetsize; i++) {
			AlphabetPrint.add(alphabet.get(reference[i]));
		}
        AlphabetPrint.setVisible(true);
	}

	public static void clear() {
		AlphabetPrint.setVisible(false); //you can't see me!
		AlphabetPrint.dispose(); //Destroy the JFrame object
		FMFrame.setVisible(false); //you can't see me!
		FMFrame.dispose(); //Destroy the JFrame object
		displayresults();
	}

	public static void displayresults() {
		ResultFrame.add(FMScore);
		ResultFrame.add(Confirm);
		ResultFrame.add(Replay);
		ResultFrame.setVisible(true);
	}

    public static void check (JButton i, int j) {
		checkanswer.add(i);
		if (j != answer[answerindex]) {
			JOptionPane.showMessageDialog(null, "So Close! The right answer was " + answerS.get(answerindex).toUpperCase() + "!"); //prompt to correct error
			checkanswer.remove(i);
			return;
		}
		correct++;
		FunMode.removebutton(i);
		answerindex++;
		if (answerindex == 26) {
			JOptionPane.showMessageDialog(null, "Congradulations! You have won!");
            clear();
			return;
		}
    }

	public static void removebutton(JButton i) {
		AlphabetPrint.remove(i);
	}

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
    }

	public static void main(String[] args) {
		new FunMode();
	}
}
