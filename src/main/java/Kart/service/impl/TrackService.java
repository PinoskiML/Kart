package Kart.service.impl;

import Kart.model.Track;
import Kart.repository.TrackRepository;
import Kart.service.interfaces.ITrackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService implements ITrackService {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public List<Track> findAll(){

        return trackRepository.findAll();
    }

    public Track getTrackById(Integer id) {
        Optional<Track> trackOptional = trackRepository.findById(id);
        if (trackOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Track: " + id + "not found" );
        return trackOptional.get();
    }


    public Track newTrack( Track track) {
        return trackRepository.save(track);
    }

    @Override
    public void deleteTrack(Integer id) {
        if (!trackRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't delete, there is no track with Id: " + id);
        }
        //Delete needs to check if data on field is referenced,  cant delete if field is needed.
        try {
                 trackRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
                     throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Cannot delete track with ID " + id + " because it is used by one or more races. ");
        }
    }
}
