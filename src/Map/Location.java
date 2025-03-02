package Map;

public class Location {
    private String name;
    private int[] goToLocations;
    private String description;
    private int id;

    public String getName() {
        return name;
    }

    public int[] getGoToLocations() {
        return goToLocations;
    }

    public int getId() {
        return id;
    }

    public Location(int id, String name, int[] goToLocations, String description) {
        this.name = name;
        this.id = id;
        this.goToLocations = goToLocations;
        this.description = description;
    }
}
