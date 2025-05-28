package Kart.controller.impl;

import Kart.controller.interfaces.ITrackController;
import Kart.model.Track;
import Kart.service.impl.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class TrackController implements ITrackController {
    @Autowired
    private TrackService trackService;

    @Override
    @GetMapping ("/tracks")
    public ResponseEntity<List<Track>> findAllTracks(){
        List<Track> tracks = trackService.findAll();
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }
}
