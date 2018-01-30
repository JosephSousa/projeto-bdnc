package com.texugos.botecando.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @brief Classe Estabelecimento
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date   29/01/2018
 */
@Entity
@SequenceGenerator(name = "minha_seq_estabelecimento",
        sequenceName = "seq_estabelecimento",
        initialValue = 1,
        allocationSize = 1)
public class Estabelecimento implements Serializable {

    @Id
    @GeneratedValue(generator = "minha_seq_estabelecimento", strategy = GenerationType.SEQUENCE)
    private int ID;
    @Column(length = 50, nullable = false)
    private String nome;
    private String latitude;
    private String Longitude;
    private int classificacao=0;

    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String latitude, String Longitude) {
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
