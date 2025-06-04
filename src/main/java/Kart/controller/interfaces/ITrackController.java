package Kart.controller.interfaces;

import Kart.controller.dto.TrackDTO;
import Kart.model.Track;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ITrackController {
    ResponseEntity<List<TrackDTO>> findAllTracks();
    Track newTrack(Track track);
    void deleteTrack(Integer id);
}
