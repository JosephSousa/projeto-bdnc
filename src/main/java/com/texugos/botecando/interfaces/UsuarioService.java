/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.texugos.botecando.interfaces;

import com.texugos.botecando.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Joseph Sousa
 */
public interface UsuarioService {

    void salvar(Usuario usuario);

    void atualizar(Usuario usuario);

    void remover(int id);

    Usuario getUsuario(int id);

    Usuario autenticar(String email, String senha);

    List<Usuario> listarTodos();
}
