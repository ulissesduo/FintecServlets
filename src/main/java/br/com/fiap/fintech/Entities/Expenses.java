package br.com.fiap.fintech.Entities;

import java.util.Date;

public class Expenses {
    private Long id;
    private String description;
    private Date payment_date;
    private Double values;
    private Boolean statusPayment;
    private String category;
    private Long userId;


    public Expenses(Long id, String description, Date payment_date, Double values, Boolean statusPayment, String category,Long userId) {
        this.id = id;
        this.description = description;
        this.payment_date = payment_date;
        this.values = values;
        this.statusPayment = statusPayment;
        this.category = category;
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getvalues() {
        return this.values;
    }

    public void setvalues(Double values) {
        this.values = values;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public Double getValues() {
        return values;
    }

    public void setValues(Double values) {
        this.values = values;
    }

    public Boolean getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(Boolean statusPayment) {
        this.statusPayment = statusPayment;
    }



}
