package Model;

import java.util.*;

public class Student {
    //region | Attributes
    private String name;
    private long number;
    private LinkedList<Classe> classes;
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
    public void fillSummary(Classe classe) {
        if (classe == null) {
            return;
        }

        signSummary(classe);
    }

    public void signSummary(Classe classe) {
        classe.addSummaryLine(name);
    }

    public void addClass(Classe classe) {
        if(classe == null || classes.contains(classe)) {
            return;
        }

        classes.add(classe);

        classe.addStudent(this);
    }

    public void removeClasse(Classe classe) {
        if (classe == null || !classes.contains(classe)) {
            return;
        }

        Classe aux = classe;
        classes.remove(classe);

        aux.removeStudent(this);
    }
    //endregion
}
