package com.example.explorecalijpa.biz;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.explorecalijpa.models.Difficulty;
import com.example.explorecalijpa.models.Region;
import com.example.explorecalijpa.models.Tour;
import com.example.explorecalijpa.models.TourPackage;
import com.example.explorecalijpa.repos.TourPackageRepository;
import com.example.explorecalijpa.repos.TourRepository;

@Service
public class TourService {
  private TourPackageRepository tourPackageRepository;
  private TourRepository tourRepository;

  public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
    this.tourPackageRepository = tourPackageRepository;
    this.tourRepository = tourRepository;
  }

  public Tour createTour(String tourPackageName, String title,
      String description, String blurb, Integer price, String duration,
      String bullets, String keywords, Difficulty difficulty, Region region) {

    TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
        .orElseThrow(() -> new RuntimeException("Tour Package not found for id:" + tourPackageName));
    return tourRepository.save(new Tour(title, description, blurb,
        price, duration, bullets, keywords, tourPackage, difficulty, region));
  }

  public List<Tour> lookupByDifficulty(Difficulty difficulty) {
    return tourRepository.findByDifficulty(difficulty);
  }

  public List<Tour> lookupByPackage(String tourPackageCode) {
    return tourRepository.findByTourPackageCode(tourPackageCode);
  }

  public long total() {
    return tourRepository.count();
  }
}