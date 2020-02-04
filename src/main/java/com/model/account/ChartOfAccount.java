package com.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "chart_of_account", uniqueConstraints = @UniqueConstraint(columnNames = {"AC_NAME", "MGR_CODE"}, name = "AC_NAME_UNIQUE"))
public class ChartOfAccount implements java.io.Serializable {

    @Id
    @Column(name = "AC_CODE", columnDefinition = "VARCHAR(30)")
    private String acCode;
    @Column(name = "AC_NAME", columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci")
    private String acName;
    @Column(name = "AC_SN", columnDefinition = "INT(6)", updatable = false)
    private Integer acSn;
    @Column(name = "MGR_CODE", columnDefinition = "VARCHAR(30)", updatable = false)
    private String mgrCode;
    @Column(name = "TRANSACT", columnDefinition = "VARCHAR(1)")
    private String transact;
    @Column(name = "LEVEL", columnDefinition = "INT(2)", updatable = false)
    private Integer level;

    public ChartOfAccount() {
    }

    public ChartOfAccount(String acCode) {
        this.acCode = acCode;
    }

    public String getAcCode() {
        return acCode;
    }

    public void setAcCode(String acCode) {
        this.acCode = acCode;
    }

    public String getAcName() {
        return acName;
    }

    public void setAcName(String acName) {
        this.acName = acName;
    }

    public Integer getAcSn() {
        return acSn;
    }

    public void setAcSn(Integer acSn) {
        this.acSn = acSn;
    }

    public String getMgrCode() {
        return mgrCode;
    }

    public void setMgrCode(String mgrCode) {
        this.mgrCode = mgrCode;
    }

    public String getTransact() {
        return transact;
    }

    public void setTransact(String transact) {
        this.transact = transact;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "\n{\"acCode\": \"" + acCode + "\",\"acName\": \"" + acName + "\",\"acSn\": \"" + acSn + "\",\"mgrCode\": \"" + mgrCode + "\",\"transact\": \"" + transact + "\",\"level\": \"" + level + "\"}";
    }
}
