import java.awt.GridLayout;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

class Frame extends JFrame {
	final static int alphabetsize = 26;

	ArrayList<Integer> parent = new ArrayList<Integer>(alphabetsize);

	FlowLayout layout = new FlowLayout(); // flow layout to control button and label placements

	String introduction = "Welcome to Alphabet Learning App!\nPlease turn your sound on for the best experience!\nPlease select one of the three game modes:";
	String answer = "Here is the alphabet in order, with sounds";

	JLabel intro = new JLabel(introduction);
	JLabel ans = new JLabel(answer);

	JButton LM = new JButton("Learning Mode!");
	JButton FM = new JButton("Fun Mode!");
	JButton TM = new JButton("Matching Mode!");

	JButton A = new JButton("A");
	JButton B = new JButton("B");
	JButton C = new JButton("C");
	JButton D = new JButton("D");
	JButton E = new JButton("E");
	JButton F = new JButton("F");
	JButton G = new JButton("G");
	JButton H = new JButton("H");
	JButton I = new JButton("I");
	JButton J = new JButton("J");
	JButton K = new JButton("K");
	JButton L = new JButton("L");
	JButton M = new JButton("M");
	JButton N = new JButton("N");
	JButton O = new JButton("O");
	JButton P = new JButton("P");
	JButton Q = new JButton("Q");
	JButton R = new JButton("R");
	JButton S = new JButton("S");
	JButton T = new JButton("T");
	JButton U = new JButton("U");
	JButton V = new JButton("V");
	JButton W = new JButton("W");
	JButton X = new JButton("X");
	JButton Y = new JButton("Y");
	JButton Z = new JButton("Z");

	public Frame() {
		setSize(600, 400);
		setLocation(500, 0);
		setTitle("game");
		setLayout(new GridLayout(3, 13));
		setVisible(true);
		FramePrompt();
	}

	public void FramePrompt() {
		add(intro);
		add(LM);
		add(FM);
		add(TM);

	}

	public void LearningMode() {
		add(A);
		add(B);
		add(C);
		add(D);
		add(E);
		add(F);
		add(G);
		add(H);
		add(I);
		add(J);
		add(K);
		add(L);
		add(M);
		add(N);
		add(O);
		add(P);
		add(Q);
		add(R);
		add(S);
		add(T);
		add(U);
		add(V);
		add(W);
		add(X);
		add(Y);
		add(Z);
	}

	public void initializeParent() {
		for (int i = 1; i <= alphabetsize; i++) {
			parent.add(i);
		}
	}

	public void randomizealphabet() {

	}

	public int returnRandom() {
		Random rand = new Random();
		int index = rand.nextInt(parent.size());
		return index; // TODO: remove the index in the switch statements
	}

	public static void main(String[] args) {
	}

}
