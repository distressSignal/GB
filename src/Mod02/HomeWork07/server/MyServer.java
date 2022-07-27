package Mod02.HomeWork07.server;

import Mod02.HomeWork07.server.hendlers.ClientHandler;
import Mod02.HomeWork07.server.services.AuthenticationService;
import Mod02.HomeWork07.server.services.imple.SimpleAuthenticationServiceImple;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MyServer {
    private final ServerSocket serverSocket;
    private final AuthenticationService authenticationService;
    private final ArrayList<ClientHandler> clients;

    public MyServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        authenticationService = new SimpleAuthenticationServiceImple();
        clients = new ArrayList<>();
    }

    public void start() {
        System.out.println("Сервер запущен");
        System.out.println("--------------");

        while (true) {
            try {
                waitAndProcessNewConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void waitAndProcessNewConnection() throws IOException {
        System.out.println("Ожидание клиента.....");
        Socket socket = serverSocket.accept();
        System.out.println("Клиент подключился");

        processClientConnection(socket);
    }

    private void processClientConnection(Socket socket) throws IOException {
        ClientHandler handler = new ClientHandler(this, socket);
        handler.handle();
    }

    public synchronized void subscribe(ClientHandler handler) {
        clients.add(handler);
    }

    public synchronized void unSubscribe(ClientHandler handler) {
        clients.remove(handler);
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public boolean isUsernameBusy(String username) {
        for (ClientHandler client : clients) {
            if (client.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void stop() {
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("Завершение работы!");
        System.exit(0);
    }

    public void broadcastMessage(ClientHandler sender, String message) throws IOException {
        for (ClientHandler client : clients) {
            if (client == sender) {
                continue;
            }
            client.sendMessage(sender.getUsername(), message);
        }
    }

    public void privateMessages(ClientHandler sender, String message) throws IOException {
        String nik = message.split("\\s+")[1];
        int a = message.indexOf(nik);
        String result = message.substring(a + nik.length()).trim();

        for (ClientHandler client : clients) {
            if (client.getUsername().equals(nik)) {

                client.PrivateSendMessage(sender.getUsername(),result);

            }
        }


    }
}
