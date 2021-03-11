package com.zhdanko.database.model;

import java.util.Date;

public class Payment {
    private int id;
    private final int code;
    private final int amount;
    private final Date paymentDate;
    private final int recipientId;

    public Payment(int code, int amount, Date paymentDate, int recipientId) {
        this.code = code;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.recipientId = recipientId;
    }

    public int getCode() {
        return code;
    }

    public int getAmount() {
        return amount;
    }


    public Date getPaymentDate() {
        return paymentDate;
    }


    public int getRecipientId() {
        return recipientId;
    }


}