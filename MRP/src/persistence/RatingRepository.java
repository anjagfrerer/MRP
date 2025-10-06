package persistence;

import model.Rating;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class RatingRepository implements IRatingRepository {
    private List<Rating> ratings;
    private static RatingRepository instance = new RatingRepository();

    public RatingRepository() {
        ratings = new ArrayList<>();
    }

    public static RatingRepository getInstance() {
        return instance;
    }

    @Override
    public void likeRating(User user, Rating rating) {
        rating.getLikes().add(user);
    }

    @Override
    public void unlikeRating(User user, Rating rating) {
        rating.getLikes().remove(user);
    }

    @Override
    public void editRating(Rating rating, int stars, String comment) {
        rating.setStars(stars);
        rating.setComment(comment);
    }

    @Override
    public void deleteRating(Rating rating) {
        ratings.remove(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratings;
    }

    @Override
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }
}
