import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	static Integer[] reference = new Integer[alphabetsize];
    static Integer[] answer = new Integer[alphabetsize];

    static ArrayList<JButton> checkanswer = new ArrayList<JButton>(alphabetsize);
	static ArrayList<JButton> alphabet = new ArrayList<JButton>(alphabetsize);

	FlowLayout FrameLayout = new FlowLayout(FlowLayout.CENTER);
    FlowLayout LMFrameLayout = new FlowLayout(FlowLayout.CENTER); 

    static Dimension LongJButtonSize = new Dimension (300, 100);
    static Dimension StandardJButtonSize = new Dimension (200, 50);

    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300);
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);

    Random random = new Random();

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

    public static void RandomInt() {
        for (int i = 0; i < reference.length; i++) {
            reference[i] = i;
        }
        Collections.shuffle(Arrays.asList(reference));
    }

    public static void OrderedInt() {
        for (int i = 0; i < reference.length; i++) {
            answer[i] = i;
        }
    }

    public static void setAnswers() {
        A.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(A, 0);
            }
        });
        B.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(B, 1);
            }
        });
        C.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(C, 2);
            }
        });
        D.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(D, 3);
            }
        });
        E.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(E, 4);
            }
        });
        F.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(F, 5);
            }
        });
        G.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(G, 6);
            }
        });
        H.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(H, 7);
            }
        });
        I.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(I, 8);
            }
        });
        J.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(J, 9);
            }
        });
        K.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(K, 10);
            }
        });
        L.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(L, 11);
            }
        });
        M.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(M, 12);
            }
        });
        N.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(N, 13);
            }
        });
        O.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(O, 14);
            }
        });
        P.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(P, 15);
            }
        });
        Q.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(Q, 16);
            }
        });
        R.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(R, 17);
            }
        });
        S.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(S, 18);
            }
        });
        T.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(T, 19);
            }
        });
        U.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(U, 20);
            }
        });
        V.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(V, 21);
            }
        });
        W.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(W, 22);
            }
        });
        X.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(X, 23);
            }
        });
        Y.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(Y, 24);
            }
        });
        Z.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e) {
                Scores.check(Z, 25);
            }
        });
    }

    

    
}
