package Model;

import java.util.LinkedList;

public class TeacherOffice {
    private String name;
    private LinkedList<Teacher> teachers;
    private boolean openDoor;

    public TeacherOffice(String name, boolean openDoor) {
        this.name = name;
        this.openDoor = openDoor;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Teacher> getTeachers() {
        return teachers;
    }

    public boolean isOpenDoor() {
        return openDoor;
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

    public void addTeacher(Teacher teacher) {
        if (teacher == null || teachers.contains(teacher)) {
            return;
        }

        teachers.add(teacher);

        teacher.setOffice(this);

    }

    public void removeTeacher(Teacher teacher) {
        if (teacher == null || !teachers.contains(teacher)) {
            return;
        }

        teachers.remove(teacher);

        teacher.removeOffice();
    }
}
