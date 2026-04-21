package Model;

public class Identifier extends Describer{

    private long number;

    public Identifier(String name, long number) {
        super(name);
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
