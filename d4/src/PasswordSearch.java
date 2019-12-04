
public class PasswordSearch {
    private static final int MIN_VALUE = 372037;
    private static final int MAX_VALUE = 905157;


    public int getCombinations() {
        int combinations = 0;
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            String password = Integer.toString(i);
            if (checkDuplicates(password) && checkOrder(password)) {
                combinations++;
                System.out.println(password);
            }

        }
        return combinations;
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
