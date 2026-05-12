package Model;

import java.util.LinkedList;

public class Teacher extends Academic implements Employee<TeacherOffice>{

    private EmployeeManager<Teacher, TeacherOffice, Room> manager;

    public Teacher(String name, long number, TeacherOffice teacherOffice) {
        super(name, number);
        manager = new EmployeeManager<>(this);
        if (teacherOffice != null) {
            manager.setOffice(teacherOffice);
        }
    }

    public TeacherOffice getTeacherOffice() {
        return manager.getOffice();
    }

    public LinkedList<Schedule> getOpeningHours() {
        return manager.getOpeningHours();
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
    public void attributeClasse(Classe classe) {
        if (classe == null) {
            return;
        }
        classe.setTeacher(this);
    }

    @Override
    public void disableClasse(Classe classe) {
        if (classe == null) {
            return;
        }
        classe.removeTeacher();
    }

    public void setOffice(TeacherOffice teacherOffice) {
        manager.setOffice(teacherOffice);
    }

    public void removeOffice() {
        manager.removeOffice();
    }

    public void openOffice () {
        manager.openOffice();
    }

    public void closeOffice () {
        manager.closeOffice();
    }

    public void openRoom (Room room) {
        manager.closeDivision(room);
    }

    public void closeRoom (Room room) {
        manager.closeDivision(room);
    }

    public void addSchedule(Schedule schedule) {
        manager.addSchedule(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        manager.removeSchedule(schedule);
    }


}