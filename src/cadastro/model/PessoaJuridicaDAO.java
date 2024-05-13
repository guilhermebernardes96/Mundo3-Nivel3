package cadastro.model;

import cadastrobd.model.PessoaJuridica;
import cadastro.model.util.ConectorBD;
import cadastro.model.util.SequenceManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class PessoaJuridicaDAO {
    private ConectorBD conectorBD;
    private SequenceManager sequenceManager;

    public PessoaJuridicaDAO() {
        this.conectorBD = new ConectorBD();
        this.sequenceManager = new SequenceManager();
    }
    
    public PessoaJuridica getPessoa(int id) throws SQLException {
        PessoaJuridica pessoa = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConectorBD.getConnection();
            
            String sql = "SELECT p.idPessoa, p.nome, p.logradouro, p.cidade, p.estado, p.telefone, p.email, pj.cnpj " +
                         "FROM Pessoa p INNER JOIN pessoaJuridica pj ON p.idPessoa = pj.idPessoa " +
                         "WHERE p.idPessoa = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                pessoa = new PessoaJuridica(
                    resultSet.getInt("idPessoa"),
                    resultSet.getString("nome"),
                    resultSet.getString("logradouro"),
                    resultSet.getString("cidade"),
                    resultSet.getString("estado"),
                    resultSet.getString("telefone"),
                    resultSet.getString("email"),
                    resultSet.getString("cnpj")
                );
            }
        } finally {
            ConectorBD.close(resultSet);
            ConectorBD.close(preparedStatement);
            ConectorBD.close(connection);
        }

        return pessoa;
    }

    public List<PessoaJuridica> getPessoas() throws SQLException {
        List<PessoaJuridica> pessoas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConectorBD.getConnection();
            
            String sql = "SELECT p.idPessoa, p.nome, p.logradouro, p.cidade, p.estado, p.telefone, p.email, pj.cnpj " +
                         "FROM pessoa p " +
                         "JOIN pessoaJuridica pj ON p.idPessoa = pj.idPessoa";
            
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                PessoaJuridica pessoa = new PessoaJuridica(
                    resultSet.getInt("idPessoa"),
                    resultSet.getString("nome"),
                    resultSet.getString("logradouro"),
                    resultSet.getString("cidade"),
                    resultSet.getString("estado"),
                    resultSet.getString("telefone"),
                    resultSet.getString("email"),
                    resultSet.getString("cnpj")
                );
                pessoas.add(pessoa);
            }
        } finally {
            ConectorBD.close(resultSet);
            ConectorBD.close(preparedStatement);
            ConectorBD.close(connection);
        }

        return pessoas;
    }

    public void incluir(PessoaJuridica pessoa) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConectorBD.getConnection();
            connection.setAutoCommit(false);
            
            String sqlPessoa = "INSERT INTO Pessoa (nome, logradouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getLogradouro());
            preparedStatement.setString(3, pessoa.getCidade());
            preparedStatement.setString(4, pessoa.getEstado());
            preparedStatement.setString(5, pessoa.getTelefone());
            preparedStatement.setString(6, pessoa.getEmail());
            preparedStatement.executeUpdate();
            
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            int pessoaId;
            if (generatedKeys.next()) {
                pessoaId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Erro ao gerar ID.");
            }
            
            String sqlPessoaJuridica = "INSERT INTO PessoaJuridica (idPessoa, cnpj) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sqlPessoaJuridica);
            preparedStatement.setInt(1, pessoaId);
            preparedStatement.setString(2, pessoa.getCnpj());
            preparedStatement.executeUpdate();
            
            connection.commit();
            
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.setAutoCommit(true);
            }
            ConectorBD.close(preparedStatement);
            ConectorBD.close(connection);
        }
    }

    public void alterar(PessoaJuridica pessoa) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConectorBD.getConnection();
            connection.setAutoCommit(false);

            String sqlPessoa = "UPDATE pessoa SET nome = ?, logradouro = ?, cidade = ?, estado = ?, telefone = ?, email = ? WHERE idPessoa = ?";
            preparedStatement = connection.prepareStatement(sqlPessoa);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getLogradouro());
            preparedStatement.setString(3, pessoa.getCidade());
            preparedStatement.setString(4, pessoa.getEstado());
            preparedStatement.setString(5, pessoa.getTelefone());
            preparedStatement.setString(6, pessoa.getEmail());
            preparedStatement.setInt(7, pessoa.getId());
            preparedStatement.executeUpdate();
            
            String sqlPessoaJuridica = "UPDATE pessoaJuridica SET cnpj = ? WHERE idPessoa = ?";
            preparedStatement = connection.prepareStatement(sqlPessoaJuridica);
            preparedStatement.setString(1, pessoa.getCnpj());
            preparedStatement.setInt(2, pessoa.getId());
            preparedStatement.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.setAutoCommit(true);
            }
            ConectorBD.close(preparedStatement);
            ConectorBD.close(connection);
        }
    }

    public void excluir(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConectorBD.getConnection();
            
            String sqlPessoa = "DELETE FROM pessoa WHERE idPessoa = ?";
            
            String sqlPessoaJuridica = "DELETE FROM pessoaJuridica WHERE idPessoa = ?";
            
            connection.setAutoCommit(false);
            
            preparedStatement = connection.prepareStatement(sqlPessoa);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
            preparedStatement = connection.prepareStatement(sqlPessoaJuridica);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.setAutoCommit(true);
            }
            ConectorBD.close(preparedStatement);
            ConectorBD.close(connection);
        }
    }    
}
