package com.edavinci.wear.gregapp.activities;

import java.io.Serializable;

/**
 * Created by Grzegorz on 2016-10-05.
 */
public class ReminderDTO implements Serializable {
    public int hourOfday;
    public int minute;
    public String date;
    public String message;

    String toShortString(){
        return message+"\n"+"H:"+hourOfday+",M:"+minute+"D:"+date;
    }
}
