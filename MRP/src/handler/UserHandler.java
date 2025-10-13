package handler;

import model.User;
import service.IUserService;
import service.UserService;

public class UserHandler {

    private final IUserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public boolean login(String username, String password) {
        if (validate(username, password)) return false;
        return userService.login(username, password);
    }

    public boolean register(String username, String password) {
        if (validate(username, password)) return false;
        return userService.registerUser(username, password);
    }

    public String generateToken(User user) {
        return user.getUsername() + "-mrpToken";
    }

    private static boolean validate(String username, String password) {
        //validate input parameter
        if (username == null) {
            return true;
        }
        if (password == null) {
            return true;
        }
        return password.isBlank();
    }

    public void editProfile(User user, String username, String password) {

    }

    public void createMediaEntry() {
    }

    public void updateMediaEntry() {
    }

    public void deleteMediaEntry() {
    }

    public void favoriteMediaEntry() {
    }

    public void unFavoriteMediaEntry() {
    }

    public void editRating() {
    }

    public void deleteRating() {
    }

    public void likeRating() {
    }

    public void viewFavorites() {
    }

    public void viewRatings() {
    }

    public void getRecommendations() {
    }
}
