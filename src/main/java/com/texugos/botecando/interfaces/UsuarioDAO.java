package com.texugos.botecando.interfaces;

import com.texugos.botecando.entidades.Usuario;
import java.util.List;

/**
 * @brief Classe UsuarioDAO
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date   30/01/2018
 */
public interface UsuarioDAO {

    boolean salvar(Usuario usuario);
    boolean remover(Usuario usuario);
    boolean atualizar(Usuario usuario);
    List<Usuario> todosUsuarios();
    Usuario buscarPorId(int id);
    Usuario autentica(String email, String senha);
    boolean verificarEmail(String email);
}
