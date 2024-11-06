package br.com.fiap.fintech.Entities;

public class Game {
    private Long id_game;
    private String titulo;
    private String estudio;
    private int ano;
    private boolean finalizado;

    public Game(Long id_game, String titulo, String estudio, int ano, boolean finalizado) {
        this.id_game = id_game;
        this.titulo = titulo;
        this.estudio = estudio;
        this.ano = ano;
        this.finalizado = finalizado;
    }

    public Game() {
    }

    public Long getId_game() {
        return id_game;
    }

    public void setId_game(Long id_game) {
        this.id_game = id_game;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
}
