package service;

import model.User;
import persistence.IUserRepository;
import persistence.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    private static UserService instance;
    private IUserRepository userRepository;

    private UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static UserService getInstance(IUserRepository repository) {
        if (instance == null) instance = new UserService(repository);
        return instance;
    }

    @Override
    public boolean login(String username, String password) {
        List<User> allUsers = userRepository.getAllUsers();
        for (User u : allUsers) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                userRepository.login(username, password);
                return true;
            }
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
        userRepository.register(username, password);
        return true;
    }

    @Override
    public void output(User user) {

    }
}
