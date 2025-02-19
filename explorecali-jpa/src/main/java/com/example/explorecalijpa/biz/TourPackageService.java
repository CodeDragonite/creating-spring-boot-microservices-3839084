package com.example.explorecalijpa.biz;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.explorecalijpa.models.TourPackage;
import com.example.explorecalijpa.repos.TourPackageRepository;

@Service
public class TourPackageService {

  private TourPackageRepository tourPackageRepo;

  public TourPackageService(TourPackageRepository tourPackageRepo) {
    this.tourPackageRepo = tourPackageRepo;
  }

  public TourPackage creatTourPackage(String code, String name) {
    return tourPackageRepo.findById(code)
        .orElse(
            tourPackageRepo.save(new TourPackage(code, name)));
  }

  public List<TourPackage> lookupAll() {
    return tourPackageRepo.findAll();
  }

  public long total() {
    return tourPackageRepo.count();
  }
}
