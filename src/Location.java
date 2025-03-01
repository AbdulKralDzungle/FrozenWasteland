public class Location {
    private String name;
    private int[] goToLocations;
    private String description;

    public int[] getGoToLocations() {
        return goToLocations;
    }

    public Location(String name, int[] goToLocations, String description) {
        this.name = name;
        this.goToLocations = goToLocations;
        this.description = description;
    }
}
