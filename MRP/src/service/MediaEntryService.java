package service;

import model.MediaEntry;
import model.User;
import persistence.IMediaEntryRepository;

import java.util.ArrayList;
import java.util.List;

public class MediaEntryService implements IMediaEntryService{
    private static MediaEntryService instance;
    private IMediaEntryRepository mediaEntryRepository;

    public MediaEntryService(IMediaEntryRepository mediaEntryRepository) {
        this.mediaEntryRepository = mediaEntryRepository;
    }

    public static MediaEntryService getInstance(IMediaEntryRepository mediaEntryRepository) {
        if(instance == null){
            instance = new MediaEntryService(mediaEntryRepository);
        }
        return instance;
    }

    @Override
    public void addMediaEntry(MediaEntry mediaEntry) {
        mediaEntryRepository.addMediaEntry(mediaEntry);
    }

    @Override
    public void editMediaEntry(int mediaEntryId, String title, String description, String mediatype, List<String> genres, int releaseYear, int agerestriction, User creator) {
        List<MediaEntry> mediaEntries = mediaEntryRepository.getALlMediaEntries();
        for(MediaEntry mediaEntry : mediaEntries){
            if(mediaEntry.getId() == mediaEntryId){
                // Derzeit noch mit remove und add -> später über Datenbank verändern
                mediaEntryRepository.deleteMediaEntry(title, mediatype);
                mediaEntryRepository.addMediaEntry(new MediaEntry(title, description, mediatype, genres, releaseYear, agerestriction, creator));
            }
        }
    }

    @Override
    public void deleteMediaEntry(String title, String mediaType) {
        List<MediaEntry> mediaEntries = new ArrayList<>(mediaEntryRepository.getALlMediaEntries());
        for (MediaEntry mediaEntry : mediaEntries) {
            if (mediaEntry.getTitle().equals(title) && mediaEntry.getMediatype().equals(mediaType)) {
                mediaEntryRepository.deleteMediaEntry(mediaEntry.getTitle(), mediaEntry.getMediatype());
            }
        }
    }

    @Override
    public void favoriteMediaEntry(int mediaEntryId) {
        List<MediaEntry> mediaEntries = mediaEntryRepository.getALlMediaEntries();
        for(MediaEntry mediaEntry : mediaEntries){
            if(mediaEntry.getId() == mediaEntryId){
                // Derzeit noch mit remove und add -> später über Datenbank verändern
                mediaEntryRepository.deleteMediaEntry(mediaEntry.getTitle(), mediaEntry.getMediatype());
                mediaEntryRepository.addMediaEntry(new MediaEntry(mediaEntry.getTitle(), mediaEntry.getDescription(),
                        mediaEntry.getMediatype(), mediaEntry.getGenres(), mediaEntry.getReleaseYear(), mediaEntry.getAgerestriction(), mediaEntry.getCreator()));
            }
        }
    }

    @Override
    public void unFavoriteMediaEntry(int mediaEntryId) {
        List<MediaEntry> mediaEntries = mediaEntryRepository.getALlMediaEntries();
        for(MediaEntry mediaEntry : mediaEntries){
            if(mediaEntry.getId() == mediaEntryId){
                // Derzeit noch mit remove und add -> später über Datenbank verändern
                mediaEntryRepository.deleteMediaEntry(mediaEntry.getTitle(), mediaEntry.getMediatype());
                mediaEntryRepository.addMediaEntry(new MediaEntry(mediaEntry.getTitle(), mediaEntry.getDescription(),
                        mediaEntry.getMediatype(), mediaEntry.getGenres(), mediaEntry.getReleaseYear(), mediaEntry.getAgerestriction(), mediaEntry.getCreator()));
            }
        }
    }
}
