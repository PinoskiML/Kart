package Kart.service.interfaces;

import Kart.model.RaceDetail;

import java.util.List;

public interface IRaceDetailService {

    List<RaceDetail> findAllRaceDetails();

    RaceDetail findRaceDetailsById(Integer id);


    void updateRaceDetailUnlucky( Integer totalRaces, Integer id);

}
