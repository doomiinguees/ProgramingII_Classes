package Model;

public class Student extends Academic {

    public Student(String name, long number) {
        super(name, number);
    }

    @Override
    public void fillSummary(Classe classe) {
        if (classe == null) {
            return;
        }
        super.signSummary(classe);
    }

    @Override
    public void attributeClasse(Classe classe) {
        if (classe == null) {
            return;
        }
        classe.addStudent(this);
    }

    @Override
    public void disableClasse(Classe classe) {
        if (classe == null) {
            return;
        }
        classe.removeStudent(this);
    }
}