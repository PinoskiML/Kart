package Kart.service.impl;

import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import Kart.model.RaceDetail;
import Kart.model.Track;
import Kart.repository.CompetitorRepository;
import Kart.service.interfaces.ICompetitorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.CompositeUriComponentsContributor;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitorService implements ICompetitorService {
    @Autowired
    CompetitorRepository competitorRepository;

    @Override
    public List<Competitor> findAllByCompetitorClass( CompetitorClass competitorClass){
        return competitorRepository.findAllByCompetitorClass(competitorClass);
    }

    @Override
    public Competitor findCompetitorByid(Integer id) {
       Optional<Competitor> competitorOptional = competitorRepository.findById(id);
       if (competitorOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Competitor: " + id + "not found.");
        return competitorOptional.get();
    }

    @Override
    public List<Competitor> findCompetitorsByTotalRacesLessThan(Integer totalRaces) {
        return competitorRepository.findAllByTotalRacesLessThan(totalRaces);
    }

    @Override
    public Competitor newCompetitor(Competitor competitor){
        return competitorRepository.save(competitor);
    }

    //@PatchMapping("/competitors/update/{")

    @Override
    public void updateCompetitorTotalRaces(Integer totalRaces, Integer id) {
        Competitor competitor = competitorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("competitor with id: " + id + "not found"));
        competitor.setTotalRaces(totalRaces);
        competitorRepository.save(competitor);
    }


    //delete

    @Override
    public void deleteCompetitor(Integer id){

        if (!competitorRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't delete, there is no competitor with Id: " +id );
        }
        //foreugn key issues
        try {
            // Attempt to delete
            competitorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Cannot delete competitor with ID " + id + " because its a fan favorite or unlucky competitor in race details. " );
        }


        competitorRepository.deleteById(id);

    }

    @Override
    public List<Competitor> findAllCompetitors(){
        return competitorRepository.findAll();
    }


    @Override
    public Competitor updateCompetitor(Competitor competitor, Integer id) {
        Optional<Competitor> competitorOptional = competitorRepository.findById(id);
        if (competitorOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Competitor id: " +id +"not found");
        return (competitorRepository.save(competitor));
    }


}
