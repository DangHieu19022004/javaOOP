/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab6;

import java.util.Calendar;

public class MyDate {
    private int year;  // 1-9999
    private int month; // 1-12
    private int day;   // 1-31

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public void setDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Invalid year!");
        }
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month!");
        }
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid day!");
        }
        this.day = day;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12) return false;

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) daysInMonth[1] = 29;

        return day >= 1 && day <= daysInMonth[month - 1];
    }

    public static String getDayOfWeek(int year, int month, int day) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return days[cal.get(Calendar.DAY_OF_WEEK) - 1];
    }

    @Override
    public String toString() {
        return String.format("%s %d %s %d", getDayOfWeek(year, month, day), day,
                new java.text.DateFormatSymbols().getMonths()[month - 1], year);
    }

    public MyDate nextDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        return this;
    }

    public MyDate previousDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        return this;
    }
}
