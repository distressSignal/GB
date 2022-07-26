package Mod02.HW07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int SERVER_PORT = 8444;
    private static DataInputStream in;
    private static DataOutputStream out;
    private static Socket clientSocket;


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            Scanner sc2 = new Scanner(System.in);
            while (true) {

                System.out.println("ожидание подключения....");
                clientSocket = serverSocket.accept();
                System.out.println("Подключение установленно");

                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                Thread t = new Thread(() -> {

                    try {
                        while (true) {
                            String string = sc2.nextLine();
                            out.writeUTF("Консоль: " + string.toUpperCase());
                            System.out.println("Консоль: "+string);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                synchronized (t) {
                    t.setDaemon(true);
                    t.start();
                }
                try {
                    while (true) {

                        String message = in.readUTF();

                        if (message.equals("/stop")) {
                            System.out.println("Сервер остановлен");
                            System.exit(0);
                        }
                        out.writeUTF( "Я: "+message.toUpperCase());
                        System.out.println("Клиент: " + message);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

