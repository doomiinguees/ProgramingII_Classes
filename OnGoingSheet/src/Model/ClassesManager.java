package Model;

import java.util.LinkedList;

public interface ClassesManager {
    LinkedList<Classe> getClasses();

    LinkedList<Classe> getClasses(Schedule schedule);

    void addClasse(Classe classe);

    void removeClasse(Classe classe);

    default void sayHello(){
        System.out.println("Holle");
    }
}
