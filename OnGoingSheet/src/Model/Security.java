package Model;

import java.util.LinkedList;

public class Security {
    private String name;
    private long number;
    private SecurityOffice securityOffice;
    private LinkedList<Schedule> openingHours;

    public Security(String name, long number, SecurityOffice securityOffice) {
        this.name = name;
        this.number = number;
        if(securityOffice != null) {
            setSecurityOffice(securityOffice);
        }
        openingHours = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public SecurityOffice getSecurityOffice() {
        return securityOffice;
    }

    public LinkedList<Schedule> getOpeningHours() {
        return openingHours;
    }

    public void openOffice() {
        if (securityOffice != null || securityOffice.isOpenDoor()) {
            securityOffice.openDoor();
        }
    }

    public void closeOffice() {
        if (securityOffice != null || !securityOffice.isOpenDoor()) {
            securityOffice.closeDoor();
        }
    }

    public void openTeacherOffice (TeacherOffice teacherOffice) {
        if (teacherOffice == null || teacherOffice.isOpenDoor()) {
            return;
        }

        teacherOffice.openDoor();
    }

    public void closeTeacherOffice (TeacherOffice teacherOffice) {
        if (teacherOffice == null || !teacherOffice.isOpenDoor()) {
            return;
        }

        teacherOffice.closeDoor();
    }

    public void openSecurityOffice (SecurityOffice securityOffice) {
        if (securityOffice == null || securityOffice.isOpenDoor()) {
            return;
        }

        securityOffice.openDoor();
    }

    public void closeSecurityOffice (SecurityOffice securityOffice) {
        if (securityOffice == null || !securityOffice.isOpenDoor()) {
            return;
        }

        securityOffice.closeDoor();
    }

    public void openRoom (Room room) {
        if (room == null || room.isOpenDoor()) {
            return;
        }

        room.openDoor();
    }

    public void closeRoom (Room room) {
        if (room == null || !room.isOpenDoor()) {
            return;
        }

        room.closeDoor();
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setSecurityOffice(SecurityOffice securityOffice) {
        if (securityOffice == null || this.securityOffice == securityOffice) {
            return;
        }

        removeSecurityOffice();
        this.securityOffice = securityOffice;

    }

    public void removeSecurityOffice() {

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
