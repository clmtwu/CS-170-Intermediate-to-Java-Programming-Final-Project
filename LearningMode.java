import javax.swing.*;
import java.awt.event.*; //importing awt for customization
import java.util.Arrays;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class LearningMode extends Alphabet {
	
    JFrame LMFrame = new JFrame();//fields
    JFrame AlphabetPrint = new JFrame();//fields

    JButton LMConfirm = new JButton ("Return to Menu");

    JLabel LMPrompt = new JLabel ("Here is the alphabet in order from top to bottom!", SwingConstants.CENTER);
    private final JLabel lblNewLabel = new JLabel("");

    public void setup() {
        LMFrame.setSize(300, 500); 
        LMFrame.setTitle("Learning Mode - Control Panel!");
        LMFrame.getContentPane().setLayout(LMFrameLayout);//sets the layout
        LMFrame.setResizable(false);
        LMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

        AlphabetPrint.setSize(500, 1000); 
        AlphabetPrint.setTitle("Learning Mode - Alphabet!");
        AlphabetPrint.setResizable(false);
        AlphabetPrint.setLocationRelativeTo(null);
        AlphabetPrint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // default action when closed is to stop

        LMConfirm.setForeground(Color.GREEN);//sets text color

        LMPrompt.setBorder(TitleBorder);

        LMConfirm.setPreferredSize(StandardJButtonSize);

        Alphabet.setUpAlphabet();//launches the arraylist
    }//end of setup method
    public LearningMode() {
        setup();
        LMFrame.setVisible(true);
		LMFrame.getContentPane().add(LMPrompt, BorderLayout.CENTER);
        LMFrame.getContentPane().add(LMConfirm);
        lblNewLabel.setIcon(new ImageIcon(LearningMode.class.getResource("/images/Learning.jpeg")));//sets up an image
        
        LMFrame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
        printAlphabetinOrder();
        LMConfirm.addActionListener((java.awt.event.ActionListener) new ActionListener() { //creating action listener for submit button
            public void actionPerformed(ActionEvent e){ //method of execution
                AlphabetPrint.setVisible(false);
                AlphabetPrint.dispose();
                LMFrame.setVisible(false); //you can't see me!
                LMFrame.dispose(); //Destroy the JFrame object
                Arrays.fill(reference, null);
                Arrays.fill(answer, null);
                checkanswer.clear();//clears arraylist
                alphabet.clear();//clears arraylist
                sound.stop();//stops current music
                new Frame();//starts up main menu
            }
        });
    }

    public void printAlphabetinOrder() {
        AlphabetPrint.getContentPane().setLayout(new GridLayout(alphabet.size(), 1)); //calls the arraylist
        for (int i = 0; i < alphabet.size(); i++) {//prints the arraylist out in order
            AlphabetPrint.getContentPane().add(alphabet.get(i), BorderLayout.CENTER);
        }
        AlphabetPrint.setVisible(true);
    }//end of printAlphabetOrder.

    public static void main(String[] args) {
        new LearningMode();
    }
}
