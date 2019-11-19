package br.com.etechoracio.projetos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Projeto {

    @JsonProperty(value = "Id")
    private Integer id;

    @JsonProperty(value = "Nome")
    private String nome;

    @JsonProperty(value = "Orientadores")
    private String orientadores;

    @JsonProperty(value = "Sala")
    private String sala;

    @JsonProperty(value = "Turma")
    private String turma;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrientadores() {
        return orientadores;
    }

    public void setOrientadores(String orientadores) {
        this.orientadores = orientadores;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
