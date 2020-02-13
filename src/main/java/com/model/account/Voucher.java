package com.model.account;


import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "voucher", uniqueConstraints = @UniqueConstraint(name = "VOUCHER_SN", columnNames = {"VOUCHER_TYPE", "FISCAL_YEAR", "VOUCHER_SN"}))
public class Voucher implements java.io.Serializable {

    @Id
    @Column(name = "VOUCHER_NO")
    private String voucherNo;
    @Column(name = "VOUCHER_TYPE")
    private String voucherType;
    @Column(name = "FISCAL_YEAR")
    private Long fiscalYear;
    @Column(name = "VOUCHER_SN")
    private Integer voucherSn;
    @Column(name = "TOTAL_AMOUNT")
    private Float totalAmount;
    @Column(name = "ENTER_BY")
    private String enterBy;
    @Column(name = "ENTER_DATE")
    @Temporal(TemporalType.DATE)
    private java.util.Date enterDate;
    @Column(name = "APPROVE_BY",  insertable = false, nullable = true)
    private String approveBy;
    @Column(name = "APPROVE_DATE", insertable = false, nullable = true)
    @Temporal(TemporalType.DATE)
    private java.util.Date approveDate;
    @Column(name = "NARRATION")
    private String narration;
    @Column(name = "CHEQUE_NO")
    private String chequeNo;
	
//	@Fetch(value=FetchMode.SUBSELECT)
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "voucher", fetch = FetchType.EAGER)
	private List<VoucherDetail> detail;
	
    @JoinColumn(name = "FISCAL_YEAR", referencedColumnName = "ID", insertable = false, updatable = false)//
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FiscalYear fiscalYear11;

    public Voucher() {
    }

    public Voucher(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public Long getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(Long fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public Integer getVoucherSn() {
        return voucherSn;
    }

    public void setVoucherSn(Integer voucherSn) {
        this.voucherSn = voucherSn;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getEnterBy() {
        return enterBy;
    }

    public void setEnterBy(String enterBy) {
        this.enterBy = enterBy;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public String getApproveBy() {
        return approveBy;
    }

    public void setApproveBy(String approveBy) {
        this.approveBy = approveBy;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

	public List<VoucherDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<VoucherDetail> detail) {
		this.detail = detail;
	}


    @Override
    public String toString() {
        return "\n{\"voucherNo\": \"" + voucherNo + "\",\"voucherType\": \"" + voucherType + "\",\"fiscalYear\": \"" + fiscalYear + "\",\"voucherSn\": \"" + voucherSn + "\",\"totalAmount\": \"" + totalAmount + "\",\"enterBy\": \"" + enterBy + "\",\"enterDate\": \"" + enterDate + "\",\"approveBy\": \"" + approveBy + "\",\"approveDate\": \"" + approveDate + "\",\"narration\": \"" + narration + "\",\"chequeNo\": \"" + chequeNo + "\"}";
    }
}
