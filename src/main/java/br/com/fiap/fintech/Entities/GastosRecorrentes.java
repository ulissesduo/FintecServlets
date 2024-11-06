package br.com.fiap.fintech.Entities;

import java.sql.Timestamp;
import java.util.Date;

public class GastosRecorrentes extends Despesa {
    private Timestamp endDate;
    private Timestamp nextPaymentDate;
    private Integer autoPay;
    private String recurringNote;
    private Integer isCanceled;
    private String frequencia;

    public GastosRecorrentes(String descricao, double valor, Timestamp data_pagamento, char status_pagamento, String categoria, int usuario_id, Timestamp endDate, Timestamp nextPaymentDate, Integer autoPay, String recurringNote, Integer isCanceled, String frequencia) {
        super(descricao, valor, data_pagamento, status_pagamento, categoria, usuario_id);
        this.endDate = endDate;
        this.nextPaymentDate = nextPaymentDate;
        this.autoPay = autoPay;
        this.recurringNote = recurringNote;
        this.isCanceled = isCanceled;
        this.frequencia = frequencia;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(Timestamp nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }

    public Integer getAutoPay() {
        return autoPay;
    }

    public void setAutoPay(Integer autoPay) {
        this.autoPay = autoPay;
    }

    public String getRecurringNote() {
        return recurringNote;
    }

    public void setRecurringNote(String recurringNote) {
        this.recurringNote = recurringNote;
    }

    public Integer getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(Integer isCanceled) {
        this.isCanceled = isCanceled;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }
}
