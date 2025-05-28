package Kart.service.impl;

import Kart.model.Track;
import Kart.repository.TrackRepository;
import Kart.service.interfaces.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackService implements ITrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public List<Track> findAll(){
        return trackRepository.findAll();
    }
}
