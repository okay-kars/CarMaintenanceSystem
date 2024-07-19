package main;

import java.util.Date;

public class Maintenance {
    private String description;
    private Date date;
    private int mileage;

    public Maintenance(String description, Date date, int mileage) {
        this.description = description;
        this.date = date;
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return description + " am " + date + " bei " + mileage + " km";
    }
}
