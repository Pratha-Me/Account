/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.rest.account;

import com.model.account.ChartOfAccount;
import com.service.account.ChartOfAccountService;
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
 * INSERT INTO chart_of_account (ac_code, ac_name, ac_sn, `level`, mgr_code,
 * transact) VALUES ('1', 'Asset', NULL, 1, NULL, 'N'); INSERT INTO
 * chart_of_account (ac_code, ac_name, ac_sn, `level`, mgr_code, transact)
 * VALUES ('2', 'Liabilities', NULL, 1, NULL, 'N'); INSERT INTO chart_of_account
 * (ac_code, ac_name, ac_sn, `level`, mgr_code, transact) VALUES ('3', 'Income',
 * NULL, 1, NULL, 'N'); INSERT INTO chart_of_account (ac_code, ac_name, ac_sn,
 * `level`, mgr_code, transact) VALUES ('4', 'Expenses', NULL, 1, NULL, 'N');
 */
@RestController
@RequestMapping("api/Account/ChartOfAccount")
public class ChartOfAccountRestController {

	@Autowired
	ChartOfAccountService service;

	@GetMapping
	public ResponseEntity index() {
		return service.getRecord();
	}

	@PostMapping
	public ResponseEntity doSave(@RequestBody ChartOfAccount obj) {
		return service.doSave(obj);
	}

	@PutMapping
	public ResponseEntity doUpdate(@RequestBody ChartOfAccount obj) {
		return service.doUpdate(obj);
	}

	@DeleteMapping
	public ResponseEntity doDelete(@PathVariable String id) {
		return service.doDelete(id);
	}
}
