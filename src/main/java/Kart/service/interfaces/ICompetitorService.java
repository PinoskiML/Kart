package Kart.service.interfaces;

import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import jakarta.validation.Valid;

import java.util.List;

public interface ICompetitorService {

    List<Competitor> findAllByCompetitorClass(CompetitorClass competitorClass);
    Competitor newCompetitor( Competitor competitor);
    void deleteCompetitor(Integer id);
    List<Competitor> findAllCompetitors();

    Competitor updateCompetitor(@Valid Competitor competitor, Integer id);
}
