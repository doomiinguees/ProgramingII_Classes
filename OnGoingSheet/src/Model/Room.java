package Model;

import java.util.LinkedList;

public class Room extends Division implements ClassesRepo {

    private ClassesManager manager;

    public Room(String name, boolean openDoor) {
        super(name, openDoor);
        manager = new ClassesManager(this);
    }

    @Override
    public LinkedList<Classe> getClasses() {
        return manager.getClasses();
    }

    @Override
    public LinkedList<Classe> getClasses(Schedule schedule) {
        return manager.getClasses(schedule);
    }

    @Override
    public void addClasse(Classe classe) {
        manager.addClasse(classe);
    }

    public void attributeClasse(Classe classe) {
        classe.setRoom(this);
    }

    @Override
    public void removeClasse(Classe classe){
        manager.removeClasse(classe);
    }

    public void disableClasse(Classe classe){
        classe.removeRoom();
    }
}
