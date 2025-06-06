package Kart.controller.impl;

import Kart.controller.dto.TrackDTO;
import Kart.controller.interfaces.ITrackController;
import Kart.model.Competitor;
import Kart.model.Track;
import Kart.service.impl.TrackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/api")
public class TrackController implements ITrackController {
    @Autowired
    private TrackService trackService;

    @Override
    @GetMapping("/tracks")
    public ResponseEntity<List<Track>> findAllTracks() {
        List<Track> tracks = trackService.findAll();
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }


    @GetMapping("/tracks/{id}")
    public Track getTrackById(@PathVariable Integer id) {
        return trackService.getTrackById(id);
    }

    @PostMapping("/tracks/")
    @ResponseStatus(HttpStatus.CREATED)
    public Track newTrack(@RequestBody @Valid Track track){
        return trackService.newTrack(track);
    }


    @DeleteMapping("/tracks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrack(@PathVariable Integer id) {
     trackService.deleteTrack(id);
    }

}