package br.com.fiap.fintech.Entities;

import java.sql.Timestamp;

public class Investimento {
    private Long idInvestimento;
    private Long tipoInvestimento;
    private Double valorInvestido;
    private Timestamp dataInicio;
    private Timestamp dataResgate;
    private Long usuarioId;

    public Investimento() {
    }

    public Investimento(Long idInvestimento, Long tipoInvestimento, Double valorInvestido, Timestamp dataInicio, Timestamp dataResgate, Long usuarioId) {
        this.idInvestimento = idInvestimento;
        this.tipoInvestimento = tipoInvestimento;
        this.valorInvestido = valorInvestido;
        this.dataInicio = dataInicio;
        this.dataResgate = dataResgate;
        this.usuarioId = usuarioId;
    }

    public Long getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(Long idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public Long getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(Long tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
