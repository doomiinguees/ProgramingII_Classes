package Model;

import java.util.LinkedList;

public class Security extends Person {
    private SecurityOffice securityOffice;
    private LinkedList<Schedule> openingHours;

    public Security(String name, long number, SecurityOffice securityOffice) {
        super(name, number);
        if(securityOffice != null) {
            setSecurityOffice(securityOffice);
        }
        openingHours = new LinkedList<>();
    }

    public SecurityOffice getSecurityOffice() {
        return securityOffice;
    }

    public LinkedList<Schedule> getOpeningHours() {
        return openingHours;
    }

    public void openDivision(Division division) {
        if (division != null || division.isOpenDoor()) {
            division.openDoor();
        }
    }

    public void closeDivision(Division division) {
        if (division != null || !division.isOpenDoor()) {
            division.closeDoor();
        }
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

}
