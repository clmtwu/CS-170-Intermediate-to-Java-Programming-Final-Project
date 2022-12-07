import javax.swing.Timer;
import javax.swing.*;
import java.awt.event.*; //importing awt for customization
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class LearningMode extends Frame {
    JFrame LMFrame = new JFrame();

    JButton LMConfirm = new JButton ("Okay, I got it!");
    JButton LMRepeat = new JButton ("Please repeat one more time!");

    JLabel LMPrompt = new JLabel ("Here is the alphabet in order, with sound!", SwingConstants.CENTER);

    public void setup() {
        LMFrame.setSize(1000, 1000); 
        LMFrame.setTitle("Learning Mode - Alphabet Game");
        LMFrame.setLayout(LMFrameLayout);
        LMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop
        LMConfirm.setForeground(Color.GREEN);
        LMRepeat.setForeground(Color.RED);
        LMConfirm.setPreferredSize(JButtonSize);
        LMRepeat.setPreferredSize(LongJButtonSize);
        LMConfirm.setBorder(RegularTextBorder);
        LMPrompt.setBorder(TitleBorder);
    }

    public LearningMode() {
        setup();
        LMFrame.setVisible(true);
		LMFrame.add(LMPrompt);
        Timer Timer = new Timer(800, this);
        Timer.start();
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
                LearningMode();
            }
        });
    }

    

    public void actionPerformed(ActionEvent e) {
        for (char i = 65; i <= 90; i++) {
			String temp = Character.toString(i);
			alphabet.add(new JButton(temp));
		}
    }
}
