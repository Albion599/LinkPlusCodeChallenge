package com.bank;

public class Transaction {
    private double amount;
    private String originatingAccountId;
    private String resultingAccountId;
    private String reason;

    public Transaction(double amount, String originatingAccountId, String resultingAccountId, String reason) {
        this.amount = amount;
        this.originatingAccountId = originatingAccountId;
        this.resultingAccountId = resultingAccountId;
        this.reason = reason;
    }

    public double getAmount() {
        return amount;
    }

    public String getOriginatingAccountId() {
        return originatingAccountId;
    }

    public String getResultingAccountId() {
        return resultingAccountId;
    }

    public String getReason() {
        return reason;
    }
}
