package Model;

import java.util.LinkedList;

public class Room extends Division implements ClassesManager {
    private LinkedList<Classe> classes;

    public Room(String name, boolean openDoor) {
        super(name, openDoor);
    }

    @Override
    public LinkedList<Classe> getClasses() {
        return new LinkedList<>(classes);
    }

    @Override
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

    @Override
    public void addClasse(Classe classe) {
        if (classe == null || classes.contains(classe)){
            return;
        }

        classes.add(classe);

        classe.setRoom(this);
    }

    @Override
    public void removeClasse(Classe classe){
        if (classe == null || !classes.contains(classe)) {
            return;
        }

        classes.remove(classe);

        classe.removeRoom();
    }
}
