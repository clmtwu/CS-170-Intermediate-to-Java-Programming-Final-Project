import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;
 
//can use icons in the button creations
public class imgoinginsane extends JFrame implements  ActionListener{
 
    JButton START;
    JButton EXIT;
    JLabel WELCOME;
 
    imgoinginsane() {
        setTitle("Alphabet Game");
        JPanel masterpanel = new JPanel(new GridBagLayout());
        JPanel lables = new JPanel();
        JPanel Buttons = new JPanel();
 
        Buttons.setLayout(new GridBagLayout());
 
        lables.setLayout(new GridLayout(3,3,20,25));
        lables.setSize(3000,3000);
 
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints master = new GridBagConstraints();
 
 
        WELCOME = new JLabel("WELCOME TO ALPHABET GAME!");
        WELCOME.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        lables.add(WELCOME);
 
        lables.setLayout(new GridLayout(3, 3, 20, 25));
        lables.setSize(100, 20);
        lables.setVisible(true);
 
        c.insets = new Insets(2, 2, 2, 2);
 
        // column 0
        c.gridx = 0;
 
        c.gridy = 0;
 
        // increases components width by 10 pixels
        c.ipadx = 500;
 
        // increases components height by 50 pixels
        c.ipady = 100;
 
        START = new JButton("START");
 
 
        Buttons.add(START,c);
        START.addActionListener(this);
 
        // column 1
        c.gridx = 3;
 
        c.ipadx = 500;
 
        c.ipady = 100;
 
        // constraints passed in
        Buttons.add(new JButton("RESULTS"), c);
 
        // column 0
        c.gridx = 0;
 
        // row 2
        c.gridy = 1;
 
        // increases components width by 20 pixels
        c.ipadx = 500;
 
        // increases components height by 20 pixels
        c.ipady = 100;
 
        // constraints passed in
        Buttons.add(new JButton ("SCORES"), c);
 
 
        // increases components width by 500
        c.ipadx = 550;
 
        // column 1
        c.gridx = 3;
 
        // constraints passed in
       EXIT = new JButton("EXIT");
       Buttons.add(EXIT, c);
       EXIT.addActionListener(this);
 
 
 
 
        master.gridx = 1;
        master.gridy = 6;  //buttons
        masterpanel.add (Buttons, master);
 
        master.gridx = 1;
        master.gridy = 0;  //Label
        masterpanel.add (lables,master);
 
 
 
        ImageIcon background=new ImageIcon("cock.jpg");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(500,400,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,500,600);
 
        masterpanel.add(back);
 
        add(masterpanel, BorderLayout.CENTER);
        getContentPane().add(masterpanel);
 
        setSize(3000, 1500);
 
        // Function to set visibility of JFrame.
        setVisible(true);
 
    }
 
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == START) {
            System.out.println("Cock Button Successful");
 
        }
        if (evt.getSource() == EXIT) {
            System.exit(0);
        }
    }
 
    public static void main(String[] args)
    {
 
        new imgoinginsane();
    }
 
 
 
}