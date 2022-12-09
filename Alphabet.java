import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

public class Alphabet { 
    static JButton A = new JButton("A"); //hardcoding buttons because program needs to access them to manipulate
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

    final static int alphabetsize = 26; //size of alphabet
    final static int titlefont = 25; //size of title
    final static int bodyfont = 15; //size of body

    static ArrayList<String> answerS = new ArrayList<String>(Arrays.asList("a", "b ", "c", "d", "e", "f", "g", "h", "i", "j",
        "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        //string version that is idential with button names
    static ArrayList<String> answerSR = new ArrayList<String>(Arrays.asList("z", "y", "x", "w", "v", "u", "t", "s", "r", "q",
        "p", "o", "n", "m", "l", "k", "j", "i", "h", "g", "f", "e", "d", "c", "b", "a"));
        //above but in reversed order for fun mode

	static Integer[] reference = new Integer[alphabetsize]; //for random number
    static Integer[] answer = new Integer[alphabetsize + 1]; //for the answers

    static ArrayList<JButton> checkanswer = new ArrayList<JButton>(alphabetsize); //temporary button object
	static ArrayList<JButton> alphabet = new ArrayList<JButton>(alphabetsize);// arraylsit where all the buttons will be stored

	FlowLayout FrameLayout = new FlowLayout(FlowLayout.CENTER); //new layout
    FlowLayout LMFrameLayout = new FlowLayout(FlowLayout.CENTER); //new layout

    static Dimension LongJButtonSize = new Dimension (300, 100); //sizes for button
    static Dimension StandardJButtonSize = new Dimension (200, 50);//sizes for button

    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300);//sets borders
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);//sets borders

    Random random = new Random();

    public static void setUpAlphabet() {//this method adds all the buttons to the aklphabet arraylist
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
    }//end of setupalphabet method

    public void clearAlphabet() {
        alphabet.clear();//clears the arraylist
        checkanswer.clear();//clears the arraylist
        Arrays.fill(answer, null);
        Arrays.fill(reference, null);
    }

    public static void reverseAlphabet() {//this method is the same as setupalphabet but its reversed
        alphabet.add(Z);
        alphabet.add(Y);
        alphabet.add(X);
        alphabet.add(W);
        alphabet.add(V);
        alphabet.add(U);
        alphabet.add(T);
        alphabet.add(S);
        alphabet.add(R);
        alphabet.add(Q);
        alphabet.add(P);
        alphabet.add(O);
        alphabet.add(N);
        alphabet.add(M);
        alphabet.add(L);
        alphabet.add(K);
        alphabet.add(J);
        alphabet.add(I);
        alphabet.add(H);
        alphabet.add(G);
        alphabet.add(F);
        alphabet.add(E);
        alphabet.add(D);
        alphabet.add(C);
        alphabet.add(B);
        alphabet.add(A);
    }//end of reverseAlphabet

    public static void RandomInt() {//this method randomizes the arraylist
        for (int i = 0; i < reference.length; i++) {
            reference[i] = i;
        }
        Collections.shuffle(Arrays.asList(reference));
    }//end of RandomInt

    public static void OrderedInt() {//this method ouputs the arraylist in order
        for (int i = 0; i < reference.length; i++) {
            answer[i] = i;
        }
    }//end of OrderedInt

    public static void ReversedInt() {//this method outputs the list but in reverse
        int tempcounter = 0;
        for (int i = 25; i >= 0; i--) {
            answer[tempcounter] = i;
            tempcounter++;
        }
    }//end of ReversedInt
}
