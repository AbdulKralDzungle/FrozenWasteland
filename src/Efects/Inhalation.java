package Efects;

public class Inhalation extends Efect {
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
        return "Inhalation#Description";
    }
}
