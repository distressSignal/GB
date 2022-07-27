package Mod02.HomeWork07;

import Mod02.HomeWork07.server.MyServer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ServerApp {
    public static final int DEFAULT_PORT = 8876;
    private static String configFile = "src/Mod02/resources/config/aplication-dev.properties";


    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(configFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int port;
        try {
            port = Integer.parseInt(properties.getProperty("server.port"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            port = DEFAULT_PORT;
        }
        try {
            new MyServer(DEFAULT_PORT).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
