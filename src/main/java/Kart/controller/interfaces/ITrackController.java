package Kart.controller.interfaces;

import Kart.model.Track;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITrackController {
    ResponseEntity<List<Track>> findAllTracks();
}
