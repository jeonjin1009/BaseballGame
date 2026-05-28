public class Game {
    public void guess(String guessnumber) {
        if (guessnumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessnumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for(char number : guessnumber.toCharArray()) {
            if(number <0 || number > 9) {
                throw new IllegalArgumentException();
            }
        }
    }
}
