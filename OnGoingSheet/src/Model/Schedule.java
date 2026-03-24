package Model;

public class Schedule {

    //region | Attributes
    private WeekDay day;
    private int start;
    private int duration;
    //endregion

    //region | Constructor

    public Schedule(WeekDay day, int start, int duration) {
        this.day = day;
        this.start = start;
        this.duration = duration;
    }

    //endregion


    //region | Getters & Setters

    public WeekDay getDay() {
        return day;
    }

    public int getStart() {
        return start;
    }

    public int getDuration() {
        return duration;
    }

    public float getEndTime() {
        return start + duration;
    }

    //endregion

    public boolean intersect(Schedule schedule) {
        return schedule.day == this.day &&
                schedule.getEndTime() > this.getStart() &&
                schedule.getStart() < this.getEndTime();
    }
}
