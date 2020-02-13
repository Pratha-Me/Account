/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository.account;

import com.model.account.ChartOfAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ChartOfAccountRepository extends JpaRepository<ChartOfAccount, String> {

	@Query(value = "SELECT IFNULL(MAX(ac_sn),0)+1 FROM account.chart_of_account WHERE mgr_code=?1",nativeQuery = true)
	int findNextSn(String mgrAccode);

	@Query(value = "SELECT IFNULL(MAX(level),0)+1 FROM account.chart_of_account WHERE ac_code=?1",nativeQuery = true)
	int findNextLevel(String mgrAccode);

}
