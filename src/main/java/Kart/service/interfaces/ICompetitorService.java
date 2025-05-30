package Kart.service.interfaces;

import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public interface ICompetitorService {

    List<Competitor> findAllByCompetitorClass(CompetitorClass competitorClass);
    Competitor newCompetitor( Competitor competitor);
    void deleteCompetitor(Integer id);
    List<Competitor> findAllCompetitors();

    Competitor updateCompetitor(Competitor competitor, Integer id);

    void updateCompetitorTotalRaces( Integer totalRaces, Integer id);
}
