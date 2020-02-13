/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository.fiscal;

import com.model.account.FiscalYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pratha
 */

@Repository
@Transactional
public interface FiscalYearRepository extends JpaRepository<FiscalYear, Long>{
	
}
