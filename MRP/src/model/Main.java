package model;

import handler.MediaEntryHandler;
import handler.RatingHandler;
import handler.UserHandler;
import persistence.*;
import service.MediaEntryService;
import service.RatingService;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        // User Setup
        IUserRepository userRepository = UserRepository.getInstance();
        UserService userservice = UserService.getInstance(userRepository);
        UserHandler userHandler = new UserHandler(userservice);

        // MediaEntry Setup
        MediaEntryRepository mediaEntryRepository = MediaEntryRepository.getInstance();
        MediaEntryService mediaEntryService = MediaEntryService.getInstance(mediaEntryRepository);
        MediaEntryHandler mediaEntryHandler = new MediaEntryHandler(mediaEntryService);

        // Rating Setup
        RatingRepository ratingRepository = RatingRepository.getInstance();
        RatingService ratingService = RatingService.getInstance(ratingRepository);
        RatingHandler ratingHandler = new RatingHandler(ratingService);

        // Log-In und Registrierung testen
        User admin = new User(UUID.randomUUID().toString(), "admin", "HelloWorld");
        userHandler.register("admin", "HelloWorld");
        boolean loggedIn = userservice.login("admin", "HelloWorld");
        System.out.println(loggedIn);

        // Add Media Entry
        MediaEntry harrypotter1 = new MediaEntry("Harry Potter & der Stein der Weisen", "Der erste HP Teil.", "Film", List.of("Fantasy", "Family"), 2001, 8, admin);
        MediaEntry harrypotter2 = new MediaEntry("Harry Potter & die Kammer des Schreckens", "Der zweite HP Teil.", "Film", List.of("Fantasy", "Family"), 2002, 8, admin);
        mediaEntryHandler.addMediaEntry(harrypotter1);
        mediaEntryHandler.addMediaEntry(harrypotter2);
        for(MediaEntry mediaEntry : mediaEntryRepository.getALlMediaEntries()) {
            System.out.println(mediaEntry.getTitle());
        }

        // Remove Media Entry
        mediaEntryHandler.deleteMediaEntry("Harry Potter & der Stein der Weisen", "Film"); //!
        for(MediaEntry mediaEntry : mediaEntryRepository.getALlMediaEntries()) {
            System.out.println(mediaEntry.getTitle());
        }

        // Ratings
        ratingHandler.addRating(admin, 5, "My childhood", harrypotter1);
        for(Rating rating : ratingRepository.getRatings()) {
            System.out.println("\nTitle: " + rating.getMediaEntry().getTitle() + "\nRating: " + rating.getStars() + " Stars\nComment: " + rating.getComment() + "\nPosted: " + rating.getLocalDate());
        }

    }
}