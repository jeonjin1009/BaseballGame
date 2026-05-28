public class Game {
    public void guess(Object guessnumber) {
        if (guessnumber == null) {
            throw new IllegalArgumentException();
        }
    }
}
