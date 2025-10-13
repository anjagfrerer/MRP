package service;

import model.User;
import persistence.IUserRepository;

public interface IUserService {
    boolean login(String username, String password);
    boolean registerUser(String username, String password);
}
