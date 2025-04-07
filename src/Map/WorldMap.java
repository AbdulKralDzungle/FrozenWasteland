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

    /**
     * Used to extract info about locations that is parsable to move to from String
     *
     * @param goToLocations String loaded from file by loadLocations method
     * @return array of ids
     */
    private int[] unpackGoToLocations(String goToLocations) {
        String[] locations = goToLocations.split("#");
        int[] unpackedLocations = new int[locations.length];
        for (int i = 0; i < locations.length; i++) {
            unpackedLocations[i] = Integer.parseInt(locations[i]);
        }
        return unpackedLocations;
    }

    /**
     * called when player requests to move to different location
     * if the requested location is valid, new location is loaded into currentLoc variable
     *
     * @param location id of location that was requested to move to
     * @return weather or not the go request was valid
     */
    public boolean goTo(int location) {
        if (world.containsKey(location)) {
            if (containsLocation(currentLoc, location)) {
                currentLoc = world.get(location);
                return true;
            }
        }
        return false;
    }


    /**
     * simple loop that checks if id of location is part of locations that player have the possibility to go to
     *
     * @param loc   Location object that contains the necessary information
     * @param index is id of locations player requested as his destination
     * @return true if the requested location is reachable
     */
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

    /**
     * @return array of Strings that contains names of locations
     */
    public String[] getLocNames() {
        int[] locs = getLocations();
        String[] s = new String[locs.length];
        for (int i = 0; i < locs.length; i++) {
            s[i] = world.get(locs[i]).getName();
        }
        return s;
    }

    /**
     * loops through all locations that are contained in the world hash map
     */
    public void update() {
        world.forEach((key, location) -> {
            location.update();
        });
    }
}
