import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MatchingMode extends Alphabet {

    JFrame MMFrame = new JFrame();
	static JFrame AlphabetPrint = new JFrame();

	JLabel MMPrompt = new JLabel ("Arrange the Alphabet in order!", SwingConstants.CENTER);

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

		AlphabetPrint.setSize(500, 1000); 
        AlphabetPrint.setTitle("Matching Mode - Match!");
        AlphabetPrint.setResizable(false);
        AlphabetPrint.setLocationRelativeTo(null);
        AlphabetPrint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

		MMPrompt.setBorder(TitleBorder);
		Alphabet.setUpAlphabet();
		Alphabet.setAnswers();
		Alphabet.RandomInt();
	}

    public void randomizealphabet() {
		AlphabetPrint.setLayout(new GridLayout(alphabet.size(), 1));
		for (int i = 0; i < alphabetsize; i++) {
			AlphabetPrint.add(alphabet.get(reference[i]));
		}
        AlphabetPrint.setVisible(true);
	}

	public static void removebutton(JButton i) {
		AlphabetPrint.remove(i);
	}

	public static void main(String[] args) {
		new MatchingMode();
	}
}
