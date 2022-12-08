import java.util.Arrays;
import java.util.Collections;

public class App {
    static Integer[] reference = new Integer[26];
    public static void main(String[] args) {
        //new Frame();
        for (int i = 0; i < reference.length; i++) {
            reference[i] = i;
        }
        Collections.shuffle(Arrays.asList(reference));
        for (int i = 0; i < reference.length; i++) {
            System.out.println(reference[i].toString());
        }
    }
}
