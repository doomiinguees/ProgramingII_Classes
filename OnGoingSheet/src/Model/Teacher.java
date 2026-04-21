package Model;

import java.util.LinkedList;

public class Teacher extends Academic {

    public TeacherOffice teacherOffice;
    private LinkedList<Schedule> openingHours;
    public Teacher(String name, long number, TeacherOffice teacherOffice) {
        super(name, number);
        if (teacherOffice != null) {
            setOffice(teacherOffice);
        }
    }

    public TeacherOffice getTeacherOffice() {
        return teacherOffice;
    }

    public LinkedList<Schedule> getOpeningHours() {
        return openingHours;
    }

    @Override
    public void fillSummary(Classe classe) {
        if (classe == null || classe.getTeacher() != this) {
            return;
        }
        classe.registerClassInfo();
        super.signSummary(classe);
        giveToFill(classe);
    }

    public void giveToFill(Classe classe) {
        if (classe == null) {
            return;
        }
        for (Student student : classe.getStudents()) {
            student.signSummary(classe);
        }
    }

    @Override
    protected void attributeClasse(Classe classe) {
        if (classe == null) {
            return;
        }
        classe.setTeacher(this);
    }

    @Override
    protected void disableClasse(Classe classe) {
        if (classe == null) {
            return;
        }
        classe.removeTeacher();
    }

    public void setOffice(TeacherOffice teacherOffice) {
        if (teacherOffice == null || this.teacherOffice == null) {
            return;
        }

        removeOffice();
        this.teacherOffice = teacherOffice;

        teacherOffice.addTeacher(this);
    }

    public void removeOffice() {
        if (teacherOffice == null) {
            return;
        }

        TeacherOffice aux = teacherOffice;
        teacherOffice = null;

        aux.removeTeacher(this);
    }

    public void openOffice () {
        if (teacherOffice == null || teacherOffice.isOpenDoor()) {
            return;
        }

        teacherOffice.openDoor();
    }

    public void closeOffice () {
        if (teacherOffice == null || !teacherOffice.isOpenDoor()) {
            return;
        }

        teacherOffice.closeDoor();
    }

    public void openRoom (Room room) {
        if (room == null || room.isOpenDoor()) {
            return;
        }

        room    .openDoor();
    }

    public void closeRoom (Room room) {
        if (room == null || !room.isOpenDoor()) {
            return;
        }

        room.closeDoor();
    }

    public void setTeacherOffice(TeacherOffice teacherOffice) {
        if (teacherOffice == null || this.teacherOffice == teacherOffice) {
            return;
        }

        removeTeacherOffice();
        this.teacherOffice = teacherOffice;

        teacherOffice.addTeacher(this);
    }

    public void removeTeacherOffice() {
        if (teacherOffice == null) {
            return;
        }

        TeacherOffice aux = teacherOffice;
        teacherOffice = null;

        aux.removeTeacher(this);
    }

    public void addSchedule(Schedule schedule) {
        if (schedule == null || openingHours.contains(schedule)) {
            return;
        }

        openingHours.add(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        if (schedule == null || !openingHours.contains(schedule)) {
            return;
        }

        openingHours.remove(schedule);
    }


}