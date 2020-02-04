/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.utility;

import com.model.utility.OrganizationMaster;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author MS
 */
public interface OrganizationMasterService {

    public ResponseEntity getRecord();

    public ResponseEntity doSave(OrganizationMaster obj);

    public ResponseEntity doUpdate(OrganizationMaster obj);

    public ResponseEntity doDelete(Long id);
}
