package Model;

import java.util.LinkedList;
import java.util.List;

public class Teacher {
    //region | Attributes
    private String name;
    private long number;
    List<Classe> classes;
    //endregion

    //region | Constructor
    public Teacher(String name, long number) {
        this.name = name;
        this.number = number;
        this.classes = new LinkedList<>();
    }
    //endregion

    //region | Getter & Setter

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    //endregion

    //region | Methods
    public void fillSummary(Classe classe) {}

    public void registSummary(Classe classe) {}

    public void signSummary(Classe classe) {}

    public void giveToFill(Classe classe) {}

    void addClass(Classe classe) {}

    void removeClasse(Classe classe) {}
    //endregion
}
