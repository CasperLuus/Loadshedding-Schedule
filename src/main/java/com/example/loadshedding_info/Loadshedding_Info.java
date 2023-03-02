package com.example.loadshedding_info;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Loadshedding_Info {

    public static void main(String[] args) {
        ArrayList<Schedule> schedule = new ArrayList<>(Arrays.asList(
              new Schedule("stage1", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/1/9/25"),
              new Schedule("stage2", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/2/9/25"),
              new Schedule("stage3", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/3/9/25"),
              new Schedule("stage4", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/4/9/25"),
              new Schedule("stage5", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/5/9/25"),
              new Schedule("stage6", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/6/9/25")
      ));
        printSchedule("Stage 1", new Schedule("stage1","https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/1/9/25").getScheduleList());
        printSchedule("Stage 2", new Schedule("stage2", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/2/9/25").getScheduleList());
        printSchedule("Stage 3", new Schedule("stage3", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/3/9/25").getScheduleList());
        printSchedule("Stage 4", new Schedule("stage4", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/4/9/25").getScheduleList());
        printSchedule("Stage 5", new Schedule("stage5", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/5/9/25").getScheduleList());
        printSchedule("Stage 6", new Schedule("stage6", "https://loadshedding.eskom.co.za/LoadShedding/GetScheduleM/1058862/6/9/25").getScheduleList());
        
        writeToJSON(buildScheduleJSON(schedule));
    }
    
    private static String buildScheduleJSON(ArrayList<Schedule> schedule) {
        
        String json = "{\"schedule\":{";
        
        for (Schedule stage : schedule) {
            if (schedule.indexOf(stage) == schedule.size() - 1) {
                json += stage.toJSON();
            } else {
                json += stage.toJSON() + ",";
            }
        }
        
        return json + "}}";
        
    }
    
    private static void writeToJSON(String json) {
        FileWriter file;
        
        try {
            file = new FileWriter("C:\\Users\\Casper\\Documents\\NetBeansProjects\\Loadshedding_Info\\src\\main\\java\\com\\example\\loadshedding_info\\Schedule.json");
            file.write(json);
            file.close();
        } catch (IOException ex) {
            Logger.getLogger(Loadshedding_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void printSchedule(String stage, ArrayList<ScheduleDay> scheduleList) {
        
        System.out.println(stage);
        System.out.println("___________________");
        
        for (ScheduleDay day : scheduleList) {
            System.out.println(day.getDay());
                      
            for (Object time : day.getTimes()) {
                System.out.println(time);
            }
        }
        
        System.out.println("___________________");
    }
}
