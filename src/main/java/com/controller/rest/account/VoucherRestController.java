/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.rest.account;

import com.model.account.ChartOfAccount;
import com.model.account.Voucher;
import com.service.voucher.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pratha
 */
@RestController
@RequestMapping("api/Account/Voucher")
public class VoucherRestController {

	@Autowired
	VoucherService service;

	@GetMapping
	public ResponseEntity index() {
		return service.getRecord();
	}

	@PostMapping
	public ResponseEntity doSave(@RequestBody Voucher obj) {
		return service.doSave(obj);
	}

	@PutMapping
	public ResponseEntity doUpdate(@RequestBody Voucher obj) {
		return service.doUpdate(obj);
	}

	@DeleteMapping
	public ResponseEntity doDelete(@PathVariable String id) {
		return service.doDelete(id);
	}
}
