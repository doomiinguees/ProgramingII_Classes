package Model;

import java.util.*;

public class Student {
    //region | Attributes
    String name;
    long number;
    List<String> classes;
    //endregion

    //region | Constructor
    public Student(String name, long number) {
        this.name = name;
        this.number = number;
        this.classes = new LinkedList<>();
    }
    //endregion

    //region | Methods
    public void fillSummary(Classe classe) {}

    public void signSummary(Classe classe) {}
    //endregion
}
