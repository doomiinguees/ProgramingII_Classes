package Model;

import java.util.LinkedList;

public class Room {
    private String name;
    private LinkedList<Classe> classes;
    private boolean openDoor;

    public Room(String name, boolean openDoor) {
        this.name = name;
        this.openDoor = openDoor;
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

    public boolean isOpenDoor() {
        return openDoor;
    }

    public String getName() {
        return name;
    }

    public void openDoor(){
        if (isOpenDoor()) {
            return;
        }

        this.openDoor = true;
    }

    public void closeDoor() {
        if (isOpenDoor()) {
            return;
        }

        this.openDoor = true;
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
