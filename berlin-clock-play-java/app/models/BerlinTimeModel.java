package models;

public class BerlinTimeModel {
    private Boolean   clockTwoSeconds;
    private Boolean[] hoursPerFive;
    private Boolean[] hoursPerOne;
    private Boolean[] minutesPerFive;
    private Boolean[] minutesPerOne;

    public BerlinTimeModel() {
        this.clockTwoSeconds = false;
        this.hoursPerFive    = new Boolean[]{ false, false, false, false };
        this.hoursPerOne     = new Boolean[]{ false, false, false, false };
        this.minutesPerFive  = new Boolean[]{ false, false, false, false, false, false, false, false, false, false, false };
        this.minutesPerOne   = new Boolean[]{ false, false, false, false };
    }

    public Boolean getClockTwoSeconds() {
        return clockTwoSeconds;
    }

    public void setClockTwoSeconds(Boolean clockTwoSeconds) {
        this.clockTwoSeconds = clockTwoSeconds;
    }

    public Boolean[] getHoursPerFive() {
        return hoursPerFive;
    }

    public void setHoursPerFive(Boolean[] hoursPerFive) {
        this.hoursPerFive = hoursPerFive;
    }

    public Boolean[] getHoursPerOne() {
        return hoursPerOne;
    }

    public void setHoursPerOne(Boolean[] hoursPerOne) {
        this.hoursPerOne = hoursPerOne;
    }

    public Boolean[] getMinutesPerFive() {
        return minutesPerFive;
    }

    public void setMinutesPerFive(Boolean[] minutesPerFive) {
        this.minutesPerFive = minutesPerFive;
    }

    public Boolean[] getMinutesPerOne() {
        return minutesPerOne;
    }

    public void setMinutesPerOne(Boolean[] minutesPerOne) {
        this.minutesPerOne = minutesPerOne;
    }
}
