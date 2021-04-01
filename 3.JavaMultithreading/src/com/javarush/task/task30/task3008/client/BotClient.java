package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client{

    public class BotSocketThread extends SocketThread{

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {

            ConsoleHelper.writeMessage(message);
            if (message.contains(":")){
                String[] split = message.split(":");
                switch (split[1].trim()) {
                    case "дата" : sendTextMessage("Информация для " + split[0] + ": " + new SimpleDateFormat("d.MM.YYYY").format(Calendar.getInstance().getTime())); break; //отправить сообщение содержащее текущую дату в формате "d.MM.YYYY";
                    case "день" : sendTextMessage("Информация для " + split[0] + ": " + new SimpleDateFormat("d").format(Calendar.getInstance().getTime())); break;// в формате "d";
                    case "месяц": sendTextMessage("Информация для " + split[0] + ": " + new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime())); break;// "MMMM";
                    case "год" : sendTextMessage("Информация для " + split[0] + ": " + new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime())); break;//"YYYY";
                    case "время" : sendTextMessage("Информация для " + split[0] + ": " + new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime())); break;//"H:mm:ss";
                    case "час" : sendTextMessage("Информация для " + split[0] + ": " + new SimpleDateFormat("H").format(Calendar.getInstance().getTime())); break;//"H";
                    case "минуты" : sendTextMessage("Информация для " + split[0] + ": " + new SimpleDateFormat("m").format(Calendar.getInstance().getTime())); break;//"m";
                    case "секунды" : sendTextMessage("Информация для " + split[0] + ": " + new SimpleDateFormat("s").format(Calendar.getInstance().getTime())); break;//"s"
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() throws IOException {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
