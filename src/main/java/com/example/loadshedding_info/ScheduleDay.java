package com.example.loadshedding_info;

import java.util.ArrayList;


public class ScheduleDay {
    private final String day;
    private final ArrayList<String> times;
   
    public ScheduleDay(String day) {
        this.times = new ArrayList();
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public ArrayList getTimes() {
        return times;
    }

    public void addTime(String time) {
        times.add(time);
    }
    
    @Override
    public String toString() {
        return day + ":" + times;
    }
    
    public String toJSON() {
        return "{\"day\":\"" + day + "\",\"times\":" + timesToString() +"}";
    }
    
    private String timesToString() {
        String timesString = "";
        
        for (String item : times) {
            if (times.indexOf(item) == 0) {
                timesString += "[\"" + item + "\"";
            }
            else if (times.size() - 1 == times.indexOf(item)) {
                timesString += ", \"" + item + "\"]";
            }
            else {
                timesString += ", \"" + item + "\"";
            }
        }
        
        if (times.isEmpty()){
            timesString = "[]";
        } else if (times.size() == 1) {
            timesString += "]";
        }
        
        return timesString;
    }

}