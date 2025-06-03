package Kart.service.impl;


import Kart.controller.dto.RaceDetailDTO;
import Kart.model.Competitor;
import Kart.model.Race;
import Kart.model.RaceDetail;
import Kart.model.Track;
import Kart.repository.CompetitorRepository;
import Kart.repository.RaceDetailRepository;
import Kart.repository.RaceRepository;
import Kart.service.interfaces.IRaceDetailService;
import Kart.service.interfaces.IRaceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RaceDetailService implements IRaceDetailService {
    @Autowired
    RaceDetailRepository raceDetailRepository;
    @Autowired
    CompetitorRepository competitorRepository;

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

    @Override
    public void updateRaceDetailUnlucky(Integer unlucky, Integer id) {
        RaceDetail raceDetail = raceDetailRepository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Race detail with id: " + id +" not found."));

        Competitor unluckyCompetitor = competitorRepository.findById(unlucky)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Competitor with id: " + unlucky + " not found"));

        raceDetail.setUnlucky(unluckyCompetitor);
        raceDetailRepository.save(raceDetail);
    }
}
