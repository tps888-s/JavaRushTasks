package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {

        LogParser logParser = new LogParser(Paths.get("c:/test/logs/"));
        System.out.println(logParser.execute("get ip for user = \"Amigo\"" ));
        System.out.println(logParser.execute("get ip for date = \"12.12.2013 03:45:23\" and date between \"11.12.2013 0:00:00\" and \"03.01.2025 23:59:59\""));



        /*
        System.out.println(logParser.getNumberOfUniqueIPs(new Date(), null));
        System.out.println(logParser.getUniqueIPs(new Date(), null));
        System.out.println(logParser.getIPsForUser("Amigo",new Date(), null ));
        System.out.println(logParser.getIPsForEvent(Event.SOLVE_TASK,new Date(), null));
        System.out.println(logParser.getIPsForStatus(Status.OK,new Date(), null));
        System.out.println(logParser.getDoneTaskUsers(null, null));
        System.out.println(logParser.getDoneTaskUsers(null, null, 48));
        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Vasya Pupkin", null, null));
        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null, null));
        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(18,null, null));
         */

    }
}