package Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WorldMap {
    private HashMap<Integer, Location> world = new HashMap<>();
    private Location currentLoc;

    public WorldMap() {
        initialize();
    }

    public String getCurrentName() {
        return currentLoc.getName();
    }

    public int getCurrentId() {
        return currentLoc.getId();
    }

    public Location getCurrentLoc() {
        return currentLoc;
    }

    public void initialize() {
        loadLocations();
        currentLoc = world.get(1);
    }

    /**
     * loops through all lines of corresponding file
     * creates locations based on info located on corresponding line in the file
     * Makes
     */
    public void loadLocations() {
        try (BufferedReader br = new BufferedReader(new FileReader("Resources/MapFile"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                Location location = new Location(
                        Integer.parseInt(lines[0]),
                        lines[1],
                        unpackGoToLocations(lines[2])
                );
                world.put(Integer.valueOf(lines[0]), location);
            }
        } catch (IOException E) {
        }
    }

    private int[] unpackGoToLocations(String goToLocations) {
        String[] locations = goToLocations.split("#");
        int[] unpackedLocations = new int[locations.length];
        for (int i = 0; i < locations.length; i++) {
            unpackedLocations[i] = Integer.parseInt(locations[i]);
        }
        return unpackedLocations;
    }

    public boolean goTo(int location) {
        if (world.containsKey(location)) {
            if (containsLocation(currentLoc, location)) {
                currentLoc = world.get(location);
                return true;
            }
        }
        return false;
    }


    private boolean containsLocation(Location loc, int index) {
        for (int i : loc.getGoToLocations()) {
            if (index == i) {
                return true;
            }
        }
        return false;
    }

    public int[] getLocations() {
        return this.currentLoc.getGoToLocations();
    }

    public String[] getLocNames() {
        int[] locs = getLocations();
        String[] s = new String[locs.length];
        for (int i = 0; i < locs.length; i++) {
            s[i] = world.get(locs[i]).getName();
        }
        return s;
    }

    public void update() {
        world.forEach((key, location) -> {
            location.update();
        });
    }
}
