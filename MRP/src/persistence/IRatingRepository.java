package persistence;

import model.Rating;
import model.User;

import java.util.List;

public interface IRatingRepository {
    void likeRating(User user, Rating rating);
    void unlikeRating(User user, Rating rating);
    void editRating(Rating rating, int stars, String comment);
    void deleteRating(Rating rating);
    List<Rating> getRatings();
    void setRatings(List<Rating> ratings);
    void addRating(Rating rating);
}
