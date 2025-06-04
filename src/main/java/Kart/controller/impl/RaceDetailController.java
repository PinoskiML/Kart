package Kart.controller.impl;


import Kart.controller.dto.CompetitorTotalRacesDTO;
import Kart.controller.dto.RaceDetailDTO;
import Kart.controller.dto.RaceDetailUnluckyDTO;
import Kart.controller.interfaces.IRaceDetailController;
import Kart.model.Competitor;
import Kart.model.RaceDetail;
import Kart.service.impl.RaceDetailService;
import Kart.service.interfaces.IRaceDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceDetailController implements IRaceDetailController {
    @Autowired
    IRaceDetailService iRaceDetailService;
    //@Autowired


    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/details")
    public List<RaceDetail> findAllRaceDetails(){
          return iRaceDetailService.findAllRaceDetails();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/details/{id}")
    public RaceDetail findRaceDetailsById(@PathVariable Integer id){
        return iRaceDetailService.findRaceDetailsById(id);
    }

    @Override
    @PatchMapping("/details/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRaceDetailUnlucky(@RequestBody @Valid RaceDetailUnluckyDTO raceDetailUnluckyDTO, @PathVariable Integer id) {
        iRaceDetailService.updateRaceDetailUnlucky(raceDetailUnluckyDTO.getUnlucky(), id);
    }






}
