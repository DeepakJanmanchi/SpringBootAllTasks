package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFound;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@PropertySources({
        @PropertySource(value = "classpath:application-prod.properties"),
        @PropertySource(value = "classpath:application.properties")
})
@RestController
@RequestMapping(value="api/v1")
public class TrackController {
    @Autowired
    @Qualifier("trackDummyServiceImpl")
    TrackService trackService;

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException{
    ResponseEntity responseEntity;
    //try{
        trackService.saveTrack(track);
        responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);

   // }catch (TrackAlreadyExistsException ex){
       // responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
    //}
    return responseEntity;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() throws Exception{
        ResponseEntity responseEntity;
       // try{
            responseEntity = new ResponseEntity(trackService.getAllTracks(), HttpStatus.CREATED);
        //}catch (Exception ex) {
            //responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        //}
        return responseEntity;
    }
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFound{
        ResponseEntity responseEntity;

       // try{
            responseEntity = new ResponseEntity<Track>(trackService.getTrackById(id), HttpStatus.CREATED);
       // }catch (TrackNotFound ex) {
        //    responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
       // }
        return responseEntity;
    }
    @GetMapping("track/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable String name){
        ResponseEntity responseEntity;

        try{
            responseEntity = new ResponseEntity<List<Track>>(trackService.getTrackByName(name), HttpStatus.FOUND);
        }catch (Exception ex) {
            responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id) throws Exception{
        ResponseEntity responseEntity;
        //try{
            trackService.deleteTrack(id);
            responseEntity = new ResponseEntity(trackService.getAllTracks(), HttpStatus.CREATED);
        //}catch (Exception ex) {
         //   responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        //}
        return responseEntity;

    }







}
