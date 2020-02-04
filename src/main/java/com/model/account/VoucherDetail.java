package com.model.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "voucher_detail", uniqueConstraints = @UniqueConstraint(name = "VOUCHER_NO", columnNames = {"VOUCHER_NO", "VOUCHER_SN"}))
public class VoucherDetail implements java.io.Serializable {

    @Id
    @Column(name = "ID")
    private String id;
    @JoinColumn(name = "VOUCHER_NO", referencedColumnName = "VOUCHER_NO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Voucher voucherNo;
    @Column(name = "VOUCHER_SN")
    private Integer voucherSn;
    @Column(name = "AC_CODE", nullable = false)
    private String acCode;
    @Column(name = "PARTICULAR")
    private String particular;
    @Column(name = "DR_AMT", nullable = false)
    private Float drAmt;
    @Column(name = "CR_AMT", nullable = false)
    private Float crAmt;
    @JoinColumn(name = "AC_CODE", referencedColumnName = "AC_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ChartOfAccount chartOfAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Voucher getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(Voucher voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Integer getVoucherSn() {
        return voucherSn;
    }

    public void setVoucherSn(Integer voucherSn) {
        this.voucherSn = voucherSn;
    }

    public String getAcCode() {
        return acCode;
    }

    public void setAcCode(String acCode) {
        this.acCode = acCode;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public Float getDrAmt() {
        return drAmt;
    }

    public void setDrAmt(Float drAmt) {
        this.drAmt = drAmt;
    }

    public Float getCrAmt() {
        return crAmt;
    }

    public void setCrAmt(Float crAmt) {
        this.crAmt = crAmt;
    }

    @Override
    public String toString() {
        return "\n{\"id\": \"" + id + "\",\"voucherNo\": \"" + voucherNo + "\",\"voucherSn\": \"" + voucherSn + "\",\"acCode\": \"" + acCode + "\",\"particular\": \"" + particular + "\",\"drAmt\": \"" + drAmt + "\",\"crAmt\": \"" + crAmt + "\"}";
    }
}
