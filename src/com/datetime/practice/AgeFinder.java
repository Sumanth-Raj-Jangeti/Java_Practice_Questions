package com.datetime.practice;

import java.time.LocalDate;
import java.time.Period;

public class AgeFinder {
    public static void main(String[] args) {
        AgeFinder obj = new AgeFinder();
        // Example DOB
        LocalDate dob = LocalDate.of(2003, 6, 6);
        System.out.println("Age: " + obj.getAge(dob));
        System.out.println("Date after 10 days: " + obj.getDateAfterNDays(10));
        System.out.println("Date after 1 year, 2 months, 15 days: "
                + obj.getDateAfterXYearYMonthZDays(1, 2, 15));
    }

    public int getAge(LocalDate dateOfBirth) {
        LocalDate today = LocalDate.now();
        return Period.between(dateOfBirth, today).getYears();
    }

    public LocalDate getDateAfterNDays(int noOfDays) {
        LocalDate today = LocalDate.now();
        return today.plusDays(noOfDays);
    }

    public LocalDate getDateAfterXYearYMonthZDays(int year, int month, int day) {
        LocalDate today = LocalDate.now();
        return today.plusYears(year).plusMonths(month).plusDays(day);
    }
}