package handler;

import model.MediaEntry;
import model.Rating;
import model.User;
import persistence.IRatingRepository;
import persistence.RatingRepository;
import service.IRatingService;
import service.RatingService;

public class RatingHandler {
    private final IRatingService ratingService;

    public RatingHandler(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    public void likeRating(User user, int ratingID) {
        this.ratingService.likeRating(user, ratingID);
    }

    public void addRating(User user, int stars, String comment, MediaEntry mediaEntry) {
        if(user != null && mediaEntry != null){
            this.ratingService.addRating(user, stars, comment, mediaEntry);
        }
    }

    public void unlikeRating(User user, int ratingID) {
        this.ratingService.unlikeRating(user, ratingID);
    }

    void editRating(int mediaEntryID, int stars, String comment, User creator, int ratingID) {
        if (mediaEntryID != 0 && creator != null && ratingID != 0) {
            // Hier noch checken, ob der User auch wirklich der Creator ist
            this.ratingService.editRating(ratingID, stars, comment);
        }
    }
    void deleteRating(User user, int mediaEntryID) {
        if(user != null && mediaEntryID != 0) {
            // Hier noch checken, ob der User auch wirklich der Creator ist
            this.ratingService.deleteRating(mediaEntryID);
        }
    }
}
