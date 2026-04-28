package Model;

import java.util.LinkedList;

public enum ClassesWeekManager {
    INSTANCE;

    private LinkedList<Teacher> teachers;
    private LinkedList<Security> securities;
    private LinkedList<Student> students;
    private LinkedList<Classe> classes;

    ClassesWeekManager() {
        teachers = new LinkedList<>();
        securities = new LinkedList<>();
        students = new LinkedList<>();
        classes = new LinkedList<>();

        popularDados();
    }

    public void adicionar(Teacher teacher) {
        if (teacher == null || teachers.contains(teacher)) {
            return;
        }

        teachers.add(teacher);

        for (Classe classe : teacher.getClasses()) {
            adicionar(classe);
        }
    }

    public void remover(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void adicionar(Security security) {
        if (security == null || securities.contains(security)) {
            return;
        }

        securities.add(security);
    }

    public void remover(Security security) {
        securities.remove(security);
    }

    public void adicionar(Classe classe) {
        if (classe == null || classes.contains(classe)) {
            return;
        }

        classes.add(classe);
        adicionar(classe.getTeacher());

        for (Student student : classe.getStudents()) {
            adicionar(student);
        }
    }

    public void remover(Classe classe) {
        classes.remove(classe);
    }

    public void adicionar(Student student) {
        if (student == null || students.contains(student)) {
            return;
        }

        students.add(student);

        for (Classe classe : student.getClasses()) {
            adicionar(classe);
        }
    }

    public void remover(Student student) {
        students.remove(student);
    }

    public LinkedList<Teacher> getTeachers() {
        return new LinkedList<>(teachers);
    }

    public Teacher getTeacher(int indiceTeacher) {
        return teachers.get(indiceTeacher);
    }

    public LinkedList<Security> getSecurities() {
        return new LinkedList<>(securities);
    }

    public Security getSecurity(int indiceSecurity) {
        return securities.get(indiceSecurity);
    }

    public LinkedList<Student> getStudents() {
        return new LinkedList<>(students);
    }

    public Student getStudent(int indiceStudent) {
        return students.get(indiceStudent);
    }

    public LinkedList<Classe> getClasses() {
        return new LinkedList<>(classes);
    }

    public Classe getClasse(int indiceClasse) {
        return classes.get(indiceClasse);
    }

    private void popularDados() {
        TeacherOffice teacherOfficeA1 = new TeacherOffice("Gabinete Professor - A.1", false);
        TeacherOffice teacherOfficeD1 = new TeacherOffice("Gabinete Professor - D.1", true);

        SecurityOffice securityOfficeA = new SecurityOffice("Gabinete Segurança - Edifício A", false);
        SecurityOffice securityOfficeD = new SecurityOffice("Gabinete Segurança - Edifício D", false);

        Teacher teacherManuelSilva = new Teacher("Manuel Silva", 1, teacherOfficeA1);
        Teacher teacherCarlosSantos = new Teacher("Carlos Santos", 2, teacherOfficeA1);
        Teacher teacherJoseMonteiro = new Teacher("José Monteiro", 3, teacherOfficeD1);

        Security securityMiguelMarques = new Security("Miguel Marques", 4, securityOfficeA);
        Security securityJoaoSantos = new Security("João Santos", 5, securityOfficeA);
        Security securityAntonioSilva = new Security("António Silva", 6, securityOfficeD);

        Room roomA1 = new Room("Sala A1", true);
        Room roomA2 = new Room("Sala A2", true);
        Room roomLAI1 = new Room("Sala LAI1", false);

        // Nota: as classes atuais ainda não inicializam algumas listas internas
        // em Room, TeacherOffice e Teacher. Por isso, para evitar NullPointerException,
        // as salas são criadas mas não são associadas diretamente às classes aqui.
        Classe classe1 = new Classe("Programação II TP1", 1, new Schedule(WeekDay.MONDAY, 8, 2), null);
        Classe classe2 = new Classe("Programação II TP2", 2, new Schedule(WeekDay.MONDAY, 8, 2), null);
        Classe classe3 = new Classe("Programação II PL1", 3, new Schedule(WeekDay.MONDAY, 10, 3), null);

        Student student1 = new Student("José António", 2170001);
        Student student2 = new Student("Miguel Afonso", 2170002);
        Student student3 = new Student("Susana Lopes", 2170003);

        adicionar(teacherManuelSilva);
        adicionar(teacherCarlosSantos);
        adicionar(teacherJoseMonteiro);

        adicionar(securityMiguelMarques);
        adicionar(securityJoaoSantos);
        adicionar(securityAntonioSilva);

        adicionar(student1);
        adicionar(student2);
        adicionar(student3);

        classe1.setTeacher(teacherManuelSilva);
        classe2.setTeacher(teacherCarlosSantos);
        classe3.setTeacher(teacherJoseMonteiro);

        classe1.addStudent(student1);
        classe1.addStudent(student2);

        classe2.addStudent(student3);

        classe3.addStudent(student1);
        classe3.addStudent(student2);
        classe3.addStudent(student3);

        adicionar(classe1);
        adicionar(classe2);
        adicionar(classe3);
    }
}
