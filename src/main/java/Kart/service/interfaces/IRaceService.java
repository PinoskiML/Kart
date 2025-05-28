package Kart.service.interfaces;


import Kart.model.Race;
import Kart.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRaceService {
    List<Race> findAllRaces();

    //ins method sigs

}
