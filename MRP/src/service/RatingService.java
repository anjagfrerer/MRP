package service;

import model.MediaEntry;
import model.Rating;
import model.User;
import persistence.IRatingRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class RatingService implements IRatingService{
    private static RatingService instance;
    private IRatingRepository ratingRepository;

    private RatingService(IRatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    public static RatingService getInstance(IRatingRepository ratingRepository){
        if(instance == null) instance = new RatingService(ratingRepository);
        return instance;
    }

    @Override
    public void likeRating(User user, int ratingID) {
        List<Rating> allRatings = this.ratingRepository.getRatings();
        for(Rating rating : allRatings){
            if(rating.getId() == ratingID){
                this.ratingRepository.likeRating(user, rating);
            }
        }
    }

    @Override
    public void unlikeRating(User user, int ratingID) {
        List<Rating> allRatings = this.ratingRepository.getRatings();
        for(Rating rating : allRatings){
            if(rating.getId() == ratingID){
                this.ratingRepository.unlikeRating(user, rating);
            }
        }
    }

    @Override
    public void editRating(int ratingID, int stars, String comment) {
        List<Rating> allRatings = this.ratingRepository.getRatings();
        for(Rating rating : allRatings){
            if(rating.getId() == ratingID){
                this.ratingRepository.editRating(rating, stars, comment);
            }
        }
    }

    @Override
    public void deleteRating(int ratingID) {
        List<Rating> allRatings = this.ratingRepository.getRatings();
        for(Rating rating : allRatings){
            if(rating.getId() == ratingID){
                this.ratingRepository.deleteRating(rating);
            }
        }
    }

    @Override
    public void addRating(User user, int stars, String comment, MediaEntry mediaEntry) {
        Rating rating = new Rating(mediaEntry, stars, comment, user);
        rating.setLocalDate(LocalDateTime.now());
        this.ratingRepository.addRating(rating);
    }


}
