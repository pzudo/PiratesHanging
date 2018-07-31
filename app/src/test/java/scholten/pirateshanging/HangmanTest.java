package scholten.pirateshanging;

import org.junit.Test;

import scholten.pirateshanging.hangman.Gamelogic;

public class HangmanTest {

    @Test
    public void integrationUnitTest(){
        Gamelogic test = new Gamelogic();

        test.reset();
        test.status();

        String word = test.getWord();

        while (!test.isWon()){
            for (int i = 0; i < word.length(); i++) {
                String letter = word.substring(i, i + 1);
                test.check(letter);
            }
        }

        test.status();

    }

}
