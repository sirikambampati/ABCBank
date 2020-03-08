package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "BillPayee")
public class BillPayee {

    @Id
    private String payeeId;
    @NotBlank
    private String userId;
    @NotBlank
    private String payeeAccountNo;
    @NotBlank
    private String payeePhone;
    @NotBlank
    private String payeeAddress;

    public BillPayee() {
        super();
    }

    public BillPayee(String payeeId, String userId, String payeeAccountNo, String payeePhone, String payeeAddress) {
        super();
        this.payeeId = payeeId;
        this.userId = userId;
        this.payeeAccountNo = payeeAccountNo;
        this.payeePhone = payeePhone;
        this.payeeAddress = payeeAddress;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo;
    }

    public String getPayeePhone() {
        return payeePhone;
    }

    public void setPayeePhone(String payeePhone) {
        this.payeePhone = payeePhone;
    }

    public String getPayeeAddress() {
        return payeeAddress;
    }

    public void setPayeeAddress(String payeeAddress) {
        this.payeeAddress = payeeAddress;
    }
}
