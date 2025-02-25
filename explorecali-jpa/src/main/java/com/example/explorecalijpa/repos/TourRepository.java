package com.example.explorecalijpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.explorecalijpa.models.Tour;
import com.example.explorecalijpa.models.Difficulty;
import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Integer> {
  List<Tour> findByDifficulty(Difficulty diff);

  List<Tour> findByTourPackageCode(String code);
}