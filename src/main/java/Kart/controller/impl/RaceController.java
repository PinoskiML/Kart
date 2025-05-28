package Kart.controller.impl;

import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import Kart.model.Race;
import Kart.service.interfaces.IRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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



}
