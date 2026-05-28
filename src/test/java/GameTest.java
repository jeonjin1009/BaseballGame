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

    }


    private void checkGuessNumber(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        }catch (IllegalArgumentException e) {

        }
    }
}