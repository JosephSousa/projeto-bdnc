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
    private Usuario usuario = new Usuario() ;
    private HttpSession sessao;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public String cadastrar() {
        System.out.println("entrou");
        usuarioService.salvar(usuario);
        System.out.println("saiu");
        usuario = new Usuario();
        return "index.xhtml";
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
