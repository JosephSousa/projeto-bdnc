package com.texugos.botecando.persistencia;

import com.texugos.botecando.entidades.Usuario;
import com.texugos.botecando.interfaces.UsuarioDAO;
import com.texugos.connection.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @brief Classe UsuarioDAOImpl
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date 30/01/2018
 */

public class UsuarioDAOImpl implements UsuarioDAO {

    private final ConexaoBD conex = new ConexaoBD();

    private final Connection connection;
    
     public UsuarioDAOImpl() {
        connection = conex.getConnection();
    }
     
    @Override
     public boolean salvar(Usuario usuario) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT into usuario(nome,email,senha)VALUES (?,?,?)");
            prepareStatement.setString(1, usuario.getNome());
            prepareStatement.setString(2, usuario.getEmail());
            prepareStatement.setString(3, usuario.getSenha());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean remover(Usuario usuario) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM cliente WHERE id=?");
            prepareStatement.setInt(1, usuario.getID());
            prepareStatement.execute();
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("UPDATE cliente set nome=?, email=? WHERE id=?");
            prepareStatement.setString(1, usuario.getNome());
            prepareStatement.setString(2, usuario.getEmail());
            prepareStatement.setInt(3, usuario.getID());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Usuario> todosUsuarios() {
        try {
            List<Usuario> usuarios = new ArrayList<>();

            ResultSet result = consultarTodosOsUsuarios();

            while (result.next()) {
                usuarios.add(criarUsuario(result));
            }
            return usuarios;

        } catch (SQLException ex) {
            Logger.getLogger(com.texugos.botecando.persistencia.UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    private ResultSet consultarTodosOsUsuarios() throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("Select * from usuario");
        ResultSet result = prepareStatement.executeQuery();
        return result;
    }

    private Usuario criarUsuario(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        String email = result.getString("email");
        String senha=result.getString("senha");
        return new Usuario(id, nome, email,senha);
    }
    
    @Override
    public Usuario buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario autentica(String email, String senha) {
         Usuario usuarioRetorno = null;
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM usuario WHERE email='"+email+"'"+ "and senha='"+senha+"'");
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                usuarioRetorno = new Usuario();
                usuarioRetorno.setID(result.getInt("id"));
                usuarioRetorno.setNome(result.getString("nome"));
                usuarioRetorno.setEmail(result.getString("email"));
                usuarioRetorno.setSenha(result.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarioRetorno;
    }
    

    @Override
    public boolean verificarEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
