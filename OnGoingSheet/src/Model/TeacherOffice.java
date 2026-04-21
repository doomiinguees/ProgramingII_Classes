package Model;

import java.util.LinkedList;

public class TeacherOffice extends Division {
    private LinkedList<Teacher> teachers;

    public TeacherOffice(String name, boolean openDoor) {
        super(name, openDoor);
    }

    public LinkedList<Teacher> getTeachers() {
        return teachers;
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
