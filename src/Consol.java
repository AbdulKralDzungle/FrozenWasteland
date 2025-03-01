import java.util.Scanner;

public class Consol {
    WorldMap wm;
    Scanner sc;

    public Consol() {
        this.wm = new WorldMap();
        this.sc = new Scanner(System.in);
    }

    private String getLocations() {
        String s = "";
        String[] names = wm.getLocNames();
        for (int i = 0; i < names.length; i++) {
            s = s + "\n" + i + " " + names[i];
        }
        return s;
    }


    //testovaci metoda
    //bude potom zahrnuta v command navrhovem vzoru
    public void goToCommand() {
        System.out.println("current location ->" + wm.getCurrentLoc());
        System.out.println(getLocations());
        System.out.print(">");
        int i = this.sc.nextInt();
        int[] locs = wm.getLocations();
        if (i < locs.length) {
            wm.goTo(locs[i]);
        } else {
            System.out.println("nedostupna lokace");
        }
    }
}
