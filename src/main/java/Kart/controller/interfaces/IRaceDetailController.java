package Kart.controller.interfaces;

import Kart.model.RaceDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface IRaceDetailController {
    public List<RaceDetail> findAllRaceDetails();
    public RaceDetail findRaceDetailsById( Integer id);

}
