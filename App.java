import java.io.IOException;

public class App {
    static Integer[] reference = new Integer[26];
    public static void main(String[] args) throws IOException {
        new Scores();
        new Scores("Clement", "Matching Mode", 4);
        new Scores("Clement", "Matching Mode", 3);
        new Scores("Clement", "Matching Mode", 5);
        new Scores("Clement", "Matching Mode", 8);
        new Scores("Clement", "Matching Mode", 27);
        new Scores("Clement", "Matching Mode", 2);
        //new Scores("Clement", "Matching Mode", 2);
       
    }
}
