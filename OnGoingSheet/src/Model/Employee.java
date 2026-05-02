package Model;

import java.util.LinkedList;

public interface Employee<T extends Office> {
    void openOffice();

    void closeOffice();

    LinkedList<Schedule> getOpeningHours();

    void addSchedule(Schedule schedule);

    void removeSchedule(Schedule schedule);

    void setOffice(T office);

}
