package br.com.fiap.fintech.Entities;

import java.sql.Timestamp;

public class Investimento {
    private Long idInvestimento;
    private Long tipoInvestimento;
    private String tipoDescricao;  // New attribute for investment type description
    private Double valorInvestido;
    private Timestamp dataInicio;
    private Timestamp dataResgate;
    private Long usuarioId;

    public Investimento() {
    }

    // Constructor with all attributes, including description
    public Investimento(Long idInvestimento, Long tipoInvestimento, String description, double valorInvestido,
                        Timestamp dataInicio, Timestamp dataResgate, Long usuarioId) {
        this.idInvestimento = idInvestimento;
        this.tipoInvestimento = tipoInvestimento;
        this.tipoDescricao = description;
        this.valorInvestido = valorInvestido;
        this.dataInicio = dataInicio;
        this.dataResgate = dataResgate;
        this.usuarioId = usuarioId;
    }

    // Constructor without ID, suitable for new investments
    public Investimento(Long tipoInvestimento, String description, double valorInvestido,
                        Timestamp dataInicio, Timestamp dataResgate, Long usuarioId) {
        this.tipoInvestimento = tipoInvestimento;
        this.tipoDescricao = description;
        this.valorInvestido = valorInvestido;
        this.dataInicio = dataInicio;
        this.dataResgate = dataResgate;
        this.usuarioId = usuarioId;
    }

    public Investimento(String descricao, double valorInvestido, String dataInicio, String dataResgate, int tipoInvestimentoId) {
    }

    public String getTipoDescricao() {
        return tipoDescricao;
    }

    public void setTipoDescricao(String tipoDescricao) {
        this.tipoDescricao = tipoDescricao;
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
