import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    @Test
    void createGame() {
        Game game = new Game();
        assertNotNull(game);
    }

    @Test
    void throwExceptioninputNull() {
        Game game = new Game();
        assertThrows(IllegalArgumentException.class, () -> {
            game.guess(null);
        });

    }
}