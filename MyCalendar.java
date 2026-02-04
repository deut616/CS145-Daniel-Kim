/*
 * Name: Daniel Kim
 * Lab: Exercise 13.4
 * Date: 2026-02-03
 */

/*
 * Name: Daniel Kim
 * Lab: Exercise 13.4
 * Date: 2026-02-03
 */

import java.util.Calendar;

public abstract class MyCalendar {

    protected Calendar calendar;

    protected MyCalendar() {
        calendar = new java.util.GregorianCalendar();
    }

    // Abstract methods subclasses must implement
    public abstract int daysInMonth();

    public abstract String getMonthName();

    // Concrete methods accessible to subclasses and users
    public int get(int field) {
        return calendar.get(field);
    }

    public void set(int field, int value) {
        calendar.set(field, value);
    }
}


