package scholten.pirateshanging.hangman;

import java.util.ArrayList;
import java.util.Random;

public class Gamelogic {
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<String> usedLetters = new ArrayList<String>();
    private String word;
    private String visible;
    private int wrongs;
    private long time;
    private boolean correct;
    private boolean won;
    private boolean lost;
    private boolean gameover;

    public Gamelogic() {
        words.add("Blackbeard");
        words.add("Kraken");
        reset();
    }

    public void reset() {
        usedLetters.clear();
        setWrongs(0);
        setWon(false);
        setLost(false);
        setWord(words.get(new Random().nextInt(words.size())));
        updateVisible();
    }

    public void updateVisible(){
        setVisible("");
        setWon(true);

        for (int i = 0; i < word.length(); i++){
            String letter = word.substring(i, i + 1);

            if (usedLetters.contains(letter)){
                setVisible(visible + letter);
            }
            else {
                setVisible(visible + "*");
                setWon(false);
            }

        }
    }

    public void check(String letter){
        if (letter.length() != 1) {
            return;
        }

        System.out.println("guessing: " + letter);

        if (usedLetters.contains(letter)) {
            return;
        }
        if (gameover) {
            return;
        }

        usedLetters.add(letter);

        if (word.contains(letter)) {
            setCorrect(true);
            System.out.println(letter + " was correct");
        }
        else {
            setCorrect(false);
            System.out.println(letter + " was incorrect");
            setWrongs(wrongs + 1);

            if (wrongs > 5) {
                setLost(true);
                System.out.println("game lost");
            }

        }

        updateVisible();
    }

    public void status(){
        System.out.println("<-- status -->");

        if (lost) {
            System.out.println("Lost");
        }
        if (won) {
            System.out.println("Won");
        }

        System.out.println("[status] word -> " + word);
        System.out.println("[status] visible -> " + visible);
        System.out.println("[status] wrongs -> " + wrongs);
        System.out.println("[status] used letter -> " + usedLetters);

        System.out.println("<-- status -->");
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public ArrayList<String> getUsedLetters() {
        return usedLetters;
    }

    public void setUsedLetters(ArrayList<String> usedLetters) {
        this.usedLetters = usedLetters;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public int getWrongs() {
        return wrongs;
    }

    public void setWrongs(int wrongs) {
        this.wrongs = wrongs;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public boolean isGameover() {
        return lost||won;
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }





}
