import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[][] map;
    public static int[][] costMap;
    public static final int SIZE = 20000;

    public static void main(String[] args) throws FileNotFoundException{
        init();
        List<CrossPoint> crossPoints = getCrossPoints();
        Collections.sort(crossPoints);
        for (int i = 0; i < 10; i++)
        System.out.println(crossPoints.get(i).getDistance());
    }

    public static void init() throws FileNotFoundException {
        String[] redWire, blueWire;
        File file = new File("src/in");
        Scanner sc = new Scanner(file);
        redWire = sc.nextLine().split(",");
        blueWire = sc.nextLine().split(",");

        map = new int[SIZE][SIZE];
        costMap = new int[SIZE][SIZE];
        drawWires(redWire);
        drawWires(blueWire);
    }

    private static void drawWires(String[] wire) {
        int y = (SIZE / 2);
        int x = (SIZE / 2);
        int cost = 0;
        for (String move : wire) {
            int[] direction = getDirection(move.substring(0, 1));
            int speed = Integer.parseInt(move.substring(1));

            for (int i = 0; i < speed; i++) {
                x += direction[0];
                y += direction[1];
                map[x][y]++;
                costMap[x][y] += ++cost;
            }
        }
    }

    private static int[] getDirection(String symbol) {
        switch (symbol) {
            case "U":
                return new int[]{0, 1};
            case "D":
                return new int[]{0, -1};
            case "R":
                return new int[]{1, 0};
            case "L":
                return new int[]{-1, 0};
        }
        return new int[]{0, 0};
    }

    private static List<CrossPoint> getCrossPoints() {
        List<CrossPoint> crossPoint = new ArrayList<>();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (map[x][y] > 1) {
                    crossPoint.add(new CrossPoint(costMap[x][y]));
                }
            }
        }
        return crossPoint;
    }
}
