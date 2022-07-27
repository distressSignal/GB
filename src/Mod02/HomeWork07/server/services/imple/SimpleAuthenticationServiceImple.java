package Mod02.HomeWork07.server.services.imple;

import Mod02.HomeWork07.server.models.User;
import Mod02.HomeWork07.server.services.AuthenticationService;

import java.util.List;

public class SimpleAuthenticationServiceImple implements AuthenticationService {

    private static final List<User> clients = List.of(
            new User("a","1","a"),
            new User("b","2","b"),
            new User("c","3","c"),
            new User("mario","4444","Super_Mario"),
            new User("bender","5555","Bender")
    );

    @Override
    public String getUsernameByLoginSndPassword(String login, String password) {
        for (User client : clients) {
            if (client.getLogin().equals(login)
                    && client.getPassword().equals(password)){
                return client.getUsername();
            }
        }
        return null;
    }
}
