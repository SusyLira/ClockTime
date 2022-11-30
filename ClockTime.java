/**
 * Name:  Susy Lira (lira) 
 * Course:  CSCI-241 - Computer Science I
 * Section: 001
 * Assignment: 9
 * 
 * Project/Class Description: Keeps track of the times on two clock objects and
 * compares the two to see if both clocks hold the same time
 * 
 * Known Bugs:  none.
 */
import java.util.*;
public class ClockTime{
    //declare instance variables
    //keeps time in the 24-hour format
    private int hour;
    private int minute;
    private int second;
    //Constructor that initializes all instance variables to 0
    public ClockTime(){
        hour = 0;
        minute = 0;
        second = 0;
    }
    //Constuctor changes value of instance variables depending
    //on the arguments passed in the parameters
    public ClockTime(int hr, int min, int sec){
        //if parameter is greater then 59 then add the reaminding seconds onto
        //mins
        if (sec > 59){
            int sec2 = sec;
            sec = sec % 60;
            min += sec2/60;
        }
        //if parameter is a negative number make it equal to zero
        else if (sec < 0){
            sec = 0;
        }
        second = sec;
        //if minute parameter is greater than 59 add remainder to hr
        if (min > 59){
            int min2 = min;
            min = min % 60;
            hr += min2/60;
        }
        else if (min < 0){
            min = 0;
        }
        minute = min;
        //if hr parameter is greater than 24 mod by 24
        if (hr > 24){
            hr = hr % 24;
        }
        else if (hr < 0){
            hr = 0;
        }
        hour = hr;
    }
    //create a getter method that returns the value for hour
    public int  getHour(){
        return hour;
    }
    //create a getter method that gets the value for minute
    public int getMinute(){
        return minute;
    }
    //create a getter method that returns the value for second
    public int getSecond(){
        return second;
    }
    //create a setter method that sets the value for hour
    public void setHour(int h){
        if (h > 24){
            h = h % 24;
        }
        else if (h < 0){
            h = 0;
        }
        hour = h;
    }
    //create a setter method that sets the value for minute
    public void setMinute(int m){
        if (m > 59){
            int m2 = m;
            m = m % 60;
            hour += m2/60;
        }
        else if (m < 0){
            m = 0;
        }
        minute = m;
    }
    //create a setter method that sets the value for second
    public void setSecond(int s){
        if (s > 59){
            int s2 = s;
            s = s % 60;
            minute += s2/60;
        }
        //if parameter is a negative number make it equal to zero
        else if (s < 0){
            s = 0;
        }
        second = s;
    }
    //method that displays time in a 24-hour format
    public String toString(){
        String printHour = String.format("%02d", hour);
        String printMinute = String.format("%02d", minute);
        String printSecond =String.format("%02d",second);
        return (printHour + ":" + printMinute + ":" + printSecond);
    }
    //method that displays time in a 12-hour format
    public String toString12(){
        int count = 0;
        //if hour is greater than 12 increment count and print out the value of 
        //count as the hour
        for (int i = 0; i <= hour; i++){
            if (i > 12){
                count ++;
            }
        }
        //variables needed for string
        String printCount = String.format("%02d", count);
        String printHour = String.format("%02d", hour);
        String printMinute = String.format("%02d", minute);
        String printSecond =String.format("%02d",second);
        //return statements
        if (hour > 12){
            return (printCount + ":" + printMinute + ":" + printSecond + " P.M.");
        }
        else {
            return (printHour + ":" +  printMinute + ":" + printSecond + " A.M.");
        }
    }
    //method takes in an argument and adds it to the ClockTime object 
    public void advance(int add){
        second += add;
        //if i % 60 is equal to 60 add to minutes
        for (int i = 1; i <= second; i++){  
            if (i % 60 == 0){
                minute++;
            }
        }
        //If j % 60 is equal to 60 add to hours
        for(int j = 1; j <= minute; j++){
            if(j % 60 == 0){
                hour++;
            }
        }
        //the remainder of the two is what will be set as the value for the 
        //variables
        second = second % 60;
        minute = minute % 60;
        //If hour is greater than 24 use mod to make it less than 24 
        if (hour > 24){
            hour = hour % 24;
        }
    }
    //Method checks if the current ClockTime contains the same values as the one
    //sent in the parameter
    public boolean equals(ClockTime x){
        return (hour == x.hour) && (minute == x.minute) && (second == x.second);
    }
}
