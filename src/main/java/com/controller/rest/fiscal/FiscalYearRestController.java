/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.controller.rest.fiscal;

import com.model.account.FiscalYear;
import com.service.fiscal.FiscalYearService;
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

@RequestMapping(value ="api/Fiscal/FiscalYear")
@RestController
public class FiscalYearRestController {
	
	@Autowired
	FiscalYearService service;
	
	@GetMapping
	public ResponseEntity index() {
		return service.getRecord();
	}
	
	@PostMapping
	public ResponseEntity doSave(@RequestBody FiscalYear obj) {
		return service.doSave(obj);
	}
	
	@PutMapping
	public ResponseEntity doUpdate(@RequestBody FiscalYear obj) {
		return service.doUpdate(obj);
	}
	
	@DeleteMapping
	public ResponseEntity doDelete(@PathVariable Long id) {
		return service.doDelete(id);
	}
}
