package persistence;

import model.MediaEntry;
import model.User;

import java.util.ArrayList;
import java.util.List;

public interface IMediaEntryRepository {
    public List<MediaEntry> getALlMediaEntries();
    public void addMediaEntry(MediaEntry mediaEntry);
    public void deleteMediaEntry(String mediaTitle, String mediaType);
}
