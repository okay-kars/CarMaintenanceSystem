package main;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ServiceReminder {
    private Car car;
    private Timer timer;

    public ServiceReminder(Car car) {
        this.car = car;
        this.timer = new Timer(true);
    }

    public void scheduleReminder(Date date, String message) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Erinnerung: " + message + " für " + car);
            }
        }, date);
    }

    public void cancelReminders() {
        timer.cancel();
    }
}
