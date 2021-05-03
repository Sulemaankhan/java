package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.dto.TransectionDTO;
import com.nt.service.TransectionService;

@Controller
@RequestMapping("/transections")
public class TransectionController {
	@Autowired
	private TransectionService txnService;

	private Logger logger = Logger.getLogger(TransectionController.class);

	@RequestMapping(value = "/txnHistory", method = RequestMethod.GET)
	public String fundTransfer(Model model) {
		System.out.println("TransectionController");
		
		// convert cmd object to dto
		List<TransectionDTO> dto = new ArrayList<TransectionDTO>();

		dto = txnService.fatchTransection();
		if (dto != null)
			model.addAttribute("txnList", dto);
		logger.info("after login request forword to home page");
		return "txnDetails";
	}
}
