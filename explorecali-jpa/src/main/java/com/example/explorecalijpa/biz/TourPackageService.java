package com.example.explorecalijpa.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.explorecalijpa.models.TourPackage;
import com.example.explorecalijpa.repos.TourPackageRepository;

@Service
public class TourPackageService {
  private TourPackageRepository tourPackageRepository;

  public TourPackageService(TourPackageRepository tourPackageRepository) {
    this.tourPackageRepository = tourPackageRepository;
  }

  public TourPackage createTourPackage(String code, String name) {
    return tourPackageRepository.findById(code)
        .orElse(tourPackageRepository.save(new TourPackage(code, name)));
  }

  public List<TourPackage> lookupAll() {
    return tourPackageRepository.findAll();
  }

  public long total() {
    return tourPackageRepository.count();
  }
}