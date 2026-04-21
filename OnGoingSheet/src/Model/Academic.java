package Model;

import java.util.LinkedList;

public abstract class Academic extends Person {

    private LinkedList<Classe> classes;

    public Academic(String name, long number) {
        super(name, number);
        this.classes = new LinkedList<>();
    }

    public LinkedList<Classe> getClasses() {
        return classes;
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

    public void signSummary(Classe classe) {
        if (classe == null) {
            return;
        }

        classe.addSummaryLine(getName());
    }

    public void addClass(Classe classe) {
        if (classe == null || classes.contains(classe)) {
            return;
        }

        classes.add(classe);
        attributeClasse(classe);
    }

    public void removeClasse(Classe classe) {
        if (classe == null || !classes.remove(classe)) {
            return;
        }

        disableClasse(classe);
    }

    protected abstract void attributeClasse(Classe classe);

    public abstract void fillSummary(Classe classe);

    protected abstract void disableClasse(Classe classe);
}