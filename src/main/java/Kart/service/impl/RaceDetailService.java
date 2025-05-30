package Kart.service.impl;


import Kart.model.RaceDetail;
import Kart.repository.RaceDetailRepository;
import Kart.repository.RaceRepository;
import Kart.service.interfaces.IRaceDetailService;
import Kart.service.interfaces.IRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceDetailService implements IRaceDetailService {
    @Autowired
    RaceDetailRepository raceDetailRepository;

    @Override
    public List<RaceDetail> findAllRaceDetails() {
        return raceDetailRepository.findAll();
    }



}
