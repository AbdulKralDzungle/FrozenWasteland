package Efects;

public class Bleeding extends Efect {
    @Override
    public boolean apply() {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }

    @Override
    public String description() {
        return "Bleeding#Description";
    }
}
