package Model;

public class Teacher extends Academic {

    public Teacher(String name, long number) {
        super(name, number);
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
}