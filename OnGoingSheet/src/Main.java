import Model.Classe;
import Model.Schedule;
import Model.Student;
import Model.Teacher;
import Model.WeekDay;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        System.out.println(WeekDay.SUNDAY);
        System.out.println(WeekDay.SUNDAY.ordinal());
        System.out.println(Arrays.toString(WeekDay.values()));
        System.out.println(WeekDay.values().length);

        Teacher teacher1 = new Teacher("Manuel Gomes", 1);
        Teacher teacher2 = new Teacher("Carlos Miguel", 2);

        Student student1 = new Student("José António", 2190354);
        Student student2 = new Student("Carlos Santos", 2191187);

        LinkedList<Student> students = new LinkedList<>();
        students.add(student1);
        students.add(student2);

        Classe class1 = new Classe("Programação 2 TP1", 1, new Schedule(WeekDay.MONDAY, 8, 2), teacher1, students);

        Classe class2 = new Classe("Programação 2 PL1", 1, new Schedule(WeekDay.TUESDAY, 11, 3));

        Classe class3 = new Classe("Programação 2 PL2", 1, new Schedule(WeekDay.TUESDAY, 15, 3));

        class2.setTeacher(teacher2);
        class2.addStudent(student1);

        class3.setTeacher(teacher2);
        class3.addStudent(student2);

        Teacher teacher3 = new Teacher("António João", 3);
        Student student3 = new Student("João Santos", 2192312);

        Classe class4 = new Classe("Matemática Discreta",1,new Schedule(WeekDay.TUESDAY, 18, 2));

        class4.setTeacher(teacher3);

        for (Student student : students) {
            class4.addStudent(student);
        }
        class4.addStudent(student3);

        LinkedList<Classe> aulasAluno2TercaFeiraTarde = student2.getClasses(new Schedule(WeekDay.TUESDAY, 14, 10));
        LinkedList<Classe> aulasAluno2TercaFeiraAposAsDezanoveHoras = student2.getClasses(new Schedule(WeekDay.TUESDAY, 19, 5));
        LinkedList<Classe> aulasAluno2TercaFeiraAposAsVinteHoras = student2.getClasses(new Schedule(WeekDay.TUESDAY, 20, 4));
        LinkedList<Classe> aulasAluno3TercaFeira = student2.getClasses(new Schedule(WeekDay.TUESDAY, 8, 16));

        teacher1.fillSummary(class1);

        System.out.println("Resumo da aula 1:");
        System.out.println(class1.getSummary());

        teacher2.fillSummary(class2);

        System.out.println("Resumo da aula 2:");
        System.out.println(class2.getSummary());

        teacher3.fillSummary(class4);

        System.out.println("Resumo da aula 4:");
        System.out.println(class4.getSummary());
    }
}