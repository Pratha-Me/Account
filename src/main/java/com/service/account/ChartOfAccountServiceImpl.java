/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.account;

import com.Message;
import com.model.account.ChartOfAccount;
import com.repository.account.ChartOfAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author pratha
 */
@Service
public class ChartOfAccountServiceImpl implements ChartOfAccountService {

	@Autowired
	ChartOfAccountRepository repository;
	Message msg = new Message();

	@Override
	public ResponseEntity getRecord() {
		return ResponseEntity.ok(repository.findAll());
	}

	@Override
	public ResponseEntity doSave(ChartOfAccount obj) {
		String mgrCode = obj.getMgrCode();
		int sn = repository.findNextSn(mgrCode);
		String acCode = "";
		if (sn < 10) {
			acCode = mgrCode + "0" + sn;
		} else {
			acCode = mgrCode + "" + sn;
		}
		obj.setAcCode(acCode);
		obj.setAcSn(sn);
		obj.setLevel(repository.findNextLevel(mgrCode));

		repository.save(obj);
		return ResponseEntity.ok(msg.respondWithMessage("Success"));
	}

	@Override
	public ResponseEntity doUpdate(ChartOfAccount obj) {
		repository.save(obj);
		return ResponseEntity.ok(msg.respondWithMessage("Success"));
	}

	@Override
	public ResponseEntity doDelete(String id) {
		repository.deleteById(id);
		return ResponseEntity.ok(msg.respondWithMessage("Success"));
	}

}