public class Game {
    public String question;

    public GameResult guess(String guessnumber) {
        int strike;
        int ball;

        checkInvalidGuessNumber(guessnumber);
        if (guessnumber.equals(question)) {
            return new GameResult(true, 3, 0);
        } else {
            strike = 0;
            ball = 0;
            for(int j = 0; j < guessnumber.length(); j++) {
                char Gnumber = guessnumber.charAt(j);
                for(int i = 0; i < question.length(); i++) {
                    char Qnumber = question.charAt(i);
                    if(i==j && Qnumber == Gnumber) {
                        strike ++;
                    }else if (Qnumber == Gnumber) {
                        ball++;
                    }
                }
            }
            return new GameResult(false, strike, ball);
        }
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
