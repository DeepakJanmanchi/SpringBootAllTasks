package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFound;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Primary
@Qualifier("trackServiceImpl")
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        Track trackn = trackRepository.save(track);
        if(trackn==null){
            throw new TrackAlreadyExistsException("Track Already Exists");
        }
        return trackn;
    }
    @Override
    public List<Track> getTrackByName(String name)
    {
        List<Track> tList = trackRepository.findBytrackName(name);
        return tList;
    }
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateComments(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public boolean deleteTrack(int trackId) {
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFound
    {

        if(!trackRepository.existsById(id)){
            throw new TrackNotFound("Track Not Found");
        }
        Track tList = trackRepository.findById(id).get();
        if(tList==null){
            throw new TrackNotFound("Track Not Found");
        }


        return tList;
    }
}
