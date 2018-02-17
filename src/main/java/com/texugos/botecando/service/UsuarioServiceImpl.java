package com.texugos.botecando.service;

import com.texugos.botecando.entidades.Usuario;
import com.texugos.botecando.interfaces.UsuarioDAO;
import com.texugos.botecando.interfaces.UsuarioService;
import com.texugos.botecando.persistencia.UsuarioDAOImpl;
import java.util.List;

/**
 * @brief Classe UsuarioService
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date   07/02/2018
 */
public class UsuarioServiceImpl implements UsuarioService{

    
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    public UsuarioServiceImpl() {
    }
    
    @Override
    public void salvar(Usuario usuario) {
        usuarioDAO.salvar(usuario);
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
