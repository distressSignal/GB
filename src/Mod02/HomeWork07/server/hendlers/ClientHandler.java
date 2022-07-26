package Mod02.HomeWork07.server.hendlers;

import Mod02.HomeWork07.server.MyServer;
import Mod02.HomeWork07.server.services.AuthenticationService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private static final String AUTH_CMD_PREFIX = "/auth"; // + login + password
    private static final String AUTHOK_CMD_PREFIX = "/authok"; // + username
    private static final String AUTHERR_CMD_PREFIX = "/autherr"; // + error message
    private static final String CLIENT_MSG_CMD_PREFIX = "/cMsg"; // + msg
    private static final String SERVER_MSG_CMD_PREFIX = "/sMsg"; // + msg
    private static final String PRIVATE_MSG_CMD_PREFIX = "/pm"; // + username + msg
    private static final String STOP_SERVER_CMD_PREFIX = "/stop";
    private static final String END_CLIENT_CMD_PREFIX = "/end";
    private MyServer myServer;


    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;

    public String getUsername() {
        return username;
    }

    public ClientHandler(MyServer myServer, Socket socket) {

        this.myServer = myServer;
        clientSocket = socket;
    }

    public void handle() throws IOException {
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());

        new Thread(() -> {
            try {
                authentication();
                readMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void readMessage() throws IOException {
        while (true) {
            String message = in.readUTF();
            System.out.println("message | " + username + ": " + message);
            String typeMessage = message.split("\\s+")[0];
            switch (typeMessage) {
                case STOP_SERVER_CMD_PREFIX -> myServer.stop();
                case END_CLIENT_CMD_PREFIX -> closeConnection();
                case PRIVATE_MSG_CMD_PREFIX -> {//TODO:
//                    String nik = message.split("\\s+")[1];
//                    int a = message.indexOf(nik);
//                    String result = message.substring(a+nik.length()).trim();
//                    myServer.broadcastMessageTest(this, nik, result);
                    myServer.broadcastMessageTest(this, message);

                }
                default -> myServer.broadcastMessage(this, message);

            }

        }
    }

    private void closeConnection() throws IOException {
        clientSocket.close();
        System.out.println(username + " отключился");

    }

    public void sendMessage(String sender, String message) throws IOException {
        out.writeUTF(String.format("%s %s %s", CLIENT_MSG_CMD_PREFIX, sender, message));
    }
    public void PrivateSendMessage(String sender, String message) throws IOException {
        out.writeUTF( sender +" "+ message);
    }

    private void authentication() throws IOException {
        while (true) {
            String message = in.readUTF();

            if (message.startsWith(AUTH_CMD_PREFIX)) {
                boolean isSuccessAuth = processAuthentication(message);
                if (isSuccessAuth) {
                    break;
                }
            } else {
                out.writeUTF(AUTHERR_CMD_PREFIX + " Неверная команда аутентификации");
                System.out.println("Неверная команда аутентификации");
            }

        }
    }

    private boolean processAuthentication(String message) throws IOException {
        String[] parts = message.split("\\s+");
        if (parts.length != 3) {
            out.writeUTF(AUTHERR_CMD_PREFIX + " Неверная команда аутентификации");
            System.out.println("Неверная команда аутентификации");

            return false;
        }

        String login = parts[1];
        String password = parts[2];

        AuthenticationService auth = myServer.getAuthenticationService();
        username = auth.getUsernameByLoginSndPassword(login, password);

        if (username != null) {
            if (myServer.isUsernameBusy(username)) {
                out.writeUTF(AUTHERR_CMD_PREFIX + " Логин уже используется");
                return false;
            }
            out.writeUTF(AUTHOK_CMD_PREFIX + " " + username);
            myServer.subscribe(this);
            System.out.println("Пользователь " + username + "подключился к чату");
            return true;
        } else {
            out.writeUTF(AUTHERR_CMD_PREFIX + "Неверная комбинация логина и пароля");
            return false;
        }

    }
}