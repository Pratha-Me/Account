/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.utility;

import com.Message;
import com.model.utility.OrganizationMaster;
import com.repository.utility.OrganizationMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrganizationMasterServiceImpl implements OrganizationMasterService {

    @Autowired
    OrganizationMasterRepository repository;
    Message msg = new Message();

    @Override
    public ResponseEntity getRecord() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    public ResponseEntity doSave(OrganizationMaster obj) {
        repository.save(obj);
        return ResponseEntity.ok(msg.respondWithMessage("Success"));
    }

    @Override
    public ResponseEntity doUpdate(OrganizationMaster obj) {
        repository.save(obj);
        return ResponseEntity.ok(msg.respondWithMessage("Success"));
    }

    @Override
    public ResponseEntity doDelete(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok(msg.respondWithMessage("Success"));
    }

}
