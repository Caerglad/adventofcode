import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StarSystem {
    private Map<String, Planet> planets;

    StarSystem() {
        this.planets = new HashMap<>();
    }

    public void addPlanet(String pattern) {
        String[] planetsNames = pattern.split("\\)");
        Arrays.stream(planetsNames)
                .forEach(p -> planets.putIfAbsent(p, new Planet()));
        planets.get(planetsNames[1]).parent = planets.get(planetsNames[0]);
    }

    public int getTotalOrbits() {
        return planets.values().stream()
                .mapToInt(p -> p.getOrbits())
                .sum();
    }
}
