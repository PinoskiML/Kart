package Kart.service.impl;


import Kart.controller.dto.NewRaceDTO;

import Kart.controller.dto.RaceDetailDTO;
import Kart.model.Competitor;
import Kart.model.Race;
import Kart.model.RaceDetail;
import Kart.model.Track;
import Kart.repository.CompetitorRepository;
import Kart.repository.RaceDetailRepository;
import Kart.repository.RaceRepository;
import Kart.repository.TrackRepository;
import Kart.service.interfaces.IRaceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RaceService implements IRaceService {
    @Autowired
    RaceRepository raceRepository;

    @Autowired
    RaceDetailRepository raceDetailRepository;

    @Autowired
    TrackRepository trackRepository;

    @Autowired
    CompetitorRepository competitorRepository;


    @Override
    public List<Race> findAllRaces() {
        return raceRepository.findAll();
    }

    @Override
    public Race newRace(Race race) {
        return raceRepository.save(race);

    }

    @Override
    public Race getRaceById(Integer id) {
        if(!raceRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find race with Id: " + id);
        }
        return raceRepository.findById(id).get();
    }

    @Override
    public void deleteRace(Integer id) {

        if (!raceRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't delete, there is no race with Id: " +id );
        }
        raceRepository.deleteById(id);


    }

    @Transactional
    @Override
    public Race newRace(NewRaceDTO newRaceDTO) {

        RaceDetail raceDetail = new RaceDetail();
        raceDetail.setRaceTimeSlot(newRaceDTO.getRaceDetail().getRaceTimeSlot());
        raceDetail.setRaceWeather(newRaceDTO.getRaceDetail().getRaceWeather());
        raceDetail.setAttendance(newRaceDTO.getRaceDetail().getAttendance());


        Competitor unlucky = competitorRepository.findById(newRaceDTO.getRaceDetail().getUnlucky())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unlucky not found"));
        Competitor fanFavorite = competitorRepository.findById(newRaceDTO.getRaceDetail().getFanFavorite())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fan favorite not found"));
        Track track = trackRepository.findById(newRaceDTO.getTrackId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Track not found"));


        raceDetail.setUnlucky(unlucky);
        raceDetail.setFanFavorite(fanFavorite);


        Race race = new Race();
        race.setName(newRaceDTO.getName());
        race.setRaceDate(newRaceDTO.getRaceDate());
        race.setRaceType(newRaceDTO.getRaceType());
        race.setNumberOfLaps(newRaceDTO.getNumberOfLaps());
        race.setTrack(track);
        race.setRaceDetail(raceDetail);

        return raceRepository.save(race);
    }



}