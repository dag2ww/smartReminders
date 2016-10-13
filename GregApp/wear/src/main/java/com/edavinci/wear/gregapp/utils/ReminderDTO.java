package com.edavinci.wear.gregapp.utils;

import android.content.Intent;

import java.io.Serializable;

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

    public String toShortString(){
        return message+" "+"H:"+hourOfday+",M:"+minute+",D:"+day+"-"+month+"-"+year;
    }
}
