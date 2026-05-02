package Model;

import java.util.LinkedList;

public class Security extends Person implements Employee{
    private SecurityOffice securityOffice;
    private EmployeeManager manager;

    public Security(String name, long number, SecurityOffice securityOffice) {
        super(name, number);
        if(securityOffice != null) {
            setSecurityOffice(securityOffice);
        }
        manager = new EmployeeManager();
    }

    public SecurityOffice getSecurityOffice() {
        return securityOffice;
    }

    public LinkedList<Schedule> getOpeningHours() {
        return manager.getOpeningHours();
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

    public void openOffice() {
        if (securityOffice == null || securityOffice.isOpenDoor()) {
            return;
        }

        securityOffice.openDoor();
    }

    public void closeOffice() {
        if (securityOffice == null || !securityOffice.isOpenDoor()) {
            return;
        }

        securityOffice.closeDoor();
    }

    public void setSecurityOffice(SecurityOffice securityOffice) {
        if (securityOffice == null || this.securityOffice == securityOffice) {
            return;
        }

        removeSecurityOffice();
        this.securityOffice = securityOffice;

        securityOffice.addSecurity(this);
    }

    public void removeSecurityOffice() {
        if (securityOffice == null) {
            return;
        }

        SecurityOffice aux = this.securityOffice;
        this.securityOffice = null;

        aux.removeSecurity(this);
    }

    public void addSchedule(Schedule schedule) {
        manager.addSchedule(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        manager.removeSchedule(schedule);
    }

}
