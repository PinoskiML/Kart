package Kart.service.interfaces;


import Kart.controller.dto.NewRaceDTO;
import Kart.model.Race;
import Kart.repository.RaceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRaceService {
    List<Race> findAllRaces();

    Race newRace(Race race);
    Race newRace(NewRaceDTO newRaceDTO);

    Race getRaceById(Integer id);
    void deleteRace(Integer id);



}
