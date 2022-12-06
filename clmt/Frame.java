import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

class Frame extends JFrame {
	JFrame Frame = new JFrame();
	final static int alphabetsize = 26;

	ArrayList<Integer> parent = new ArrayList<Integer>(alphabetsize);
	ArrayList<JButton> alphabet = new ArrayList<JButton>(alphabetsize);

	FlowLayout layout = new FlowLayout();

	JButton LM = new JButton("Learning Mode!");
	JButton FM = new JButton("Fun Mode!");
	JButton TM = new JButton("Matching Mode!");

	/**
	 * JButton A = new JButton("A");
	 * JButton B = new JButton("B");
	 * JButton C = new JButton("C");
	 * JButton D = new JButton("D");
	 * JButton E = new JButton("E");
	 * JButton F = new JButton("F");
	 * JButton G = new JButton("G");
	 * JButton H = new JButton("H");
	 * JButton I = new JButton("I");
	 * JButton J = new JButton("J");
	 * JButton K = new JButton("K");
	 * JButton L = new JButton("L");
	 * JButton M = new JButton("M");
	 * JButton N = new JButton("N");
	 * JButton O = new JButton("O");
	 * JButton P = new JButton("P");
	 * JButton Q = new JButton("Q");
	 * JButton R = new JButton("R");
	 * JButton S = new JButton("S");
	 * JButton T = new JButton("T");
	 * JButton U = new JButton("U");
	 * JButton V = new JButton("V");
	 * JButton W = new JButton("W");
	 * JButton X = new JButton("X");
	 * JButton Y = new JButton("Y");
	 * JButton Z = new JButton("Z");
	 **/

	public Frame() {
		Frame.setSize(800, 800);
		Frame.setLocation(null);
		Frame.setTitle("Alphabet Game");
		Frame.setLayout(layout);
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop
		FramePrompt();
	}

	public void FramePrompt() {
		Frame.add(new JLabel("Welcome to Alphabet Learning App!"));
		Frame.add(new JLabel("Hint: Turn your sound on for the best experience!"));
		Frame.add(new JLabel("Select one of the three game modes: "));
		Frame.add(LM);
		Frame.add(FM);
		Frame.add(TM);
	}

	public void LearningMode() {
		Frame.add(new JLabel("Here is the alphabet in order, with sounds"));
		for (int i = 0; i < alphabetsize; i++) {
			Frame.add(alphabet.get(i));
		}
		// TODO: sounds
	}

	public void FunMode() {
		Frame.add(new JLabel("Order the alphabet backwards!"));
	}

	public void MatchingMode() {
		Frame.add(new JLabel("Order the alphabet in order!"));
		randomizealphabet();
	}

	public void clear() {
		Frame.removeAll();
		Frame.revalidate();
		Frame.repaint();
	}

	public void initializealphabet() {
		for (char i = 65; i <= 90; i++) {
			String temp = Character.toString(i);
			alphabet.add(new JButton(temp));
		}
	}

	public void initializeParent() {
		for (int i = 0; i < alphabetsize; i++) {
			parent.add(i);
		}
	}

	public void randomizealphabet() {
		Random rand = new Random();
		while (parent.size() > 0) {
			int index = rand.nextInt(parent.size());
			Frame.add(alphabet.get(index));
			parent.remove(index);
		}
		if (parent.size() == 0) {
			initializeParent();
		}
	}

}
