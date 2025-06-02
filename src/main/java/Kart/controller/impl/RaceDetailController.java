package Kart.controller.impl;


import Kart.model.RaceDetail;
import Kart.service.interfaces.IRaceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceDetailController implements IRaceDetailService{
    @Autowired
    IRaceDetailService iRaceDetailService;
    @Autowired


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



}
