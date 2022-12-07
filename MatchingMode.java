import javax.swing.*;
import java.awt.FlowLayout;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*; //importing awt for customization
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
public class MatchingMode  {

    JFrame MMFrame = new JFrame();

    Random random = new Random();

    final static int alphabetsize = 26;
    final static int titlefont = 25;
    final static int bodyfont = 15;

	ArrayList<Integer> parent = new ArrayList<Integer>(alphabetsize);
	ArrayList<JButton> alphabet = new ArrayList<JButton>(alphabetsize);

	FlowLayout FrameLayout = new FlowLayout(FlowLayout.CENTER);
    FlowLayout LMFrameLayout = new FlowLayout(FlowLayout.CENTER); 

    Dimension JButtonSize = new Dimension (200, 100);
    Dimension LongJButtonSize = new Dimension (250, 100);
    Dimension MainPicture = new Dimension (300, 300);

    EmptyBorder TitleBorder = new EmptyBorder (50, 300, 50, 300);
    EmptyBorder RegularTextBorder = new EmptyBorder (15, 200, 15, 200);

    public void randomizealphabet() {
        MMFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 25)); 
		while (parent.size() > 0) {
			int index = random.nextInt(parent.size());
			MMFrame.add(alphabet.get(index));
			parent.remove(index);
		}
		if (parent.size() == 0) {
			initializeParent();
		}
	}

    public void initializeParent() {
		for (int i = 0; i < alphabetsize; i++) {
			parent.add(i);
		}
	}

    
    
}
