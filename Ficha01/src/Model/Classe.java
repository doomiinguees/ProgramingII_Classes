package Model;

import java.util.LinkedList;

public class Classe {
    //region | Attributes
    String name;
    long number;
    String summary;
    Teacher teacher;
    LinkedList<Student> students;
    //endregion

    //region | Constructor
    public Classe(long number, String name, Teacher teacher) {
        this.number = number;
        this.name = name;
        this.teacher = teacher;
    }
    //endregion


    //region | Methods
    public void addSummaryLine(String line) {}
    //endregion
}
