package Kart.controller.impl;


import Kart.model.RaceDetail;
import Kart.service.interfaces.IRaceDetailService;
import Kart.service.interfaces.IRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceDetailController {
    @Autowired
    IRaceDetailService iRaceDetailService;

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/details")
    public List<RaceDetail> findAllRaceDetails(){
            return iRaceDetailService.findAllRaceDetails();
    }


}
