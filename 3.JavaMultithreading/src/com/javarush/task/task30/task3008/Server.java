package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String user_name = "";
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Please, enter user name"));

                Message answer = connection.receive();
                if (answer.getType() == MessageType.USER_NAME) {
                    user_name = answer.getData();
                    if (user_name != null && user_name.length() > 0 && !connectionMap.containsKey(user_name)) {
                        connectionMap.put(user_name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED, "User name accepted"));
                        break;
                    }
                }
            }


            return user_name;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> m : connectionMap.entrySet()) {
                if (!m.getKey().equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, m.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));

                if (message.getType() != MessageType.TEXT) ConsoleHelper.writeMessage("Message type error");

            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Connection with " + socket.getRemoteSocketAddress() + " established...");
            //Connection connection = null;
            String user_name = null;

            try (Connection connection = new Connection(socket)){

                user_name = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, user_name));
                notifyUsers(connection, user_name);
                serverMainLoop(connection, user_name);

                if (user_name != null) {
                    connectionMap.remove(user_name);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, user_name));
                }
                ConsoleHelper.writeMessage("Connection with " + socket.getRemoteSocketAddress() + "closed...");

            } catch (IOException | ClassNotFoundException e) {
                //e.printStackTrace();
                ConsoleHelper.writeMessage("Error connection with " + socket.getRemoteSocketAddress() + "");

            }
        }
    }


        public static void sendBroadcastMessage(Message message) {
            for (Map.Entry<String, Connection> m : connectionMap.entrySet()) {
                try {
                    m.getValue().send(message);
                } catch (IOException e) {
                    System.out.println("Message send failed!");
                }
            }
        }

        public static void main(String[] args) {
            ServerSocket serverSocket = null;

            try {
                serverSocket = new ServerSocket(ConsoleHelper.readInt());
            } catch (IOException e) {
                e.printStackTrace();
            }

            ConsoleHelper.writeMessage("Server started...");

            try {
                while (true) {
                    Socket socket = serverSocket.accept();
                    new Handler(socket).start();
                }
            } catch (IOException e) {
                try {
                    serverSocket.close();
                } catch (IOException e1) {
                    System.out.println("Connection error");
                }
            }


        }

    }


