package Kart.service.interfaces;


import Kart.model.Race;
import Kart.repository.RaceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRaceService {
    List<Race> findAllRaces();

    Race newRace(Race race);

    //ins method sigs

}
