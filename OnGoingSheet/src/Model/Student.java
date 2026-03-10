package Model;

import java.util.*;

public class Student {
    //region | Attributes
    private String name;
    private long number;
    private List<String> classes;
    //endregion

    //region | Constructor
    public Student(String name, long number) {
        this.name = name;
        this.number = number;
        this.classes = new LinkedList<>();
    }
    //endregion

    //region | Getters & Setter

    public String getName() {
        return name;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    //endregion

    //region | Methods
    public void fillSummary(Classe classe) {}

    public void signSummary(Classe classe) {}

    void addClass(Classe classe) {}

    void removeClasse(Classe classe) {}
    //endregion
}
