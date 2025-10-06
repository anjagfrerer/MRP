package service;

import model.MediaEntry;
import model.Rating;
import model.User;

public interface IRatingService {
    void likeRating(User user, int ratingID);
    void unlikeRating(User user, int ratingID);
    void editRating(int ratingID, int stars, String comment);
    void deleteRating(int ratingID);
    void addRating(User user, int stars, String comment, MediaEntry mediaEntry);
}
