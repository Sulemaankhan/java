package com.training.service;


import java.util.Date;
import java.util.List;

import com.training.entity.Train;

public interface TrainService {

	List<Train> searchBySourceOrDestAndDate(String source, String dest, Date newDate);

}
