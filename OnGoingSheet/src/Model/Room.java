package Model;

import java.util.LinkedList;

public class Room extends Division {
    private LinkedList<Classe> classes;

    public Room(String name, boolean openDoor) {
        super(name, openDoor);
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

        classe.setRoom(this);
    }

    public void removeClasse(Classe classe){
        if (classe == null || !classes.contains(classe)) {
            return;
        }

        classes.remove(classe);

        classe.removeRoom();
    }
}
