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

    public void likeRating(User user, String ratingID) {
        this.ratingService.likeRating(user, ratingID);
    }

    public void addRating(User user, int stars, String comment, MediaEntry mediaEntry) {
        if(user != null && mediaEntry != null){
            this.ratingService.addRating(user, stars, comment, mediaEntry);
        }
    }

    public void unlikeRating(User user, String ratingID) {
        this.ratingService.unlikeRating(user, ratingID);
    }

    void editRating(String mediaEntryID, int stars, String comment, User creator, String ratingID) {
        if (!mediaEntryID.isBlank() && creator != null && !ratingID.isBlank()) {
            // Hier noch checken, ob der User auch wirklich der Creator ist
            this.ratingService.editRating(ratingID, stars, comment);
        }
    }
    void deleteRating(User user, String mediaEntryID) {
        if(user != null && !mediaEntryID.isBlank()) {
            // Hier noch checken, ob der User auch wirklich der Creator ist
            this.ratingService.deleteRating(mediaEntryID);
        }
    }
}
