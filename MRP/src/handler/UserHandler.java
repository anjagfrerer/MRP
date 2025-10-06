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
        if (password.isEmpty() || username.isEmpty()) {
            return false;
        }
        return userService.login(username, password);
    }

    public void register(String username, String password) {
        if (!username.isBlank() && !password.isBlank()) {
            userService.registerUser(username, password);
        }
    }

    public String generateToken(User user) {
        return user.getUsername() + "-mrpToken";
    }

    public void viewProfile(User user) {
        userService.output(user);
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
