import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input");
        Scanner sc = new Scanner(file);
        StarSystem starSystem = new StarSystem();
        while(sc.hasNext()) {
            starSystem.addPlanet(sc.next());
        }
        System.out.println(starSystem.getTotalOrbits());
    }
}
