package com.nt.dao;

import java.util.List;


import com.nt.bo.Transections;


public interface TransectionDao {
	List<Transections> fatchTransection();

	public void save(Transections txn);

}
