package Model;

import java.util.LinkedList;

public class Classe {
    //region | Attributes
    private String name;
    private long number;
    private String summary;
    private Teacher teacher;
    private LinkedList<Student> students;
    //endregion

    //region | Constructor
    public Classe(long number, String name, Teacher teacher) {
        this.number = number;
        this.name = name;
        this.teacher = teacher;
    }

    public Classe(String name, long number, String summary, Teacher teacher, LinkedList<Student> students) {
        this.name = name;
        this.number = number;
        this.summary = summary;
        this.teacher = teacher;
        this.students = students;
    }

    //endregion

    //region | Getters & Setter

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    //endregion

    //region | Methods
    public void addSummaryLine(String line) {}

    public void addStudent(Student student) {}

    public void removeStudent(Student student) {}

    public void addTeacher(Teacher teacher) {}

    public void removeTeacher(Teacher teacher) {}
    //endregion
}
