import java.util.ArrayList;
import java.util.List;

public class HangmanLogic {
    String word = "test";
    List<String> badLetters = new ArrayList<>();
    List<String> goodLetters = new ArrayList<>();

    boolean isGameOver(){
        return buildAnswer().equals(word) || badLetters.size() == 10 ? true : false;
    }

    void guessChar (Character c){
        if (badLetters.contains(c.toString()) || goodLetters.contains(c.toString())){
            return;
        }
        for(Character letter : word.toCharArray()){
            if (letter == c){
                goodLetters.add(c.toString());
                return;
            }
        }
        badLetters.add(c.toString());
    }

    public String getWord() {
        return word;
    }

    public List<String> getBadLetters() {
        return badLetters;
    }

    public List<String> getGoodLetters() {
        return goodLetters;
    }

    public String buildAnswer(){
        String answer = "_".repeat(word.length());
        for (int i = 0; i < word.length(); i++){
            if (goodLetters.contains(Character.toString(word.charAt(i)))){
                StringBuilder str = new StringBuilder(answer);
                str.setCharAt(i, word.charAt(i));
                answer = str.toString();
            }
        }
        return answer;
    }
}
