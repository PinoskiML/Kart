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

    @Override // Keep this annotation
    @GetMapping("/tracks")
    public ResponseEntity<List<TrackDTO>> findAllTracks() { // Change return type to TrackDTO
        List<Track> tracks = trackService.findAll();
        List<TrackDTO> trackDTOs = tracks.stream()
                .map(TrackDTO::fromTrack)
                .collect(Collectors.toList());
        return new ResponseEntity<>(trackDTOs, HttpStatus.OK); // Return DTOs
    }
    // by id

    @GetMapping("/tracks/{id}")
    public Track getTrackById(@PathVariable Integer id) {
        return trackService.getTrackById(id);
    }

    @PostMapping("/tracks/")
    @ResponseStatus(HttpStatus.CREATED)
    public Track newTrack(@RequestBody @Valid Track track){
        return trackService.newTrack(track);
    }

    //  patch

    //  put

    @DeleteMapping("/tracks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrack(@PathVariable Integer id) {
     trackService.deleteTrack(id);
    }

}