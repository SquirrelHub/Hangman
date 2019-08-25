import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class HangmanDisplay extends Canvas{
    private JFrame j;
    private ArrayList<Character> wrongInputs;
    private HangmanLogic hLogic;
    private JTextField textField;
    private JLabel badText, goodText;
    private JLabel hang[];
    public HangmanDisplay(){
        this.hLogic = new HangmanLogic();
        j = new JFrame();
        Rectangle rect = new Rectangle();
        rect.setBounds(640, 360, 640, 360);
        j.setBounds(rect);
        j.setLayout(null);
        textField = new JTextField();
        textField.setBounds(210, 250, 212, 36);
        textField.setPreferredSize(new Dimension(300, 100));
        j.add(textField);
        j.setResizable(false);
        badText = new JLabel("Bad Letters");
        badText.setBounds(50, 150, 100, 100);
        goodText = new JLabel("Good Letters");
        goodText.setBounds(500, 150, 100, 100);
        j.add(badText);
        j.add(goodText);
        hang = new JLabel[10];
        hang[0] = new JLabel("___");
        hang[0].setBounds(200, 125, 100, 100);
        hang[1] = new JLabel("|");
        hang[1].setBounds(200, 100, 100, 100);
        hang[2] = new JLabel("|");
        hang[2].setBounds(200, 75, 100, 100);
        hang[3] = new JLabel("------------");
        hang[3].setBounds(200, 65, 100, 100);
        hang[4] = new JLabel("O");
        hang[4].setBounds(250, 75, 100, 100);
        hang[5] = new JLabel("|");
        hang[5].setBounds(250, 85, 100, 100);
        hang[6] = new JLabel("\\");
        hang[6].setBounds(245, 75, 100, 100);
        hang[7] = new JLabel("/");
        hang[7].setBounds(260, 75, 100, 100);
        hang[8] = new JLabel("/");
        hang[8].setBounds(245, 95, 100, 100);
        hang[9] = new JLabel("\\");
        hang[9].setBounds(255, 95, 100, 100);
        for (int i = 0; i < 10; i++){
            hang[i].setVisible(false);
            j.add(hang[i]);
        }
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
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    update();
                }
            }
        });
    }

    public void update(){

        if (textField.getText() == ""){
            JOptionPane.showMessageDialog(null, "Please enter a character to guess.");
        }
        else if (textField.getText().length() > 1 && textField.getText() != hLogic.getWord()) {
            JOptionPane.showMessageDialog(null,
                    "Unless you're guessing the word, please only use one letter.");
        }
        else{
            hLogic.guessChar(textField.getText().charAt(0));
            if (hLogic.isGameOver()){
                drawMan();
                if (hLogic.getGoodLetters().size() == hLogic.getWord().length()){
                    JOptionPane.showMessageDialog(null, "You Won");
                }
                else{
                    JOptionPane.showMessageDialog(null, "You Lost");
                }
                System.exit(0);
            }
        }
        badText.setText(hLogic.getBadLetters().toString().replace("[", "").replace("]", ""));
        goodText.setText(hLogic.getGoodLetters().toString().replace("[", "").replace("]", ""));
        textField.setText("");
        drawMan();
    }

    public void drawMan(){
        for (int i = 0; i < hLogic.getBadLetters().size(); i++){
            hang[i].setVisible(true);
        }
    }
}
