package com.training.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.customexception.ResourseNotFoundException;
import com.training.customexception.TickedAlreadyExist;
import com.training.dto.TickedDTO;
import com.training.dto.TickedRequestDTO;
import com.training.dto.TickedResponseDTO;
import com.training.entity.Ticked;
import com.training.entity.Train;
import com.training.repo.TickedRepository;
import com.training.repo.TrainRepository;
import com.training.service.TickedService;

@Service
@Transactional
public class TickedServiceImpl implements TickedService {

	Logger logger = LoggerFactory.getLogger(TickedServiceImpl.class);

	@Autowired
	private TickedRepository tickedRepository;

	@Autowired
	private TrainRepository trainRepository;

	@Override
	public List<Ticked> findAll() {

		return tickedRepository.findAll();
	}

	@Override
	public TickedResponseDTO bookTicked(TickedRequestDTO tickedRequestDTO) throws TickedAlreadyExist {

		Ticked ticked;
		TickedResponseDTO tickedResponseDto = null;

		// finding trian which is ticked booked by endUser
		logger.info("TickedServiceImpl  bookTicked()  :" + tickedRequestDTO.getTrainId());
		Optional<Train> findTrain = trainRepository.findById(tickedRequestDTO.getTrainId());

		if (findTrain.isPresent()) {

			logger.info("findTrain.isPresent()    :" + findTrain.get().getSource());
			int availableSeat = findTrain.get().getAvailableSeats();

			// validation availableSeat >= and onOfSeats boking by endUser
			if (availableSeat >= tickedRequestDTO.getNoOfSeats()) {

				// entity obj
				ticked = new Ticked();

				// responseDto obj
				tickedResponseDto = new TickedResponseDTO();

				// copy obj from tickedReqDto to entity obj
				BeanUtils.copyProperties(tickedRequestDTO, ticked);

				try {
					// saving booking details
					tickedRepository.save(ticked);

				} catch (ConstraintViolationException e) {
					throw new TickedAlreadyExist("ticked already exist      :");
				}

				// copy save entity obj to tickedResponseDto
				BeanUtils.copyProperties(ticked, tickedResponseDto);

				if (tickedResponseDto != null) {
					// after booked the ticked updates remaining seats
					updateSeats(findTrain.get().getTrainId(), tickedRequestDTO.getNoOfSeats());
				}
				// after booked the ticked updates remaining seats
				// updateSeats(findTrain.get().getTrainId(), tickedRequestDTO.getNoOfSeats());

				return tickedResponseDto;
			} else {
				logger.error("Seat is not avaiable ");
				throw new ResourseNotFoundException("Seat is not avaiable     ");
			}

		} else {
			throw new ResourseNotFoundException("Given Tain is not available   :" + tickedRequestDTO.getTrainId());
		}
	}

	@Override
	public int updateSeats(long trainId, int NoOfSeats) {
		// updating available seat based on trianid
		Optional<Train> train = trainRepository.findById(trainId);
		int totalSeats = 0;
		int remainingSeats = 0;
		if (train.isPresent())
			// available total seats
			totalSeats = train.get().getAvailableSeats();
		// after booked remaining seats
		remainingSeats = totalSeats - NoOfSeats;
		return trainRepository.upDateSeat(remainingSeats, trainId);
	}

	@Override
	public Ticked save(Ticked ticked) throws TickedAlreadyExist {
		Ticked saveTicked = null;

		// finding Trian by trainId which is given by endUser while booking ticked
		logger.info("TickedServiceImpl  save()  :" + ticked.getTrainId());

		Optional<Train> findTrain = trainRepository.findById(ticked.getTrainId());

		if (findTrain.isPresent()) {

			logger.info("findTrain.isPresent()    :" + findTrain.get().getSource());
			int availableSeat = findTrain.get().getAvailableSeats();

			// validation availableSeat >= and onOfSeats boking by endUser
			if (availableSeat >= ticked.getNoOfSeats()) {

				try {
					// saving booking details into Db
					saveTicked = tickedRepository.save(ticked);

					// after booked the ticked updates remaining seats
					if (saveTicked != null) {
						updateSeats(findTrain.get().getTrainId(), ticked.getNoOfSeats());
					}

				} catch (ConstraintViolationException e) {
					throw new TickedAlreadyExist("ticked already exist      :");
				}
				return saveTicked;
			} else {
				logger.error("Seat is not avaiable ");
				// booking seat> available seat get Seat is not avaiable
				throw new ResourseNotFoundException("Seat is not avaiable     ");
			}

		} else {
			// if train id not available then will get Given Tain is not available
			throw new ResourseNotFoundException("Given Tain is not available   :" + ticked.getTrainId());
		}
	}

	@Override
	public Ticked findByUserId(long userId) {
		// find ticked details by ticked id
		Optional<Ticked> getTicked = tickedRepository.findById(userId);
		if (getTicked.isPresent()) {
			// if getTicked obj not empty
			return getTicked.get();
		}
		// if ticked id not available the will get ticked id not available
		throw new ResourseNotFoundException("ticked id not available   :" + userId);
	}
}
