/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.fiscal;

import com.Message;
import com.model.account.FiscalYear;
import com.repository.fiscal.FiscalYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author pratha
 */

@Service
public class FiscalYearServiceImpl implements FiscalYearService{

	@Autowired
	FiscalYearRepository repository;
	
	Message msg = new Message();
	
	@Override
	public ResponseEntity getRecord() {
		return ResponseEntity.ok(repository.findAll());
	}

	@Override
	public ResponseEntity doSave(FiscalYear obj) {
		repository.save(obj);
		return ResponseEntity.ok(msg.respondWithMessage("Successfully Saved"));
	}

	@Override
	public ResponseEntity doUpdate(FiscalYear obj) {
		repository.save(obj);
		return ResponseEntity.ok(msg.respondWithMessage("Successfully Updated"));
	}

	@Override
	public ResponseEntity doDelete(Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok(msg.respondWithMessage("Successfully Deleted"));
	}
	

	
}
