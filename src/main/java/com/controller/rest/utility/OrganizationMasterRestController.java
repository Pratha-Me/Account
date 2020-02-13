/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.rest.utility;

import com.model.utility.OrganizationMaster;
import com.service.utility.OrganizationMasterService;
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

@RestController
@RequestMapping("api/Utility/OrganizationMaster")
public class OrganizationMasterRestController {

    @Autowired
    OrganizationMasterService service;

    @GetMapping
    public ResponseEntity index() {
        return service.getRecord();
    }

    @PostMapping
    public ResponseEntity doSave(@RequestBody OrganizationMaster obj) {
        return service.doSave(obj);
    }

//    @PutMapping
//    public ResponseEntity doUpdate(@RequestBody OrganizationMaster obj) {
//        return service.doUpdate(obj);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity doDelete(@PathVariable Long id) {
//        return service.doDelete(id);
//    }
}
