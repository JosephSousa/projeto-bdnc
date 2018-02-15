package com.texugos.botecando.controllers;

import com.texugos.botecando.entidades.Usuario;
import com.texugos.botecando.interfaces.UsuarioService;
import com.texugos.botecando.service.UsuarioServiceImpl;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @brief Classe ControladorUsuario
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date 05/02/2018
 */
@Named
@RequestScoped
public class ControladorUsuario implements Serializable {

    private UsuarioService usuarioService = new UsuarioServiceImpl();
    private Usuario usuario = new Usuario();
    private String nome;
    private String senha;
    private String email;
    private HttpSession sessao;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public String cadastrar() {
        usuario = new Usuario(nome, email, senha);
        usuarioService.salvar(usuario);
        usuario = new Usuario();
        iniciarSessao();
        return "home.xhtml";
    }

    public String realizarLogin() {
        Usuario autentica = usuarioService.autenticar(usuario.getEmail(), usuario.getSenha());
        usuario = new Usuario();
        if (autentica != null) {
            iniciarSessao();
            sessao.setAttribute("usuario", autentica);
            return "home.xhtml";
        }
        mostrarMensagem("Email e senha invalidos!");
        return null;
    }

    public void mostrarMensagem(String msg) {
        FacesMessage message = new FacesMessage(msg);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage("Acesso", message);
    }

    private void iniciarSessao() {
        sessao = (HttpSession) FacesContext.getCurrentInstance().
                getExternalContext().getSession(true);
    }
}
