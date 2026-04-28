package Model;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        TeacherOffice teacherOfficeA1 = new TeacherOffice("Gabinete Professor - A.1", false);
        TeacherOffice teacherOfficeD1 = new TeacherOffice("Gabinete Professor - D.1", true);

        SecurityOffice securityOfficeA = new SecurityOffice("Gabinete Segurança - Edifício A", false);
        SecurityOffice securityOfficeD = new SecurityOffice("Gabinete Segurança - Edifício D", false);

        // Nota: na classe Teacher enviada, setOffice() não atribui gabinete quando teacherOffice está null
        // e openingHours não é inicializado. Por isso, o Main evita chamar addSchedule() em Teacher.
        Teacher teacherManuelSilva = new Teacher("Manuel Silva", 1, null);
        Teacher teacherCarlosSantos = new Teacher("Carlos Santos", 2, null);
        Teacher teacherJoseMonteiro = new Teacher("José Monteiro", 3, null);

        Security securityMiguelMarques = new Security("Miguel Marques", 4, securityOfficeA);
        Security securityJoaoSantos = new Security("João Santos", 5, securityOfficeA);
        Security securityAntonioSilva = new Security("António Silva", 6, securityOfficeD);

        securityMiguelMarques.addSchedule(new Schedule(WeekDay.MONDAY, 8, 8));
        securityMiguelMarques.addSchedule(new Schedule(WeekDay.TUESDAY, 8, 8));
        securityMiguelMarques.addSchedule(new Schedule(WeekDay.WEDNESDAY, 8, 8));
        securityMiguelMarques.addSchedule(new Schedule(WeekDay.THURSDAY, 8, 8));
        securityMiguelMarques.addSchedule(new Schedule(WeekDay.FRIDAY, 8, 8));

        securityJoaoSantos.addSchedule(new Schedule(WeekDay.MONDAY, 16, 8));
        securityJoaoSantos.addSchedule(new Schedule(WeekDay.TUESDAY, 16, 8));
        securityJoaoSantos.addSchedule(new Schedule(WeekDay.WEDNESDAY, 16, 8));
        securityJoaoSantos.addSchedule(new Schedule(WeekDay.THURSDAY, 16, 8));
        securityJoaoSantos.addSchedule(new Schedule(WeekDay.FRIDAY, 16, 8));

        securityAntonioSilva.addSchedule(new Schedule(WeekDay.SATURDAY, 8, 8));

        Room roomA1 = new Room("Sala A1", true);
        Room roomA2 = new Room("Sala A2", true);
        Room roomLAI1 = new Room("Sala LAI1", false);

        // Nota: Room não inicializa a lista classes no construtor.
        // Para não rebentar com NullPointerException, as aulas são criadas sem sala associada.
        Classe classe1 = new Classe("Programação II TP1", 1, new Schedule(WeekDay.MONDAY, 8, 2), null);
        Classe classe2 = new Classe("Programação II TP2", 2, new Schedule(WeekDay.MONDAY, 8, 2), null);
        Classe classe3 = new Classe("Programação II PL1", 3, new Schedule(WeekDay.MONDAY, 10, 3), null);

        // Professores abrem/fecham salas através dos métodos existentes na classe Teacher.
        teacherCarlosSantos.openRoom(roomLAI1);
        teacherCarlosSantos.closeRoom(roomLAI1);

        // Seguranças abrem/fecham qualquer divisão através dos métodos existentes na classe Security.
        securityMiguelMarques.openDivision(securityOfficeA);
        securityJoaoSantos.closeDivision(teacherOfficeD1);
        securityAntonioSilva.closeDivision(roomA1);
        securityAntonioSilva.closeDivision(roomA2);

        System.out.println(roomA1.getName());

        // Aplicação do polimorfismo numa estrutura de dados.
        LinkedList<Describer> describers = new LinkedList<>();
        describers.add(teacherOfficeA1);
        describers.add(teacherOfficeD1);
        describers.add(securityOfficeA);
        describers.add(securityOfficeD);

        describers.add(teacherManuelSilva);
        describers.add(teacherCarlosSantos);
        describers.add(teacherJoseMonteiro);

        describers.add(securityMiguelMarques);
        describers.add(securityJoaoSantos);
        describers.add(securityAntonioSilva);

        describers.add(roomA1);
        describers.add(roomA2);
        describers.add(roomLAI1);

        describers.add(classe1);
        describers.add(classe2);
        describers.add(classe3);

        for (Describer describer : describers) {
            System.out.print("Nome: " + describer.getName() + " ");

            if (describer instanceof Identifier) {
                long number = ((Identifier) describer).getNumber();
                System.out.println("(Identificador: nº " + number + ")");
            } else if (describer instanceof Division) {
                System.out.println("(Divisão)");
            }
        }

        // Exemplo seguro de cast com verificação.
        Describer first = describers.get(0);
        if (first instanceof SecurityOffice) {
            SecurityOffice securityOffice = (SecurityOffice) first;
            System.out.println(securityOffice.getName());
        } else {
            System.out.println("O primeiro elemento não é um SecurityOffice.");
        }
    }
}
