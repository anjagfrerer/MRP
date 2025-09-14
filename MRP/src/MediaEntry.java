import java.util.ArrayList;
import java.util.List;

public class MediaEntry {

    private String title, description, mediatype;
    private List<String> genres = new ArrayList<>();
    private int releaseYear, agerestriction, avgscore;
    private User creator; // to assign each entry to a user (just creator can delete/edit)
    private List<Rating> ratings = new ArrayList<>();
    private boolean favorite;

    public MediaEntry(String title, String description, String mediatype, List<String> genres, int releaseYear, int agerestriction, User creator) {
        this.title = title;
        this.description = description;
        this.mediatype = mediatype;
        this.releaseYear = releaseYear;
        this.agerestriction = agerestriction;
        this.creator = creator;
    }

    public void editMediaEntry(String title, String description, String mediatype, List<String> genres, int releaseYear, int agerestriction, User creator) {
        this.title = title;
        this.description = description;
        this.mediatype = mediatype;
        this.releaseYear = releaseYear;
        this.agerestriction = agerestriction;
        this.creator = creator;
    }
    public void deleteMediaEntry(User user) {
        // delete from ArrayList ratings
    }
    public void favoriteMediaEntry() {
        this.favorite = true;
    }
    public void unFavoriteMediaEntry() {
        this.favorite = false;
    }

}
