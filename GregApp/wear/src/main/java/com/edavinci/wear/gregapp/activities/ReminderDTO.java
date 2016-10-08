package com.edavinci.wear.gregapp.activities;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Grzegorz on 2016-10-05.
 */
public class ReminderDTO implements Serializable {
    public int hourOfday;
    public int minute;
    public Date date;
    public String message = "nothing";

    public ReminderDTO(){

    }

    public ReminderDTO(int hourOfday, int minute, Date date, String message) {
        this.hourOfday = hourOfday;
        this.minute = minute;
        this.date = date;
        this.message = message;
    }

    public ReminderDTO(ReminderDTO reminder){
        hourOfday = reminder.hourOfday;
        minute = reminder.minute;
        date = reminder.date;
        message = reminder.message;
    }

    String toShortString(){
        return message+" "+"H:"+hourOfday+",M:"+minute+"D:"+date;
    }
}
