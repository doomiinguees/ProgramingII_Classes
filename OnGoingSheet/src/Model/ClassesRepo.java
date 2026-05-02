package Model;

import java.util.LinkedList;

public interface ClassesRepo {
    LinkedList<Classe> getClasses();

    LinkedList<Classe> getClasses(Schedule schedule);

    void addClasse(Classe classe);

    void removeClasse(Classe classe);

    void attributeClasse(Classe classe);

    void disableClasse(Classe classe);
}
