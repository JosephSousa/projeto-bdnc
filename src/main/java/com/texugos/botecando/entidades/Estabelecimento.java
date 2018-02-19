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
    private double latitude;
    private double Longitude;
    private int classificacao=0;

    public Estabelecimento() {
    }

    public Estabelecimento(int ID, String nome, double latitude, double Longitude) {
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    @Override
    public String toString() {
        return "Estabelecimento{" + "ID=" + ID + ", nome=" + nome + ", latitude=" + latitude + ", Longitude=" + Longitude + ", classificacao=" + classificacao + '}';
    }
}
