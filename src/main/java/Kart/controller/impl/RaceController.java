package Kart.controller.impl;

import Kart.controller.dto.NewRaceDTO;
import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import Kart.model.Race;
import Kart.model.Track;
import Kart.service.interfaces.IRaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RaceController {
    @Autowired
    IRaceService raceService;

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/races")
    public List<Race> findAllRaces(){
        return raceService.findAllRaces();
    }


    @PostMapping("/races")
    public ResponseEntity<Race> createRace(@RequestBody @Valid NewRaceDTO newRaceDTO) {
        Race race = raceService.newRace(newRaceDTO);
        return new ResponseEntity<>(race, HttpStatus.CREATED);
    }
}
