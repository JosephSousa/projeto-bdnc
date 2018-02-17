package com.texugos.botecando.persistencia;

import com.texugos.botecando.entidades.Estabelecimento;
import com.texugos.botecando.entidades.Usuario;
import com.texugos.botecando.interfaces.EstabelecimentoDAO;
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
 * @brief Classe EstabelecimentoDAOImpl
 * @author Joseph Sousa
 * @mail jsantos.te@gmail.com
 * @date 29/01/2018
 */
public class EstabelecimentoDAOImpl implements EstabelecimentoDAO {

    private final ConexaoBD conex = new ConexaoBD();

    private final Connection connection;

    public EstabelecimentoDAOImpl() {
        connection = conex.getConnection();
    }

    @Override
    public boolean adicionar(Estabelecimento estabelecimento) {
        try {
            PreparedStatement prepareStatement = connection.prepareStatement("INSERT into estabelecimento(nome,latitude,longitude,classificacao)VALUES (?,?,?,?)");
            prepareStatement.setString(1, estabelecimento.getNome());
            prepareStatement.setString(2, estabelecimento.getLatitude());
            prepareStatement.setString(3, estabelecimento.getLongitude());
            prepareStatement.setInt(4, estabelecimento.getClassificacao());
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean remover(Estabelecimento estabelecimento) {
        return true;
    }

    @Override
    public boolean atualizar(Estabelecimento estabelecimento) {
        return true;
    }

    @Override
    public List<Estabelecimento> listarTodos() {
        try {
            List<Estabelecimento> estabelecimentos = new ArrayList<>();

            ResultSet result = consultarTodosOsEstabelecimentos();

            while (result.next()) {
                estabelecimentos.add(criarEstabelecimento(result));
            }
            return estabelecimentos;

        } catch (SQLException ex) {
            Logger.getLogger(com.texugos.botecando.persistencia.UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.EMPTY_LIST;
    }

    private ResultSet consultarTodosOsEstabelecimentos() throws SQLException {
        PreparedStatement prepareStatement = connection.prepareStatement("Select * from estabelecimento");
        ResultSet result = prepareStatement.executeQuery();
        return result;
    }

    private Estabelecimento criarEstabelecimento(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        String latitude = result.getString("latitude");
        String longitude = result.getString("longitude");
        return new Estabelecimento(id, nome, latitude, longitude);
    }

    @Override
    public Estabelecimento buscarPorId(int id) {
        return new Estabelecimento();
    }

}
