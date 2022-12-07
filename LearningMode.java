import javax.swing.*;
import java.awt.event.*; //importing awt for customization
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class LearningMode extends Alphabet {
    JFrame LMFrame = new JFrame();

    JButton LMConfirm = new JButton ("Okay, I got it!");
    JButton LMRepeat = new JButton ("Please repeat one more time!"); //this one is correct

    JLabel LMPrompt = new JLabel ("Here is the alphabet in order!", SwingConstants.CENTER);

    public void setup() {
        Alphabet.setUp();
        LMFrame.setSize(1000, 1000); 
        LMFrame.setTitle("Learning Mode - Alphabet Game");
        LMFrame.setLayout(LMFrameLayout);
        LMFrame.setResizable(false);
        LMFrame.setLocationRelativeTo(null);

        LMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

        LMConfirm.setForeground(Color.GREEN);
        LMRepeat.setForeground(Color.RED);

        LMPrompt.setBorder(TitleBorder);

        LMConfirm.setPreferredSize(LongJButtonSize);
        LMRepeat.setPreferredSize(LongJButtonSize);
    }

    public LearningMode() {
        setup();
        LMFrame.setVisible(true);
		LMFrame.add(LMPrompt);
        for (int i = 0; i < parent.size(); i++) {
            LMFrame.add(alphabet.get(i));
        }
        LMFrame.add(LMConfirm);
        LMFrame.add(LMRepeat);
        LMConfirm.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                LMFrame.setVisible(false); //you can't see me!
                LMFrame.dispose(); //Destroy the JFrame object
                new Frame();
            }
        });
        LMRepeat.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                LMFrame.setVisible(false); //you can't see me!
                LMFrame.dispose(); //Destroy the JFrame object
                new LearningMode();
            }
        });
    }

    public static void main(String[] args) {
        new LearningMode();
    }
}
