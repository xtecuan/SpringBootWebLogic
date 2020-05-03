package com.livejournal.xtecuan.samples.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.livejournal.xtecuan.samples.entities.Regions;
import com.livejournal.xtecuan.samples.repositories.RegionsRepository;

@RestController
@RequestMapping("/regions")
public class RegionsControllers {

	private final RegionsRepository repo;

	@Autowired
	public RegionsControllers(RegionsRepository repo) {
		super();
		this.repo = repo;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	class RegionsNotFoundException extends RuntimeException {
		public RegionsNotFoundException(BigDecimal regionId) {
			super("Could not find Regions with id:" + regionId);
		}
	}

	private void validateRegions(BigDecimal regionId) {
		this.repo.findByRegionId(regionId).orElseThrow(() -> new RegionsNotFoundException(regionId));
	}

	@RequestMapping(method = RequestMethod.GET)
	Page<Regions> readAll(Pageable page) {
		return this.repo.findAll(page);
	}

	/*@RequestMapping(value = "/{regionName}", method = RequestMethod.GET)
	List<Regions> readByRegionName(@PathVariable String regionName) {
		return this.repo.findByRegionName(regionName);
	}*/

	@RequestMapping(value = "/{regionId}", method = RequestMethod.GET)
	Optional<Regions> readPerson(@PathVariable BigDecimal regionId) {
		this.validateRegions(regionId);
		return this.repo.findById(regionId);

	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody Regions input) {
		Regions reg = new Regions();
		reg.setRegionId(input.getRegionId());
		reg.setRegionName(input.getRegionName());
		Regions result = this.repo.save(reg);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{regionId}")
				.buildAndExpand(result.getRegionId()).toUri());
		httpHeaders.add("perId", result.getRegionId().toString());
		return new ResponseEntity<>(result, httpHeaders, HttpStatus.CREATED);
	}

}
