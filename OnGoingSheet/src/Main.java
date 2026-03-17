import Model.Classe;
import Model.Student;
import Model.Teacher;

import java.util.LinkedList;

public class Main{
    void main() {
        Teacher teacher = new Teacher("Jefery", 123789);

        Classe mrkt = new Classe("Marketing 2", 4567);

        Student student1 = new Student("Ilone Mosca", 999);
        Student student2 = new Student("Duck Donalds", 888);

        LinkedList<Student> students = new LinkedList<>();

        students.add(student1);
        students.add(student2);

        Classe dev = new Classe("Development II", 3, teacher, students);

        teacher.fillSummary(dev);
        student1.signSummary(dev);

        System.out.println("acvabei!");

    }


}