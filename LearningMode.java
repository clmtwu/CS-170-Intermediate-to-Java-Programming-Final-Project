import javax.swing.*;
import java.awt.event.*; //importing awt for customization
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class LearningMode extends Alphabet {
    JFrame LMFrame = new JFrame();
    JFrame AlphabetPrint = new JFrame();

    JButton LMConfirm = new JButton ("Okay, I got it!");

    JLabel LMPrompt = new JLabel ("Here is the alphabet in order from top to bottom!", SwingConstants.CENTER);

    public void setup() {
        LMFrame.setSize(300, 300); 
        LMFrame.setTitle("Learning Mode - Control Panel!");
        LMFrame.setLayout(LMFrameLayout);
        LMFrame.setResizable(false);
        LMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

        AlphabetPrint.setSize(500, 1000); 
        AlphabetPrint.setTitle("Learning Mode - Alphabet!");
        AlphabetPrint.setResizable(false);
        AlphabetPrint.setLocationRelativeTo(null);
        AlphabetPrint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

        LMConfirm.setForeground(Color.GREEN);

        LMPrompt.setBorder(TitleBorder);

        LMConfirm.setPreferredSize(StandardJButtonSize);

        Alphabet.setUpAlphabet();
    }

    public LearningMode() {
        setup();
        LMFrame.setVisible(true);
		LMFrame.add(LMPrompt, BorderLayout.CENTER);
        LMFrame.add(LMConfirm);
        //LMFrame.add(LMRepeat);
        printAlphabetinOrder();
        LMConfirm.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                AlphabetPrint.setVisible(false);
                AlphabetPrint.dispose();
                LMFrame.setVisible(false); //you can't see me!
                LMFrame.dispose(); //Destroy the JFrame object
                new Frame();
            }
        });
    }

    public void printAlphabetinOrder() {
        AlphabetPrint.setLayout(new GridLayout(alphabet.size(), 1));
        for (int i = 0; i < alphabet.size(); i++) {
            AlphabetPrint.add(alphabet.get(i), BorderLayout.CENTER);
        }
        AlphabetPrint.setVisible(true);
    }

    public static void main(String[] args) {
        new LearningMode();
    }
}
