package Model;

import java.util.LinkedList;

public class ClassesManager {

    protected LinkedList<Classe> classes;

    private ClassesRepo owner;

    public ClassesManager(ClassesRepo owner) {
        this.classes = new LinkedList<>();
        this.owner = owner;
    }

    public LinkedList<Classe> getClasses() {
        return new LinkedList<>(classes);
    }

    public LinkedList<Classe> getClasses(Schedule schedule) {
        LinkedList<Classe> result = new LinkedList<>();

        if (schedule == null) {
            return result;
        }

        for (Classe classe : classes) {
            if (classe.getSchedule().intersect(schedule)) {
                result.add(classe);
            }
        }

        return result;
    }

    public void addClasse(Classe classe) {
        if (classe == null || classes.contains(classe)){
            return;
        }

        classes.add(classe);

        owner.attributeClasse(classe);
    }

    public void removeClasse(Classe classe){
        if (classe == null || !classes.contains(classe)) {
            return;
        }

        classes.remove(classe);

        owner.disableClasse(classe);
    }
}
