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
    public void goToCommand() {
        System.out.println(getLocations());
        int i = this.sc.nextInt();
        System.out.println(i);
        System.out.println(wm.getLocations()[i]);
        System.out.println(wm.goTo(wm.getLocations()[i]));
    }
}
