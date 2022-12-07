import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

public class Alphabet {
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

    final static int alphabetsize = 26;
    final static int titlefont = 25;
    final static int bodyfont = 15;

	ArrayList<Integer> parent = new ArrayList<Integer>(alphabetsize);
	static ArrayList<JButton> alphabet = new ArrayList<JButton>(alphabetsize);

	FlowLayout FrameLayout = new FlowLayout(FlowLayout.CENTER);
    FlowLayout LMFrameLayout = new FlowLayout(FlowLayout.CENTER); 

    Dimension LongJButtonSize = new Dimension (300, 100);

    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300);
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);

    public static void setUp() {
        for (char i = 65; i <= 90; i++) {
			String temp = Character.toString(i);
			alphabet.add(new JButton(temp));
		}
    }
}
