package com.example.explorecalijpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.explorecalijpa.models.TourPackage;


import java.util.Optional;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
 * Challenge: Change url keyword to "packages"
 */
@RepositoryRestResource(path = "packages", collectionResourceRel = "packages")
public interface TourPackageRepository extends JpaRepository<TourPackage, String> {
  Optional<TourPackage> f