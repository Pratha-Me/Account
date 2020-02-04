package com.model.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organization_master")
public class OrganizationMaster implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "ESTABLISH_YEAR")
    private String establishYear;
    @Column(name = "TEL")
    private String tel;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "URL")
    private String url;
    @Column(name = "STUDENT_FEE_INCOME_ACCOUNT", columnDefinition = "VARCHAR(30)")
    private String studentFeeIncomeAccount;
    @Column(name = "CASH_ACCOUNT", columnDefinition = "VARCHAR(30)")
    private String cashAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getEstablishYear() {
        return establishYear;
    }

    public void setEstablishYear(String establishYear) {
        this.establishYear = establishYear;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStudentFeeIncomeAccount() {
        return studentFeeIncomeAccount;
    }

    public void setStudentFeeIncomeAccount(String studentFeeIncomeAccount) {
        this.studentFeeIncomeAccount = studentFeeIncomeAccount;
    }

    public String getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(String cashAccount) {
        this.cashAccount = cashAccount;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"name\": \"" + name + "\",\"address\": \"" + address + "\",\"province\": \"" + province + "\",\"establishYear\": \"" + establishYear + "\",\"tel\": \"" + tel + "\",\"email\": \"" + email + "\",\"url\": \"" + url + "\"}";
    }
}
