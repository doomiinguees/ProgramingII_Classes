import Model.Classe;
import Model.Student;
import Model.Teacher;

public class Main{
    void main() {
        Teacher teacher = new Teacher("Jefery", 123789);

        Classe classe = new Classe(4567, "Marketing 2", teacher);

        Student student1 = new Student("Ilone Mosca", 999);
        Student student2 = new Student("Duck Donalds", 888);

        System.out.println("Couna");
    }


}