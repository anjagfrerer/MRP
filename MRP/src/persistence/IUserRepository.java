package persistence;

import model.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserRepository {
    public void login(String username, String password);
    public List<User> getAllUsers();
    public void register(String username, String password);
}
