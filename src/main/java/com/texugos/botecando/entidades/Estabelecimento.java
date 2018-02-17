package com.texugos.botecando.entidades;

import java.io.Serializable;

/**
 * @brief Classe Estabelecimento
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date   29/01/2018
 */

public class Estabelecimento implements Serializable {

    
    private int ID;
    private String nome;
    private String latitude;
    private String Longitude;
    private int classificacao=0;

    public Estabelecimento() {
    }

    public Estabelecimento(int ID, String nome, String latitude, String Longitude) {
        this.ID = ID;
        this.nome = nome;
        this.latitude = latitude;
        this.Longitude = Longitude;
    }
    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
     
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    @Override
    public String toString() {
        return "Estabelecimento{" + "ID=" + ID + ", nome=" + nome + ", latitude=" + latitude + ", Longitude=" + Longitude + ", classificacao=" + classificacao + '}';
    }
}
