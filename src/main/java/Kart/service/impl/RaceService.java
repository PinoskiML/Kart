package Kart.service.impl;


import Kart.model.Race;
import Kart.model.RaceDetail;
import Kart.model.Track;
import Kart.repository.RaceDetailRepository;
import Kart.repository.RaceRepository;
import Kart.service.interfaces.IRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService implements IRaceService {
    @Autowired
    RaceRepository raceRepository;

    @Autowired
    RaceDetailRepository raceDetailRepository;

    @Override
    public List<Race> findAllRaces() {
        return raceRepository.findAll();
    }

    @Override
    public Race newRace(Race race) {
        return raceRepository.save(race);



        /*public Track newTrack( Track track) {
            return trackRepository.save(track);
        }*/
    }

//diag

}
