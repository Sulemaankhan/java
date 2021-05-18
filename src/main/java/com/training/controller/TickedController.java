package com.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.customexception.TickedAlreadyExist;
import com.training.dto.TickedDTO;
import com.training.dto.TickedRequestDTO;
import com.training.dto.TickedResponseDTO;
import com.training.entity.Ticked;
import com.training.service.TickedService;

@RestController
@RequestMapping("/tickets")
@Validated
public class TickedController {

	// logger configuration
	Logger logger = LoggerFactory.getLogger(TickedController.class);

	@Autowired
	private TickedService tickedService;

	@PostMapping()
	@Valid
	public ResponseEntity<TickedResponseDTO> book(@Valid @RequestBody TickedRequestDTO tickedDto)
			throws TickedAlreadyExist {
		logger.info("TickedController    bookTicked()");
		TickedResponseDTO responseDto = null;
		try {
			responseDto = tickedService.bookTicked(tickedDto);
		} catch (TickedAlreadyExist e) {
			throw new TickedAlreadyExist("Ticked Already exist.......");
		}
		return new ResponseEntity<TickedResponseDTO>(responseDto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Ticked>> findAll() {
		// call find() method from serviceImpl
		List<Ticked> ticletList = tickedService.findAll();
		// return the response
		return new ResponseEntity<List<Ticked>>(ticletList, HttpStatus.FOUND);
	}

	@GetMapping("{userId}")
	public ResponseEntity<Ticked> byTickedId(@PathVariable("userId") long userId) {
		// call findByTickedId() method from serviceImpl
		Ticked ticletList = tickedService.findByUserId(userId);
		// return the response
		return new ResponseEntity<Ticked>(ticletList, HttpStatus.FOUND);
	}
}
