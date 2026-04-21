package Model;

public abstract class Describer {

    private String name;

    public Describer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
