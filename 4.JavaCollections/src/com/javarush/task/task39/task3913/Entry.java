package com.javarush.task.task39.task3913;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Entry {
    private String ip;
    private String user;
    private Date date;
    private Event event;
    private int task;
    private Status status;

    public Entry(String ip, String user, Date date, Event event, int task, Status status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.task = task;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public int getTask() {
        return task;
    }

    public Status getStatus() {
        return status;
    }

    public Date getFormattedDate() {

        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        //dateFormat.parse(date.toString());

        return null;
    }
}
