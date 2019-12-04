import java.util.stream.IntStream;

public class PasswordSearch {
    private static final int MIN_VALUE = 372037;
    private static final int MAX_VALUE = 905157;


    public long getCombinations() {
        return IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
                .boxed()
                .filter(this::checkPassword)
                .count();
    }

    private boolean checkPassword(int password) {
        String pass = Integer.toString(password);
        return checkOrder(pass) && checkDuplicates(pass);
    }

    private boolean checkOrder(String password) {
        for (int i = 1; i < 6; i++) {
            if (password.charAt(i-1) > password.charAt(i)) return false;
        }
        return true;
    }

    private boolean checkDuplicates(String password) {
        int count = 1;
        for (int i = 1; i < 6; i++) {
            if (password.charAt(i-1) == password.charAt(i)) {
                count++;
            } else if (count == 2) return true;
            else count = 1;
        }
        return count == 2;
    }

}
