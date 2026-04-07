package Model;

import java.util.LinkedList;

public class Classe {
    //region | Attributes
    private String name;
    private long number;
    private StringBuilder summary;
    private Teacher teacher;
    private LinkedList<Student> students;
    private Schedule schedule;
    //endregion

    //region | Constructor
    public Classe(String name, long number, Schedule schedule) {
        this(name, number, schedule, null, new LinkedList<>());

    }

    public Classe(String name, long number, Schedule schedule, Teacher teacher, LinkedList<Student> students) {
        this.name = name;
        this.number = number;
        this.schedule = schedule;
        summary = new StringBuilder();
        setTeacher(teacher);
        this.students = new LinkedList<>();
        students.forEach(this::addStudent);
    }

    //endregion

    //region | Getters & Setters

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary.toString();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LinkedList<Student> getStudents() {
        return new LinkedList<>(students);      //copy to save integrity
    }

    public long getNumber() {
        return number;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setTeacher(Teacher teacher) {
        //pre-conditions
        if (teacher == null || this.teacher == teacher) {
            return;
        }

        //actions
        removeTeacher();
        this.teacher = teacher;

        //post conditions
        teacher.addClass(this);
    }

    //endregion

    //region | Methods
    public void addSummaryLine(String line) {
        if(line == null || line.isBlank()) {
            return;
        }

        summary.append(line).append("\n");
    }

    public void addStudent(Student student) {
        if(student == null || students.contains(student)) {
            return;
        }

        students.add(student);

        student.addClass(this);
    }

    public void registerClassInfo() {
        addSummaryLine(name);
        addSummaryLine(Long.toString(number));
    }

    public void removeStudent(Student student) {
        if (!students.remove(student)) {
            return; 
        }

        student.removeClasse(this);
    }

    public void removeTeacher() {
        if (this.teacher == null) {
            return;
        }

        Teacher aux = teacher;
        this.teacher = null;

        aux.removeClasse(this);
    }
    //endregion
}
