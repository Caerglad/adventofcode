import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input");
        Scanner sc = new Scanner(file);

        int sum = 0;
        while (sc.hasNext()) {
            sum += addModule(sc.nextInt());
        }
        System.out.println(sum);
    }

    private static int addModule(int value) {
        int cost = 0;
        for (int i = calculateFuelCost(value); i > 0;) {
            cost += i;
            i = calculateFuelCost(i);
        }
        return cost;
    }

    private static int calculateFuelCost(int value) {
        return value / 3 - 2;
    }
}
