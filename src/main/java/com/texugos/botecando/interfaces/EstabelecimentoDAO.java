package com.texugos.botecando.interfaces;

import com.texugos.botecando.entidades.Estabelecimento;
import java.util.List;

/**
 * @brief Classe EstabelecimentoDAO
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date   29/01/2018
 */
public interface EstabelecimentoDAO {
    
    boolean adicionar(Estabelecimento estabelecimento);
    boolean remover(Estabelecimento estabelecimento);
    boolean atualizar(Estabelecimento estabelecimento);
    List<Estabelecimento> listarTodos();
    Estabelecimento buscarPorId(int id);
}
