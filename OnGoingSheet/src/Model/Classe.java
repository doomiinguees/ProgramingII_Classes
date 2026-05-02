package Model;

import java.util.LinkedList;

public class Classe extends Identifier{
    //region | Attributes
    private StringBuilder summary;
    private Teacher teacher;
    private LinkedList<Student> students;
    private Schedule schedule;
    private Room room;

    //endregion

    //region | Constructor
    public Classe(String name, long number, Schedule schedule, Room room) {
        this(name, number, schedule, room, null, new LinkedList<>());

    }

    public Classe(String name, long number, Schedule schedule, Room room, Teacher teacher, LinkedList<Student> students) {
        super(name, number);
        this.schedule = schedule;
        if(room != null) {
            setRoom(room);
        }
        summary = new StringBuilder();
        setTeacher(teacher);
        this.students = new LinkedList<>();
        students.forEach(this::addStudent);
    }

    //endregion

    //region | Getters & Setters
    public String getSummary() {
        return summary.toString();
    }

    public Room getRoom() {
        return room;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LinkedList<Student> getStudents() {
        return new LinkedList<>(students);      //copy to save integrity
    }

    public Schedule getSchedule() {
        return schedule;
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
        teacher.addClasse(this);
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

        student.addClasse(this);
    }

    public void registerClassInfo() {
        addSummaryLine(getName());
        addSummaryLine(Long.toString(getNumber()));
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

    public void setRoom(Room room) {
        if(room == null || this.room == room) {
            return;
        }

        removeRoom();
        this.room = room;

        room.addClasse(this);
    }

    public void removeRoom() {
        if (room == null) {
            return;
        }

        Room aux = this.room;
        this.room = null;

        aux.removeClasse(this);
    }
    //endregion
}
