package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
    private ArrayList<Entry> entriesList = new ArrayList<>();

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    void getStrings(Path dir, Date after, Date before) {
        int check = checkDate(after, before);

        try {
            if (after != null) after = formatter.parse(formatter.format(after));
            if (before != null) before = formatter.parse(formatter.format(before));

            // получаем список файлов в папке
            List<Path> listFiles = Files.list(dir)
                    .collect(Collectors.toList());

            //читаем каждый файл
            for (Path p : listFiles) {
                if (p.getFileName().toString().endsWith(".log")) {
                    BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(p)));

                    while (true) {
                        String s = reader.readLine();
                        if (s == null) break;
                        String[] splitString = s.split("\t");
                        //проверяем условие по датам
                        Date logDate = formatter.parse(splitString[2]);

                        String ip = splitString[0];
                        String user = splitString[1];
                        Event event = Event.valueOf(splitString[3].split(" ")[0]);
                        int task = 0;
                        if (splitString[3].split(" ").length > 1) task = Integer.parseInt(splitString[3].split(" ")[1]);
                        Status status = Status.valueOf(splitString[4]);

                        switch (check) {
                            case 0:
                                if (logDate.getTime() <= before.getTime()
                                        && logDate.getTime() >= after.getTime())
                                    entriesList.add(new Entry(ip, user, logDate, event, task, status));
                                break;

                            case 1:
                                if (logDate.getTime() <= before.getTime())
                                    entriesList.add(new Entry(ip, user, logDate, event, task, status));
                                break;

                            case 2:
                                if (logDate.getTime() >= after.getTime())
                                    entriesList.add(new Entry(ip, user, logDate, event, task, status));
                                break;

                            case 3:
                                entriesList.add(new Entry(ip, user, logDate, event, task, status));
                        }
                    }
                } else if (Files.isDirectory(p)) getStrings(p, after, before);
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        //получаем ArrayList со всеми строками отфильтрованные по дате

    }

    void getStringsex(Path dir, Date after, Date before) {
        int check = checkDate(after, before);

        try {
            if (after != null) after = formatter.parse(formatter.format(after));
            if (before != null) before = formatter.parse(formatter.format(before));

            // получаем список файлов в папке
            List<Path> listFiles = Files.list(dir)
                    .collect(Collectors.toList());

            //читаем каждый файл
            for (Path p : listFiles) {
                if (p.getFileName().toString().endsWith(".log")) {
                    BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(p)));

                    while (true) {
                        String s = reader.readLine();
                        if (s == null) break;
                        String[] splitString = s.split("\t");
                        //проверяем условие по датам
                        Date logDate = formatter.parse(splitString[2]);

                        String ip = splitString[0];
                        String user = splitString[1];
                        Event event = Event.valueOf(splitString[3].split(" ")[0]);
                        int task = 0;
                        if (splitString[3].split(" ").length > 1) task = Integer.parseInt(splitString[3].split(" ")[1]);
                        Status status = Status.valueOf(splitString[4]);

                        switch (check) {
                            case 0:
                                if (logDate.getTime() < before.getTime()
                                        && logDate.getTime() > after.getTime())
                                    entriesList.add(new Entry(ip, user, logDate, event, task, status));
                                break;

                            case 1:
                                if (logDate.getTime() < before.getTime())
                                    entriesList.add(new Entry(ip, user, logDate, event, task, status));
                                break;

                            case 2:
                                if (logDate.getTime() > after.getTime())
                                    entriesList.add(new Entry(ip, user, logDate, event, task, status));
                                break;

                            case 3:
                                entriesList.add(new Entry(ip, user, logDate, event, task, status));
                        }
                    }
                } else if (Files.isDirectory(p)) getStrings(p, after, before);
            }


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        //получаем ArrayList со всеми строками отфильтрованные по дате

    }

    int checkDate(Date after, Date before) {
        // проверяем как заданы Date
        int check = 0;
        if (after == null) check = 1;
        if (before == null) check = 2;
        if (after == null && before == null) check = 3;

        return check;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {

        Set<String> ipsSet = getUniqueIPs(after, before);

        return ipsSet.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ipsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        ipsSet = entriesList.stream().map(Entry::getIp).collect(Collectors.toSet());

        return ipsSet;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ipsSet;
        getStrings(logDir, after, before);

        ipsSet = entriesList.stream().filter(entry -> entry.getUser().equals(user)).map(Entry::getIp).collect(Collectors.toSet());


        return ipsSet;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ipsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        ipsSet = entriesList.stream().filter(entry -> entry.getEvent().equals(event)).map(Entry::getIp).collect(Collectors.toSet());

        return ipsSet;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ipsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        ipsSet = entriesList.stream().filter(entry -> entry.getStatus().equals(status)).map(Entry::getIp).collect(Collectors.toSet());


        return ipsSet;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> usersSet = new HashSet<>();
        entriesList.clear();
        getStrings(logDir, null, null);

        usersSet = entriesList.stream().map(Entry::getUser).collect(Collectors.toSet());

        return usersSet;
    }


    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> usersSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        usersSet = entriesList.stream().map(Entry::getUser).collect(Collectors.toSet());

        return usersSet.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> usersSet = new HashSet<>();
        entriesList.clear();
        getStrings(logDir, after, before);

        usersSet = entriesList.stream().filter(entry -> entry.getUser().equals(user)).map(Entry::getEvent).collect(Collectors.toSet());

        return usersSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> usersSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        usersSet = entriesList.stream().filter(entry -> entry.getIp().equals(ip)).map(Entry::getUser).collect(Collectors.toSet());

        return usersSet;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> usersSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        usersSet = entriesList.stream().filter(entry -> entry.getEvent().equals(Event.LOGIN)).map(Entry::getUser).collect(Collectors.toSet());

        return usersSet;

    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> usersSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        usersSet = entriesList.stream().filter(entry -> entry.getEvent().equals(Event.DOWNLOAD_PLUGIN)).map(Entry::getUser).collect(Collectors.toSet());

        return usersSet;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> usersSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        usersSet = entriesList.stream().filter(entry -> entry.getEvent().equals(Event.WRITE_MESSAGE)).map(Entry::getUser).collect(Collectors.toSet());

        return usersSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> usersSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        usersSet = entriesList.stream().filter(entry -> entry.getEvent().equals(Event.SOLVE_TASK)).map(Entry::getUser).collect(Collectors.toSet());

        return usersSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> usersSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        usersSet = entriesList.stream()
                    .filter(entry -> entry.getEvent().equals(Event.SOLVE_TASK))
                    .filter(entry -> entry.getTask() == task)
                    .map(Entry::getUser).collect(Collectors.toSet());

        return usersSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> usersSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        usersSet = entriesList.stream()
                .filter(entry -> entry.getEvent().equals(Event.DONE_TASK))
                .map(Entry::getUser).collect(Collectors.toSet());

        return usersSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> usersSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        usersSet = entriesList.stream()
                .filter(entry -> entry.getEvent().equals(Event.DONE_TASK))
                .filter(entry -> entry.getTask() == task)
                .map(Entry::getUser).collect(Collectors.toSet());

        return usersSet;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> datesSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        datesSet = entriesList.stream()
                .filter(entry -> entry.getUser().equals(user))
                .filter(entry -> entry.getEvent().equals(event))
                .map(Entry::getDate).collect(Collectors.toSet());

        return datesSet;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> datesSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        datesSet = entriesList.stream()
                .filter(entry -> entry.getStatus().equals(Status.FAILED))
                .map(Entry::getDate).collect(Collectors.toSet());

        return datesSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> datesSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        datesSet = entriesList.stream()
                .filter(entry -> entry.getStatus().equals(Status.ERROR))
                .map(Entry::getDate).collect(Collectors.toSet());

        return datesSet;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date date = null;
        entriesList.clear();
        getStrings(logDir, after, before);

            Set<Date> dates = entriesList.stream()
                    .filter(entry -> entry.getEvent().equals(Event.LOGIN))
                    .filter(entry -> entry.getUser().equals(user))
                    .map(Entry::getDate).collect(Collectors.toSet());

            if (dates.size() > 0) {
                date = dates.stream()
                        .min(Date::compareTo)
                        .get();
            }

        return date;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date date = null;
        entriesList.clear();
        getStrings(logDir, after, before);

           Set<Date> dates = entriesList.stream()
                   .filter(entry -> entry.getEvent().equals(Event.SOLVE_TASK))
                   .filter(entry -> entry.getUser().equals(user))
                   .filter(entry -> entry.getTask() == task)
                    .map(Entry::getDate).collect(Collectors.toSet());


        if (dates.size() > 0) {
            date = dates.stream()
                    .min(Date::compareTo)
                    .get();
        }

        return date;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date date = null;
        entriesList.clear();
        getStrings(logDir, after, before);

        try {

            date = entriesList.stream()
                    .filter(entry -> entry.getEvent().equals(Event.DONE_TASK))
                    .filter(entry -> entry.getUser().equals(user))
                    .filter(entry -> entry.getTask() == task)
                    .min(Comparator.comparing(Entry::getDate))
                    .map(Entry::getDate).get();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
        }

        return date;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> datesSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        datesSet = entriesList.stream()
                .filter(entry -> entry.getEvent().equals(Event.WRITE_MESSAGE))
                .filter(entry -> entry.getUser().equals(user))
                .map(Entry::getDate).collect(Collectors.toSet());

        return datesSet;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> datesSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        datesSet = entriesList.stream()
                .filter(entry -> entry.getEvent().equals(Event.DOWNLOAD_PLUGIN))
                .filter(entry -> entry.getUser().equals(user))
                .map(Entry::getDate).collect(Collectors.toSet());

        return datesSet;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> eventsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        eventsSet = entriesList.stream()
                    .map(Entry::getEvent).collect(Collectors.toSet());

        return eventsSet.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> eventsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        eventsSet = entriesList.stream()
                .map(Entry::getEvent).collect(Collectors.toSet());

        return eventsSet;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> eventsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        eventsSet = entriesList.stream()
                    .filter(entry -> entry.getIp().equals(ip))
                    .map(Entry::getEvent).collect(Collectors.toSet());

        return eventsSet;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> eventsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        eventsSet = entriesList.stream()
                .filter(entry -> entry.getUser().equals(user))
                .map(Entry::getEvent).collect(Collectors.toSet());

        return eventsSet;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> eventsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        eventsSet = entriesList.stream()
                .filter(entry -> entry.getStatus().equals(Status.FAILED))
                .map(Entry::getEvent).collect(Collectors.toSet());

        return eventsSet;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> eventsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        eventsSet = entriesList.stream()
                .filter(entry -> entry.getStatus().equals(Status.ERROR))
                .map(Entry::getEvent).collect(Collectors.toSet());

        return eventsSet;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        List<Date> eventsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        eventsSet = entriesList.stream()
                .filter(entry -> entry.getEvent().equals(Event.SOLVE_TASK))
                .filter(entry -> entry.getTask() == task)
                .map(Entry::getDate).collect(Collectors.toList());

        return eventsSet.size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        List<Date> eventsSet;
        entriesList.clear();
        getStrings(logDir, after, before);

        eventsSet = entriesList.stream()
                .filter(entry -> entry.getTask() == task)
                .filter(entry -> entry.getEvent().equals(Event.DONE_TASK))
                .map(Entry::getDate).collect(Collectors.toList());

        return eventsSet.size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        entriesList.clear();
        getStrings(logDir, after, before);

        List<Entry> entries = entriesList.stream()
                .filter(entry -> entry.getEvent().equals(Event.SOLVE_TASK))
                .collect(Collectors.toList());

        for (Entry e : entries){
            long count = entries.stream().filter(entry -> entry.getTask() == e.getTask()).count();
            map.put(e.getTask(), (int) count);
        }

        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        entriesList.clear();
        getStrings(logDir, after, before);

        List<Entry> entries = entriesList.stream()
                .filter(entry -> entry.getEvent().equals(Event.DONE_TASK))
                .collect(Collectors.toList());

        for (Entry e : entries){
            long count = entries.stream().filter(entry -> entry.getTask() == e.getTask()).count();
            map.put(e.getTask(), (int) count);
        }

        return map;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> objectSet = null;


        String[] parameters =  query.split(" ");
        String field1 = parameters[1];
        String field2 = null;
        final String value;

        if (query.contains("between")){
            String[] dateParameters =  query.split("and date");
            String dates =  dateParameters[1].replace(" between ","").replace(" and ", "x");

            try {
                //String s1 = dates.split("x")[0].replace("\"", "").replace(" = ", "").trim();
                Date after = formatter.parse(dates.split("x")[0].replace("\"", "").replace(" = ", "").trim());
                Date before = formatter.parse(dates.split("x")[1].replace("\"", "").replace(" = ", "").trim());
                entriesList.clear();
                getStringsex(logDir, after, before);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }

        } else {
            entriesList.clear();
            getStrings(logDir, null, null);
        }


        if (parameters.length >= 6) {
            field2 = parameters[3];
            value = query.split("=")[1].split(" and date ")[0].trim().replace("\"", "");


            switch (field2) {
                case "ip":
                    entriesList = (ArrayList<Entry>) entriesList.stream().filter(entry -> entry.getIp().equals(value)).collect(Collectors.toList());
                    break;
                case "user":
                    entriesList = (ArrayList<Entry>) entriesList.stream().filter(entry -> entry.getUser().equals(value)).collect(Collectors.toList());
                    break;
                case "date":
                    try {

                        Date dateValue = formatter.parse(value);
                        entriesList = (ArrayList<Entry>) entriesList.stream().filter(entry -> entry.getDate().equals(dateValue)).collect(Collectors.toList());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "event":
                    entriesList = (ArrayList<Entry>) entriesList.stream().filter(entry -> entry.getEvent().toString().equals(value)).collect(Collectors.toList());
                    break;
                case "status":
                    entriesList = (ArrayList<Entry>) entriesList.stream().filter(entry -> entry.getStatus().toString().equals(value)).collect(Collectors.toList());
                    break;

            }
        }

            switch (field1) {
                case "ip":
                    objectSet = entriesList.stream().map(Entry::getIp).collect(Collectors.toSet());
                    break;
                case "user":
                    objectSet = entriesList.stream().map(Entry::getUser).collect(Collectors.toSet());
                    break;
                case "date":
                    objectSet = entriesList.stream().map(Entry::getDate).collect(Collectors.toSet());
                    break;
                case "event":
                    objectSet = entriesList.stream().map(Entry::getEvent).collect(Collectors.toSet());
                    break;
                case "status":
                    objectSet = entriesList.stream().map(Entry::getStatus).collect(Collectors.toSet());
                    break;

            }
        return objectSet;
    }
}