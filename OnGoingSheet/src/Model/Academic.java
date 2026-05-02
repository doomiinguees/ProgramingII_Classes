package Model;

import java.util.LinkedList;

public abstract class Academic extends Person implements ClassesRepo{

    private ClassesManager manager;

    public Academic(String name, long number) {
        super(name, number);
        manager = new ClassesManager(this);
    }

    public LinkedList<Classe> getClasses() {
        return manager.getClasses();
    }

    public LinkedList<Classe> getClasses(Schedule schedule) {
        return manager.getClasses();
    }

    public void signSummary(Classe classe) {
        if (classe == null) {
            return;
        }

        classe.addSummaryLine(getName());
    }

    public void addClasse(Classe classe) {
        manager.addClasse(classe);
    }

    public void removeClasse(Classe classe) {
        manager.removeClasse(classe);
    }

    public abstract void attributeClasse(Classe classe);

    public abstract void fillSummary(Classe classe);

    public abstract void disableClasse(Classe classe);
}