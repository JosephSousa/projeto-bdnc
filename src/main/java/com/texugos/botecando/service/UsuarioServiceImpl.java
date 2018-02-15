package com.texugos.botecando.service;

import com.texugos.botecando.entidades.Usuario;
import com.texugos.botecando.interfaces.UsuarioDAO;
import com.texugos.botecando.interfaces.UsuarioService;
import com.texugos.botecando.persistencia.UsuarioDAOImpl;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @brief Classe UsuarioService
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date   07/02/2018
 */
@Stateless
@Remote(UsuarioService.class)
public class UsuarioServiceImpl implements UsuarioService{

    
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Override
    public void salvar(Usuario usuario) {
        usuarioDAO.adicionar(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario getUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        Usuario usuario=usuarioDAO.autentica(email, senha);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
