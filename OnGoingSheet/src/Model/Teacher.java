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
    public void fillSummary(Classe classe) {
        if (classe == null || classe.getTeacher() != this) {
            return;
        }
        classe.registerClassInfo();
        signSummary(classe);
        giveToFill(classe);
    }

    public void signSummary(Classe classe) {
        classe.addSummaryLine(name);
    }

    public void giveToFill(Classe classe) {
        for (Student student : classe.getStudents()) {
            student.signSummary(classe);
        }
    }

    void addClass(Classe classe) {
        //pre-conditions
        if (classe == null || classes.contains(classe)) {
            return;
        }

        //actions
        classes.add(classe);

        //post-conditions
        classe.setTeacher(this);
    }

    public void removeClasse(Classe classe) {
        if (classe == null || !classes.contains(classe)) {
            return;
        }

        classes.remove(classe);


        classe.removeTeacher();
    }
    //endregion
}
