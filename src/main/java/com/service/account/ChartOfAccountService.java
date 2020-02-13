/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.account;

import com.model.account.ChartOfAccount;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author pratha
 */
public interface ChartOfAccountService {

	public ResponseEntity getRecord();

	public ResponseEntity doSave(ChartOfAccount obj);

	public ResponseEntity doUpdate(ChartOfAccount obj);

	public ResponseEntity doDelete(String id);
}
