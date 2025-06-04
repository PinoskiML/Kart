package Kart.service.interfaces;

import Kart.model.Competitor;
import Kart.model.Track;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface
ITrackService {
  List<Track> findAll();
  Track getTrackById(Integer id);
  Track newTrack(Track track);
  void deleteTrack(Integer id);


}
