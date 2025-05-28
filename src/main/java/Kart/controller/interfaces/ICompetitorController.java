package Kart.controller.interfaces;

import Kart.model.Competitor;
import Kart.model.CompetitorClass;

import java.util.List;

public interface ICompetitorController {
    List<Competitor> findAllByCompetitorClass(CompetitorClass competitorClass);
    Competitor newCompetitor(Competitor competitor);
    void deleteCompetitor(Integer id);
    List<Competitor> findAllCompetitors();
}
