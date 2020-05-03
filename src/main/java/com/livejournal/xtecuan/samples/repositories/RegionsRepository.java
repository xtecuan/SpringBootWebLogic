package com.livejournal.xtecuan.samples.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livejournal.xtecuan.samples.entities.Regions;

public interface RegionsRepository extends JpaRepository<Regions, BigDecimal> {

	Optional<Regions> findByRegionId(BigDecimal regionId);

	List<Regions> findByRegionName(String regionName);

}
