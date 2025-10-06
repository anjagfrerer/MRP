package service;

import model.MediaEntry;
import model.User;

import java.util.List;

public interface IMediaEntryService {

    void addMediaEntry(MediaEntry mediaEntry);
    void editMediaEntry(int mediaEntryId, String title, String description, String mediatype, List<String> genres, int releaseYear, int agerestriction, User creator);
    void deleteMediaEntry(String mediaTitle, String mediaType);
    void favoriteMediaEntry(int mediaEntryId);
    void unFavoriteMediaEntry(int mediaEntryId);
}
