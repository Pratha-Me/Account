/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.fiscal;

import com.model.account.FiscalYear;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author pratha
 */

public interface FiscalYearService {
	
	public ResponseEntity getRecord();
	
	public ResponseEntity doSave(FiscalYear obj);

	public ResponseEntity doUpdate(FiscalYear obj);
	
	public ResponseEntity doDelete(Long id);
}
