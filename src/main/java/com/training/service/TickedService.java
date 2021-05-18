package com.training.service;

import java.util.List;

import com.training.customexception.TickedAlreadyExist;
import com.training.dto.TickedDTO;
import com.training.dto.TickedRequestDTO;
import com.training.dto.TickedResponseDTO;
import com.training.entity.Ticked;

public interface TickedService {

	List<Ticked> findAll();

	int updateSeats(long trainId, int noOfSeats);

	Ticked save(Ticked ticked) throws TickedAlreadyExist;

	TickedResponseDTO bookTicked(TickedRequestDTO tickedDto) throws TickedAlreadyExist;

	Ticked findByUserId(long uId);
}
