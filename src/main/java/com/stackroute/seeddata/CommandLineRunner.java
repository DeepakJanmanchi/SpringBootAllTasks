package com.stackroute.seeddata;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private TrackRepository trackRepository;
    @Value("${id}")
    private int id;
    @Value("${name}")
    private String name;
    @Value("${comments}")
    private String comments;
    @Autowired
    public void setTrackRepository(TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Track track = new Track(id, name, comments);
        trackRepository.save(track);
    }
}
