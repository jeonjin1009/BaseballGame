import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;
    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    @Test
    void throwExceptioninputInvalid() {
        checkGuessNumber(null);
        checkGuessNumber("12");
        checkGuessNumber("1234");
        checkGuessNumber("12s");
        checkGuessNumber("112");

    }


    private void checkGuessNumber(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        }catch (IllegalArgumentException e) {

        }
    }

    @Test
    void correctAllNumber() {
        questionGenerator("123");
        GameResult result = game.guess("123");

        matchingNumber(result, true, 3, 0);
    }

    private void questionGenerator(String question) {
        game.question = question;
    }

    private static void matchingNumber(GameResult result, boolean solved, int strike, int ball) {
        Assertions.assertThat(result.solved).isEqualTo(solved);
        Assertions.assertThat(result.strike).isEqualTo(strike);
        Assertions.assertThat(result.ball).isEqualTo(ball);
    }

    @Test
    void notCorrectAllNumber() {
        questionGenerator("123");
        GameResult result = game.guess("456");

        matchingNumber(result, false, 0, 0);
    }

    @Test
    void Sike2Ball0() {
        questionGenerator("123");
        GameResult result = game.guess("173");

        matchingNumber(result, false, 2, 0);
    }

    @Test
    void Sike1Ball1() {
        questionGenerator("123");
        GameResult result = game.guess("137");

        matchingNumber(result, false, 1, 1);
    }
    @Test
    void Sike1Ball2() {
        questionGenerator("123");
        GameResult result = game.guess("132");

        matchingNumber(result, false, 1, 2);
    }

    @Test
    void Sike0Ball3() {
        questionGenerator("123");
        GameResult result = game.guess("231");

        matchingNumber(result, false, 0, 3);
    }
}