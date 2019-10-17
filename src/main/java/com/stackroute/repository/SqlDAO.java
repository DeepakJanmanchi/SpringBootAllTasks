package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlDAO  extends JpaRepository<Track,Integer> {
    // you can use JpaRepository methods out of the box or write custom ones
}