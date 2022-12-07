import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

public class Alphabet {
    static JButton A = new JButton("A");
    static JButton B = new JButton("B");
    static JButton C = new JButton("C");
    static JButton D = new JButton("D");
    static JButton E = new JButton("E");
    static JButton F = new JButton("F");
    static JButton G = new JButton("G");
    static JButton H = new JButton("H");
    static JButton I = new JButton("I");
    static JButton J = new JButton("J");
    static JButton K = new JButton("K");
    static JButton L = new JButton("L");
    static JButton M = new JButton("M");
    static JButton N = new JButton("N");
    static JButton O = new JButton("O");
    static JButton P = new JButton("P");
    static JButton Q = new JButton("Q");
    static JButton R = new JButton("R");
    static JButton S = new JButton("S");
    static JButton T = new JButton("T");
    static JButton U = new JButton("U");
    static JButton V = new JButton("V");
    static JButton W = new JButton("W");
    static JButton X = new JButton("X");
    static JButton Y = new JButton("Y");
    static JButton Z = new JButton("Z");

    final static int alphabetsize = 26;
    final static int titlefont = 25;
    final static int bodyfont = 15;

	static ArrayList<Integer> parent = new ArrayList<Integer>(alphabetsize);
	static ArrayList<JButton> alphabet = new ArrayList<JButton>(alphabetsize);

	FlowLayout FrameLayout = new FlowLayout(FlowLayout.CENTER);
    FlowLayout LMFrameLayout = new FlowLayout(FlowLayout.CENTER); 

    static Dimension LongJButtonSize = new Dimension (300, 100);
    static Dimension StandardJButtonSize = new Dimension (200, 50);

    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300);
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);

    public static void setUpAlphabet() {
        alphabet.add(A);
        alphabet.add(B);
        alphabet.add(C);
        alphabet.add(D);
        alphabet.add(E);
        alphabet.add(F);
        alphabet.add(G);
        alphabet.add(H);
        alphabet.add(I);
        alphabet.add(J);
        alphabet.add(K);
        alphabet.add(L);
        alphabet.add(M);
        alphabet.add(N);
        alphabet.add(O);
        alphabet.add(P);
        alphabet.add(Q);
        alphabet.add(R);
        alphabet.add(S);
        alphabet.add(T);
        alphabet.add(U);
        alphabet.add(V);
        alphabet.add(W);
        alphabet.add(X);
        alphabet.add(Y);
        alphabet.add(Z);
    }

    public static void setUpInteger() {
        for (int i = 0; i < alphabetsize; i++) {
            parent.add(i);
        }
    }

    
}
