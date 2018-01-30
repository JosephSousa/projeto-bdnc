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

    void adicionar(Usuario usuario);
    void remover(Usuario usuario);
    void atualizar(Usuario usuario);
    List<Usuario> listarTodos();
    Usuario buscarPorId(int id);
    Usuario autentica(String email, String senha);
    boolean verificarEmail(String email);
}
