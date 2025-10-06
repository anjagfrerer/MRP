package persistence;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private List<User> registeredUsers;
    private List<User> loggedInUsers;
    private static final UserRepository instance = new UserRepository();

    private UserRepository() {
        this.registeredUsers = new ArrayList<>();
        this.loggedInUsers = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        return instance;
    }

    @Override
    public void login(String username, String password) {
        loggedInUsers.add(new User(username, password));
    }

    @Override
    public List<User> getAllUsers() {
        return registeredUsers;
    }

    @Override
    public void register(String username, String password) {
        registeredUsers.add(new User(username, password));
    }
}
