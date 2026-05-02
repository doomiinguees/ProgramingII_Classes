package Model;

import java.util.LinkedList;

public class EmployeeManager {

    private LinkedList<Schedule> openingHours;

    public EmployeeManager() {
        openingHours = new LinkedList<>();
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
}
