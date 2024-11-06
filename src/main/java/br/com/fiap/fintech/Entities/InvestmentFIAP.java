package br.com.fiap.fintech.Entities;

import java.sql.Timestamp;

public class InvestmentFIAP {

    private int InvestmentID;
    private String Description;
    private String Type;
    private double Amount;
    private Timestamp Date;
    private Long UserId;

    public InvestmentFIAP() {
    }

    public InvestmentFIAP(String description, String tType, double amount, Timestamp date, Long userId) {
        Description = description;
        this.Type = tType;
        Amount = amount;
        Date = date;
        UserId = userId;
    }

    public int getInvestmentID() {
        return InvestmentID;
    }

    public void setInvestmentID(int investmentID) {
        InvestmentID = investmentID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public Timestamp getDate() {
        return Date;
    }

    public void setDate(Timestamp date) {
        Date = date;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }
}
