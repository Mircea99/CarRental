package ro.jademy.carrental.cars;

import java.util.Date;

public class CarState {

    private boolean isRented;
    private Date startDate;
    private Date endDate;

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "CarState{" +
                "isRented=" + isRented +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
