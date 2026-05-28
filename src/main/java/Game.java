public class Game {
    public String question;

    public GameResult guess(String guessnumber) {
        checkInvalidGuessNumber(guessnumber);
        if (guessnumber.equals(question)) {
            return new GameResult(true, 3, 0);
        }

        int strike = 0;
        int ball = 0;

        for (int gussIndex = 0; gussIndex < guessnumber.length(); gussIndex++) {
            char guess = guessnumber.charAt(gussIndex);
            for (int questionIndex = 0; questionIndex < question.length(); questionIndex++) {
                char answer = question.charAt(questionIndex);

                boolean sameNumber = guess == answer;
                boolean samePosition = gussIndex == questionIndex;

                if (sameNumber && samePosition) {
                    strike++;
                } else if (sameNumber) {
                    ball++;
                }
            }
        }
        return new GameResult(false, strike, ball);

    }

    private static void checkInvalidGuessNumber(String guessnumber) {
        if (guessnumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessnumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char number : guessnumber.toCharArray()) {
            if (number < '0' || number > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (guessnumber.charAt(0) == guessnumber.charAt(1) ||
                guessnumber.charAt(0) == guessnumber.charAt(2) ||
                guessnumber.charAt(1) == guessnumber.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }
}
