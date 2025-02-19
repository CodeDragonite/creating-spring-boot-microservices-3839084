package com.example.explorecalijpa.biz;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.explorecalijpa.models.Difficulty;
import com.example.explorecalijpa.models.Region;
import com.example.explorecalijpa.models.Tour;
import com.example.explorecalijpa.models.TourPackage;
import com.example.explorecalijpa.repos.TourPackageRepository;
import com.example.explorecalijpa.repos.TourRepository;

@Service
public class TourService {
  private TourRepository tourRepo;
  private TourPackageRepository tourPackageRepo;

  public TourService(TourRepository tourRepo, TourPackageRepository tourPackageRepo) {
    this.tourRepo = tourRepo;
    this.tourPackageRepo = tourPackageRepo;
  }

  public Tour createTour(String tourPackageName, String title,
      String description, String blurb, Integer price, String duration,
      String bullets, String keywords, Difficulty difficulty, Region region) {

    TourPackage tourPackage = tourPackageRepo.findById(tourPackageName)
        .orElseThrow(() -> new RuntimeException("Tour Package not found for id:" + tourPackageName));
    return tourRepo.save(new Tour(title, description, blurb,
        price, duration, bullets, keywords, tourPackage, difficulty, region));
  }

  public long total() {
    return tourRepo.count();
  }

}
