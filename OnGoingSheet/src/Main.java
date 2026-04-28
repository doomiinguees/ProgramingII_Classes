package Model;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        for (Classe classe : ClassesWeekManager.INSTANCE.getClasses()) {
            System.out.println(classe);
            System.out.println("\n----------------------------------------\n");
        }
    }
}
