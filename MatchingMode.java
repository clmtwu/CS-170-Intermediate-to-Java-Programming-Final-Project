import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MatchingMode extends Alphabet {
    static JFrame MMFrame = new JFrame();
	static JFrame AlphabetPrint = new JFrame();
	static JFrame ResultFrame = new JFrame();

	private static 

	JLabel MMPrompt = new JLabel ("Arrange the Alphabet in order!", SwingConstants.CENTER);

	static JLabel MMCombo = new JLabel ("Your highest combo: " + Scores.getCombo());
	static JLabel MMAccuracy = new JLabel ("Your accuracy: " + Scores.getAccuracy());
	static JLabel MMScore = new JLabel ("Your score was: " + Scores.getScore());

	static JButton Confirm = new JButton ("Return to home screen!");
	static JButton Replay = new JButton ("Play Again!");

	public MatchingMode() {
		setUp();
		MMFrame.add(MMPrompt, BorderLayout.CENTER);
		MMFrame.setVisible(true);
		randomizealphabet();
		Scores.setDifficulty("Matching Mode");
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
		Alphabet.setAnswers();
		Alphabet.setUpAlphabet();
		Alphabet.RandomInt();
		new Scores();
		Scores.setDifficulty("Matching Mode");
	}

    public void randomizealphabet() {
		AlphabetPrint.setLayout(new GridLayout(alphabet.size(), 1));
		for (int i = 0; i < alphabetsize; i++) {
			AlphabetPrint.add(alphabet.get(reference[i]));
		}
        AlphabetPrint.setVisible(true);
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

	public static void main(String[] args) {
		new MatchingMode();
	}
}
