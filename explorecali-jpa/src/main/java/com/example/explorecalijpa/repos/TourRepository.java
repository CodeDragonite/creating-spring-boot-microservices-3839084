package com.example.explorecalijpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.explorecalijpa.models.Tour;

public interface TourRepository extends JpaRepository<Tour, Integer> {

}