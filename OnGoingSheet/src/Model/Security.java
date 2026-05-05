package Model;

import java.util.LinkedList;

public class Security extends Person implements Employee<SecurityOffice>{
    private EmployeeManager<Security, SecurityOffice> manager;

    public Security(String name, long number, SecurityOffice office) {
        super(name, number);
        manager = new EmployeeManager(this);
        if(office != null) {
            manager.setOffice(office);
        }
    }

    public SecurityOffice getOffice() {
        return manager.getOffice();
    }

    public LinkedList<Schedule> getOpeningHours() {
        return manager.getOpeningHours();
    }

    @Override
    public void removeOffice() {
        manager.removeOffice();
    }

    @Override
    public void setOffice(SecurityOffice office) {
        manager.setOffice(office);
    }

    public void openOffice() {
        manager.openOffice();
    }

    public void closeOffice() {
        manager.closeOffice();
    }

    public void addSchedule(Schedule schedule) {
        manager.addSchedule(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        manager.removeSchedule(schedule);
    }

    public void openDivision(Division division) {
        if (division != null && division.isOpenDoor()) {
            division.openDoor();
        }
    }

    public void closeDivision(Division division) {
        if (division != null && !division.isOpenDoor()) {
            division.closeDoor();
        }
    }



}
