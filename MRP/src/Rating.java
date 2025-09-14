import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rating {

    private MediaEntry mediaEntry;
    private int stars;
    private String comment;
    private User creator;
    private LocalDate localDate;
    private List<User> likes = new ArrayList<>();

    public Rating(MediaEntry mediaEntry, int stars, String comment, User creator) {
        this.mediaEntry = mediaEntry;
        this.stars = stars;
        this.comment = comment;
        this.creator = creator;
        this.localDate = LocalDate.now();
    }

    public void likeRating(User user) {
       this.likes.add(user);
    }
    public void unlikeRating(User user) {
        this.likes.remove(user);
    }
    public void editRating(MediaEntry mediaEntry, int stars, String comment, User creator) {
        if(this.creator.equals(creator)) {
            this.mediaEntry = mediaEntry;
            this.stars = stars;
            this.comment = comment;
            //this.localDate = LocalDate.now();
        }
    }
    public void deleteMediaEntry(User user) {
        if(this.creator.equals(creator)) {
            //delete Rating
        }
    }

}
