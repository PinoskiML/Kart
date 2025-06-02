package Kart.service.impl;


import Kart.model.RaceDetail;
import Kart.model.Track;
import Kart.repository.RaceDetailRepository;
import Kart.repository.RaceRepository;
import Kart.service.interfaces.IRaceDetailService;
import Kart.service.interfaces.IRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RaceDetailService implements IRaceDetailService {
    @Autowired
    RaceDetailRepository raceDetailRepository;

    @Override
    public List<RaceDetail> findAllRaceDetails() {
        return raceDetailRepository.findAll();
    }

    @Override
    public RaceDetail findRaceDetailsById(Integer id) {
        Optional<RaceDetail> raceDetailOptional = raceDetailRepository.findById(id);
        if (raceDetailOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Race detail: " +id + " not found.");
        return raceDetailOptional.get();
    }



    /*public Track getTrackById(Integer id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if (trackOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Track: " + id + "not found" );
        return trackOptional.get();
    }*/
}
