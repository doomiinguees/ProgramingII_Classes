package Model;

import java.util.LinkedList;
import java.util.List;

public class Teacher {
    //region | Attributes
    String name;
    long number;
    List<Classe> classes;
    //endregion

    //region | Constructor
    public Teacher(String name, long number) {
        this.name = name;
        this.number = number;
        this.classes = new LinkedList<>();
    }
    //endregion

    //region | Methods
    public void fillSummary(Classe classe) {}

    public void registSummary(Classe classe) {}

    public void signSummary(Classe classe) {}

    public void giveToFill(Classe classe) {}
    //endregion
}
