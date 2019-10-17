package com.stackroute.seeddata;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class StartupApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent>
{
    private TrackRepository trackRepository;
    @Autowired
    public void setTrackRepository(TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }
    @Value("${id1}")
    private int id1;
    @Value("${name1}")
    private String name1;
    @Value("${comments1}")
    private String comments1;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track = new Track(id1, name1, comments1);
        trackRepository.save(track);

    }
}