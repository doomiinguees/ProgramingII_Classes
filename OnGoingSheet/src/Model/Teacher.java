package Model;

import java.util.LinkedList;
import java.util.List;

public class Teacher extends Person {
    //region | Attributes
    List<Classe> classes;
    //endregion

    //region | Constructor
    public Teacher(String name, long number) {
        super(name, number);
        this.classes = new LinkedList<>();
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
        classe.addSummaryLine(getName());
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
