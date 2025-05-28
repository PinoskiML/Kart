package Kart.repository;

import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitorRepository extends JpaRepository<Competitor, Integer> {
    List<Competitor> findAllByCompetitorClass(CompetitorClass competitorClass);

}
