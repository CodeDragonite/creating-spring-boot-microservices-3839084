package com.example.explorecalijpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.explorecalijpa.models.TourPackage;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface TourPackageRepository extends JpaRepository<TourPackage, String> {
  Optional<TourPackage> findByName(String name);
}