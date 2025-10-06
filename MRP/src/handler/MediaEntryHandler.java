package handler;

import model.MediaEntry;
import model.User;
import service.IMediaEntryService;
import service.MediaEntryService;

import java.util.List;

public class MediaEntryHandler {

    private final IMediaEntryService mediaEntryService;


    public MediaEntryHandler(MediaEntryService mediaEntryService) {
        this.mediaEntryService = mediaEntryService;
    }

    public void addMediaEntry(MediaEntry mediaEntry) {
        if(mediaEntry.getTitle()!=null && !mediaEntry.getGenres().isEmpty() && mediaEntry.getReleaseYear()!=0 && mediaEntry.getAgerestriction()!=0 && mediaEntry.getCreator()!=null) {
            mediaEntryService.addMediaEntry(mediaEntry);
        }
    }

    public void deleteMediaEntry(String title, String mediaType) {
        // Hier checken, wegen Berechtigung
        if(title!=null) {
            mediaEntryService.deleteMediaEntry(title, mediaType);
        }
    }
}
