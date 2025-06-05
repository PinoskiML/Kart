package Kart.repository;

import Kart.model.Competitor;
import Kart.model.CompetitorClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompetitorRepositoryTest {
    @Autowired
    CompetitorRepository competitorRepository;

    //List<Competitor> findAllByCompetitorClass(CompetitorClass competitorClass);
    @Test
    public void  findAllByCompetitorClass_C3_allCompetitorsInC3(){
        List<Competitor> competitorList = competitorRepository.findAllByCompetitorClass(CompetitorClass.C3);
        System.out.println("There are: " +competitorList.size() + " competitors in C3 class: " +competitorList);
        assertEquals(8, competitorList.size());

    }

    @Test
    public void competitorExists() {
        Optional<Competitor> optionalCompetitor = competitorRepository.findById(1);
        assertTrue(optionalCompetitor.isPresent());
    }


}
