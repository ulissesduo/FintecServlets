package br.com.fiap.fintech.Entities;

import java.sql.Timestamp;

public class InvestimentoT {
    private int idInvestimento;
    private Integer investmentTypeId;
    private Double valorInvestido;
    private Timestamp dataInicio;
    private Timestamp dataResgate;
    private Integer usuarioId;


    public InvestimentoT() {}

    public InvestimentoT( Double valorInvestido, Timestamp dataInicio, Timestamp dataResgate, Integer usuarioId) {
        this.valorInvestido = valorInvestido;
        this.dataInicio = dataInicio;
        this.dataResgate = dataResgate;
        this.usuarioId = usuarioId;
    }

    public InvestimentoT(Integer investmentTypeId, Double valorInvestido, Timestamp dataInicio, Timestamp dataResgate, Integer usuarioId) {
        this.investmentTypeId = investmentTypeId;
        this.valorInvestido = valorInvestido;
        this.dataInicio = dataInicio;
        this.dataResgate = dataResgate;
        this.usuarioId = usuarioId;
    }

    public Integer getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(Integer idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public Integer getInvestmentTypeId() {
        return investmentTypeId;
    }

    public void setInvestmentTypeId(Integer investmentTypeId) {
        this.investmentTypeId = investmentTypeId;
    }

    public Double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(Double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(Timestamp dataResgate) {
        this.dataResgate = dataResgate;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
