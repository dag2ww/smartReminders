package com.edavinci.wear.gregapp.activities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Grzegorz on 2016-10-05.
 */
public class ReminderDTO implements Serializable {
    public int hourOfday;
    public int minute;
    public int year;
    public int month;
    public int day;
    public String message = "nothing";

    public ReminderDTO(){

    }

    public ReminderDTO(ReminderDTO reminder){
        hourOfday = reminder.hourOfday;
        minute = reminder.minute;
        year = reminder.year;
        month = reminder.month;
        day = reminder.day;
        message = reminder.message;
    }

    String toShortString(){
        return message+" "+"H:"+hourOfday+",M:"+minute+",D:"+day+"-"+month+"-"+year;
    }
}
