package Model;

import java.util.LinkedList;

public class Student extends Person{
    //region | Attributes
    private LinkedList<Classe> classes;
    //endregion

    //region | Constructor
    public Student(String name, long number) {
        super(name, number);
        this.classes = new LinkedList<>();
    }
    //endregion

    //region | Getters & Setter
    public LinkedList<Classe> getClasses (Schedule schedule) {
        LinkedList<Classe> result = new LinkedList<>();

        for (Classe classe : classes) {
            if(classe.getSchedule().intersect(schedule)) {
                result.add(classe);
            }
        }

        return result;
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
        classe.addSummaryLine(getName());
    }

    public void addClass(Classe classe) {
        if(classe == null || classes.contains(classe)) {
            return;
        }

        classes.add(classe);

        classe.addStudent(this);
    }

    public void removeClasse(Classe classe) {
        if (!classes.remove(classe)) {
            return;
        }

        classe.removeStudent(this);
    }
    //endregion
}
