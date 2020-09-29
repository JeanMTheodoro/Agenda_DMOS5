package com.example.agenda_dmos5.model;

public class Contato {


    private String getTelefoneCelular;
    private String nomeCompleto;
    private String telefoneFixo;


    public Contato(String getTelefoneCelular, String nomeCompleto, String telefoneFixo ) {
        this.getTelefoneCelular = getTelefoneCelular;
        this.nomeCompleto = nomeCompleto;
        this.telefoneFixo = telefoneFixo;

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getGetTelefoneCelular() {
        return getTelefoneCelular;
    }

    public void setGetTelefoneCelular(String getTelefoneCelular) {
        this.getTelefoneCelular = getTelefoneCelular;
    }
}
