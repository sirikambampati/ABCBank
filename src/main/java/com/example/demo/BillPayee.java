package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "BillPayee")
public class BillPayee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payeeId;
    @NotBlank
    private int userId;
    @NotBlank
    private String payeeAccountNo;
    @NotBlank
    private String payeePhone;
    @NotBlank
    private String payeeAddress;

    public BillPayee() {
        super();
    }

    public BillPayee(int payeeId, int userId, String payeeAccountNo, String payeePhone, String payeeAddress) {
        super();
        this.payeeId = payeeId;
        this.userId = userId;
        this.payeeAccountNo = payeeAccountNo;
        this.payeePhone = payeePhone;
        this.payeeAddress = payeeAddress;
    }

    public int getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(int payeeId) {
        this.payeeId = payeeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
