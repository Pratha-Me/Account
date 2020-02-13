/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.voucher;

import com.model.account.Voucher;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author pratha
 */

public interface VoucherService {

	public ResponseEntity getRecord();

	public ResponseEntity doSave(Voucher obj);

	public ResponseEntity doUpdate(Voucher obj);

	public ResponseEntity doDelete(String id);
}
