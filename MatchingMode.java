import javax.swing.*;
import java.awt.FlowLayout;
import java.util.Random;
public class MatchingMode extends Frame {

    JFrame MMFrame = new JFrame();

    Random random = new Random();

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
