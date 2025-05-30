package Kart.repository;

import Kart.model.RaceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceDetailRepository extends JpaRepository<RaceDetail, Integer> {
}
