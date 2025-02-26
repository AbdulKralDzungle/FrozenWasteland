import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WorldMap {
    private HashMap<Integer, Location> world = new HashMap<>();

    public Boolean loadLocations() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/DataFiles/MapFile"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                Location location = new Location(
                        lines[2],
                        unpackGoToLocations(lines[3]),
                        "sss"
                );
                world.put(Integer.valueOf(lines[0]), location);
            }
            return true;
        } catch (IOException E) {
            return false;
        }
    }

    private int[] unpackGoToLocations(String goToLocations) {
        String[] locations = goToLocations.split(";");
        int[] unpackedLocations = new int[locations.length];
        for (int i = 0; i < locations.length; i++) {
            unpackedLocations[i] = Integer.parseInt(locations[i]);
        }
        return unpackedLocations;
    }
}
