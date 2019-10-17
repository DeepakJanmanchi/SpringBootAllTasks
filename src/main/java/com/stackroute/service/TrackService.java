package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFound;

import java.util.List;
import java.util.Optional;

public interface TrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTracks();
    public Track updateComments(Track track);
    public boolean deleteTrack(int trackId);
    public Track getTrackById(int id) throws TrackNotFound;
    public List<Track> getTrackByName(String name);


}
