package com.texugos.botecando.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

/**
 * @brief Classe Usuario
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date 29/01/2018
 */
@Entity
@SequenceGenerator(name = "minha_seq_usuario",
        sequenceName = "seq_usuario",
        initialValue = 1,
        allocationSize = 1)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(generator = "minha_seq_usuario", strategy = GenerationType.SEQUENCE)
    private int ID;
    @Column(length = 50, nullable = false)
    private String nome;
    private String email;
    private String senha;
    @Transient
    private boolean logado;

    public Usuario() {
    }
    
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID=" + ID + ", nome=" + nome + ", email=" + email + ", senha=" + senha + '}';
    }
}
