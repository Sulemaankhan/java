package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.nt.bo.Transections;
import com.nt.dto.TransectionDTO;

@Service
public class TransectionServiceImpl implements TransectionService {

	@Override
	public List<TransectionDTO> fatchTransection() {
		Transections txn = new Transections();
		List<TransectionDTO> txnDTO = new ArrayList<TransectionDTO>();
		BeanUtils.copyProperties(txn, txnDTO);

		// return into DTO obj
		return txnDTO;
	}

}
