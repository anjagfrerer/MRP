package service;

import model.User;
import persistence.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private static UserService instance;
    private final List<User> loggedInUsers;
    private IUserRepository userRepository;

    private UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.loggedInUsers = new ArrayList<>();
    }

    public static UserService getInstance(IUserRepository repository) {
        if (instance == null) instance = new UserService(repository);
        return instance;
    }

    @Override
    public boolean login(String username, String password) {
        if (checkPassword(username, password)) {
            User found = userRepository.getUserByUsername(username);
            loggedInUsers.add(found);
            return true;
        }

        return false;
    }

    @Override
    public boolean registerUser(String username, String password) {
        List<User> allUsers = userRepository.getAllUsers();
        for (User u : allUsers) {
            if (u.getUsername().equals(username)) {
                return false;
            }
        }
        userRepository.createUser(username, password);
        return true;
    }

    public boolean checkPassword(String username, String password) {
        User found = userRepository.getUserByUsername(username);
        if (found != null) {
            return found.getPassword().equals(password);
        } else {
            return false;
        }
    }
}
