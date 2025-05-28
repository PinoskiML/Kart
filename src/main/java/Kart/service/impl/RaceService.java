package Kart.service.impl;


import Kart.model.Race;
import Kart.repository.RaceRepository;
import Kart.service.interfaces.IRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService implements IRaceService {
    @Autowired
    RaceRepository raceRepository;

    @Override
    public List<Race> findAllRaces() {
        return raceRepository.findAll();
    }
}
