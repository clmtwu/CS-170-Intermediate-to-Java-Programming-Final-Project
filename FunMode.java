import javax.swing.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class FunMode extends Alphabet {
    static JFrame FMFrame = new JFrame();
	static JFrame AlphabetPrint = new JFrame();
	static JFrame ResultFrame = new JFrame();

	private static JLabel FMPrompt = new JLabel ("Arrange the Alphabet... but Backwards!", SwingConstants.CENTER);

	static JLabel FMCombo = new JLabel ("Your highest combo: " + Scores.getCombo());
	static JLabel FMAccuracy = new JLabel ("Your accuracy: " + Scores.getAccuracy());
	static JLabel FMScore = new JLabel ("Your score was: " + Scores.getScore());

	static JButton Confirm = new JButton ("Return to home screen!");
	static JButton Replay = new JButton ("Play Again!");

	public FunMode() {
		setUp();
		FMFrame.add(FMPrompt, BorderLayout.CENTER);
		FMFrame.setVisible(true);
		randomizealphabet();
		Scores.setDifficulty("Fun Mode");
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
        AlphabetPrint.setTitle("Matching Mode - Match!");
        AlphabetPrint.setResizable(false);
        AlphabetPrint.setLocationRelativeTo(null);
        AlphabetPrint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

		Confirm.setPreferredSize(StandardJButtonSize);
		Replay.setPreferredSize(StandardJButtonSize);

		FMPrompt.setBorder(TitleBorder);

		Alphabet.ReversedInt();
		Alphabet.setAnswers(); //setting buttons to have actionlisteners
		Alphabet.reverseAlphabet(); 
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
		FMFrame.setVisible(false); //you can't see me!
		FMFrame.dispose(); //Destroy the JFrame object
		displayresults();
	}

	public static void displayresults() {
		ResultFrame.add(FMCombo);
		ResultFrame.add(FMAccuracy);
		ResultFrame.add(FMScore);
		ResultFrame.add(Confirm);
		ResultFrame.add(Replay);
		ResultFrame.setVisible(true);
	}

	public static void removebutton(JButton i) {
		AlphabetPrint.remove(i);
	}

	public static void main(String[] args) {
		new FunMode();
	}
}
