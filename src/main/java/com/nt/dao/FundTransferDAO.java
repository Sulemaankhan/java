package com.nt.dao;


import com.nt.bo.Account;

public interface FundTransferDAO {

	int sendMonyFrom(long soruceAccno, double amount);

	int sendMonyTo(long destAccno, double amount);

	Account findById(Long sourceAccountId);

}
