package Kart.service.impl;

import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import Kart.model.Track;
import Kart.repository.CompetitorRepository;
import Kart.service.interfaces.ICompetitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
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
    public Competitor newCompetitor(Competitor competitor){
        return competitorRepository.save(competitor);
    }

    //@PatchMapping("/competitors/update/{")

    //delete

    @Override
    public void deleteCompetitor(Integer id){

        if (!competitorRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't delete, there is no competitor with Id: " +id );
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
