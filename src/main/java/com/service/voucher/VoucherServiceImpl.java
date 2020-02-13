/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.voucher;

import com.Message;
import com.model.account.Voucher;
import com.model.account.VoucherDetail;
import com.repository.voucher.VoucherRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author pratha
 */

@Service
public class VoucherServiceImpl implements VoucherService {

	@Autowired
	VoucherRepository repository;
	Message msg = new Message();
    Voucher obj = new Voucher();

	@Override
	public ResponseEntity getRecord() {
		return ResponseEntity.ok(repository.findAll());
	}

	@Override
	public ResponseEntity doSave(Voucher obj) {
		String voucherNo = "11";
		List<VoucherDetail> list = new ArrayList();
		list.add(new VoucherDetail("1", voucherNo, 1, "1", "", 500f, 0f));
		list.add(new VoucherDetail("2", voucherNo, 2, "2", "", 0f, 500f));
		obj.setDetail(list);
		obj.setChequeNo("1");
		obj.setEnterBy("ADMIN");
		obj.setEnterDate(new Date());
		obj.setFiscalYear(1l);
		
		try{
		repository.save(obj);
		return ResponseEntity.ok("OK");
		} catch(Exception e) {
			return ResponseEntity.ok(e);
		}
	}

	@Override
	public ResponseEntity doUpdate(Voucher obj) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public ResponseEntity doDelete(String id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
