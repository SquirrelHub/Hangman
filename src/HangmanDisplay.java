import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class HangmanDisplay extends Canvas{
    protected JFrame j;
    private ArrayList<Character> wrongInputs;
    private HangmanLogic hLogic;
    private String placeholderWord="";
    private String[] man = {"  0","\n  /","|","\\","\n_", "/", " \\", "_"};
    private String figure = "", wrongVals ="";
    private int index = 0;

    public HangmanDisplay(){
        this.hLogic = new HangmanLogic();
        j = new JFrame();
        Rectangle rect = new Rectangle();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        rect.setBounds((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2, (int)screenSize.getWidth()/4, (int)screenSize.getHeight()/4);
        j.setBounds(rect);
        j.setLayout(null);

    }

    // Get input from user
    public char getCharInput(){
        char input = (JOptionPane.showInputDialog("Please guess a letter:")).charAt(0);
        return input;
    }

    public void displayHangman(){
        j.setVisible(true);
        j.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void displayWrongInputs(String word){}

    public void displayCorrectInputs(String word){
    }

    public void letterAlreadyGuessed(){
    }
}
