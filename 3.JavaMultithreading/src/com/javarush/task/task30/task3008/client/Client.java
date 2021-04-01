package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    protected Connection connection;

    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread{

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("User " + userName + " connected");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("User " + userName + " exit");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;

            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType()==MessageType.NAME_REQUEST){
                    connection.send(new Message(MessageType.USER_NAME,getUserName()));
                }
                else if (message.getType()==MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                    processIncomingMessage(message.getData());
                else if (message.getType() == MessageType.USER_ADDED)
                    informAboutAddingNewUser(message.getData());
                    else if (message.getType() == MessageType.USER_REMOVED)
                        informAboutDeletingNewUser(message.getData());
                else throw new IOException("Unexpected MessageType");
            }
        }

        @Override
        public void run() {
            try {
               connection = new Connection(new Socket(getServerAddress(), getServerPort()));
               clientHandshake();
               clientMainLoop();
            }
            catch (IOException | ClassNotFoundException e){
                notifyConnectionStatusChanged(false);
            }

        }
    }

    protected String getServerAddress() throws IOException {

        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException{


        return ConsoleHelper.readInt();
    }

    protected String getUserName() throws IOException{


        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){

    return true;}

    protected SocketThread getSocketThread(){

        return new SocketThread();
    }

    protected void sendTextMessage(String text) {

        try {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e){
            clientConnected = false;
            System.out.println("Send message error!");
        }
    }

    public void run(){
        SocketThread s_thread = getSocketThread();
        s_thread.setDaemon(true);
        s_thread.start();

        try {
            synchronized (this) {
             this.wait();
            }
        }
        catch (InterruptedException e){
            System.out.println("Connecting error!");
            return;
        }

        if (clientConnected) System.out.println("Соединение установлено.\n" +
                "Для выхода наберите команду 'exit'.");
        else System.out.println("Произошла ошибка во время работы клиента.");

        while (clientConnected){
            String s1 = ConsoleHelper.readString();
            if (s1.equals("exit")) break;
            if (shouldSendTextFromConsole()) sendTextMessage(s1);
        }

    }

    public static void main(String[] args) {
        new Client().run();
    }

}
