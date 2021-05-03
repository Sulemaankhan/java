package com.nt.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.command.AccountCmd;
import com.nt.command.UserCmd;
import com.nt.dto.AccountDTO;
import com.nt.dto.UserDTO;
import com.nt.service.AccountService;
import com.nt.service.UserService;

import com.nt.validations.LoginValidator;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	private AccountService accService;
	@Autowired
	private LoginValidator validator;

	private Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/fundtransfer", method = RequestMethod.GET)
	public String fTransferForm(Model model) {
		System.out.println("account:   GET");
		logger.info("execute show FormPage......");
		AccountCmd account = new AccountCmd();
		model.addAttribute("accCmd", account);
		// return lvn
		return "fundtransfer";
	}// method

	@RequestMapping(value = "/fundtransfer", method = RequestMethod.POST)
	public String fundTransfer(Model model, @ModelAttribute("accCmd") AccountCmd accmd, BindingResult errors,
			HttpSession session, @RequestParam("sourceAccNo") long sourceAccNo,
			@RequestParam("dedestAccNo") long dedestAccNo, @RequestParam("amount") double amount) {
		// convert cmd object to dto
		System.out.println("account:   POST");
		AccountDTO dto = new AccountDTO();
		BeanUtils.copyProperties(accmd, dto);

		// user validator
		if (validator.supports(AccountCmd.class)) {
			validator.validate(accmd, errors);
			if (errors.hasErrors()) {
				return "fundTransfer";
			}
		}

		boolean fund = accService.fundTrnasfer(sourceAccNo, dedestAccNo, amount);
		if (fund != false)
			logger.info("after trnsfer mony go to Trensection page");
		return "redirect:/transections/txnHistory";
	}
}
