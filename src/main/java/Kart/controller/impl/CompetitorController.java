package Kart.controller.impl;

import Kart.controller.dto.CompetitorTotalRacesDTO;
import Kart.controller.interfaces.ICompetitorController;
import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import Kart.model.Track;
import Kart.service.interfaces.ICompetitorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompetitorController implements ICompetitorController {
    @Autowired
    ICompetitorService competitorService;

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/competitors")
    public List<Competitor> findAllCompetitors(){
        return competitorService.findAllCompetitors();
    }

    // Find noobs
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/competitors/noobs")
    public List<Competitor> findCompetitorsByTotalRacesLessThan(@RequestParam(defaultValue = "10") Integer totalRaces){
        return competitorService.findCompetitorsByTotalRacesLessThan(totalRaces);

    }
    @GetMapping("competitors/{id}")
    public Competitor findCompetitorById(@PathVariable Integer id){
        return  competitorService.findCompetitorByid(id);

    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/competitors/class/{competitorClass}")
    public List<Competitor> findAllByCompetitorClass(@PathVariable CompetitorClass competitorClass){
        return  competitorService.findAllByCompetitorClass(competitorClass);

    }

    @PostMapping("/competitors/")
    @ResponseStatus(HttpStatus.CREATED)
    public Competitor newCompetitor(@RequestBody @Valid Competitor competitor){
        return competitorService.newCompetitor(competitor);
    }

    // /patch
    @PatchMapping("/competitors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompetitorTotalRaces(@RequestBody @Valid CompetitorTotalRacesDTO competitorTotalRacesDTO, @PathVariable Integer id){
        competitorService.updateCompetitorTotalRaces(competitorTotalRacesDTO.getTotalRaces(), id);
    }




    /*@PutMapping("/competitors/{id}")
    public Competitor updateCompetitor(@RequestBody @Valid Competitor competitor, @PathVariable Integer id){
        return competitorService.updateCompetitor(competitor, id);
    }*/
    @PutMapping("/competitors/{id}")
    public ResponseEntity<Competitor> updateCompetitor(@PathVariable Integer id, @RequestBody Competitor competitor) {
        // Ensure ID is set correctly before passing to service
        competitor.setId(id);
        Competitor updated = competitorService.updateCompetitor(competitor, id);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }



    //deleteMapping
    @DeleteMapping("/competitors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompetitor(@PathVariable Integer id) {
        competitorService.deleteCompetitor(id);
    }


    }


