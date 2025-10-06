package persistence;

import model.MediaEntry;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class MediaEntryRepository implements IMediaEntryRepository {
    private List<MediaEntry> mediaEntries;
    private static final MediaEntryRepository instance = new MediaEntryRepository();

    private MediaEntryRepository() {
        this.mediaEntries = new ArrayList<>();
    }

    public static MediaEntryRepository getInstance() {
        return instance;
    }

    @Override
    public List<MediaEntry> getALlMediaEntries() {
        return mediaEntries;
    }

    @Override
    public void addMediaEntry(MediaEntry mediaEntry) {
        mediaEntries.add(mediaEntry);
    }

    @Override
    public void deleteMediaEntry(String mediaTitle, String mediaType) {
        mediaEntries.removeIf(entry -> entry.getTitle().equals(mediaTitle) && entry.getMediatype().equals(mediaType));
    }
}
