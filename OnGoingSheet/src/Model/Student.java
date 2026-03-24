package Model;

import java.util.LinkedList;

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
        if (!classes.remove(classe)) {
            return;
        }

        classe.removeStudent(this);
    }
    //endregion
}
