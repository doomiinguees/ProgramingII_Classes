package Model;

import java.util.LinkedList;

public class EmployeeManager <E extends Employee, O extends Office<E>, D extends Division>{

    private LinkedList<Schedule> openingHours;
    private O office;
    private E owner;

    public EmployeeManager(E owner) {
        openingHours = new LinkedList<>();
        this.owner = owner;
    }

    public LinkedList<Schedule> getOpeningHours() {
        return openingHours;
    }

    public void addSchedule(Schedule schedule) {
        if (schedule == null || openingHours.contains(schedule)) {
            return;
        }

        openingHours.add(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        if (schedule == null || !openingHours.contains(schedule)) {
            return;
        }

        openingHours.remove(schedule);
    }

    public O getOffice() {
        return office;
    }

    public void setOffice(O office) {
        if (office == null || this.owner == office) {
            return;
        }

        removeOffice();
        this.office = office;

        office.addEmployee(owner);
    }

    public void removeOffice() {
        if (office == null) {
            return;
        }

        O aux = office;
        office = null;

        aux.removeEmployee(owner);
    }

    public void openOffice() {
        if (office == null || office.isOpenDoor()) {
            return;
        }

        office.openDoor();
    }

    public void closeOffice() {
        if (office == null || !office.isOpenDoor()) {
            return;
        }

        office.closeDoor();
    }

    public void openDivision(D division) {
        if (division != null && division.isOpenDoor()) {
            division.openDoor();
        }
    }

    public void closeDivision(D division) {
        if (division != null && !division.isOpenDoor()) {
            division.closeDoor();
        }
    }
}
