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
    private boolean isCorrect;
    private boolean isWon;
    private boolean isLost;

    public Gamelogic() {
        words.add("Blackbeard");
        words.add("Kraken");
        words.add("Jack Sparrow");
        reset();
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
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    public boolean isLost() {
        return isLost;
    }

    public void setLost(boolean lost) {
        isLost = lost;
    }

    public void reset() {
        usedLetters.clear();
        setWrongs(0);
        setWon(false);
        setLost(false);
        setWord(words.get(new Random().nextInt(words.size())));
        updateVisible();
        setTime(System.currentTimeMillis());
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
        if (isWon || isLost) {
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
        long currentTime = (time - System.currentTimeMillis()/10);

        System.out.println("<-- status -->");

        if (isLost) {
            System.out.println("Lost");
            System.out.println("[status] time -> " + currentTime);
        }
        if (isWon) {
            System.out.println("Won");
            System.out.println("[status] time ->" + currentTime);
        }

        System.out.println("[status] word -> " + word);
        System.out.println("[status] visible -> " + visible);
        System.out.println("[status] wrongs -> " + wrongs);
        System.out.println("[status] used letter -> " + usedLetters);

        System.out.println("<-- status -->");


    }



}
