package com.umkc.simulated.annealing.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.umkc.simulated.annealing.models.Item;
import com.umkc.simulated.annealing.service.SimulatedAnnealingService;

@Controller

public class SimuleatedAnnealingController {

	@Autowired
	SimulatedAnnealingService simulatedAnnealingService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SimuleatedAnnealingController.class);

	@PostMapping(value = "/simulated-annealing/process", consumes = {
			MediaType.MULTIPART_FORM_DATA_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Item>> uploadSingleFileExample2(@RequestParam MultipartFile file,
			@RequestParam(required = false)  String delimeter) {
		LOGGER.info("Request contains, File: " + file.getOriginalFilename());

		if (delimeter == null || delimeter.isEmpty()) {
			delimeter = "\t";
		}
		return ResponseEntity.ok(simulatedAnnealingService.process(file, delimeter));
	}

}
