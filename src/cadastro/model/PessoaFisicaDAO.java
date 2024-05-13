package cadastro.model;

import cadastro.model.util.ConectorBD;
import cadastro.model.util.SequenceManager;
import cadastrobd.model.PessoaFisica;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {
    private ConectorBD conectorBD;
    private SequenceManager sequenceManager;
    
    public PessoaFisicaDAO() {
        this.conectorBD = new ConectorBD();
        this.sequenceManager = new SequenceManager();
    }
    
    public PessoaFisica getPessoa(int id) throws SQLException {
        PessoaFisica pessoa = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConectorBD.getConnection();

            String sql = "SELECT p.idPessoa, p.nome, p.logradouro, p.cidade, p.estado, p.telefone, p.email, pf.cpf " +
                         "FROM pessoa p INNER JOIN pessoaFisica pf ON p.idPessoa = pf.idPessoa " +
                         "WHERE p.idPessoa = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                pessoa = new PessoaFisica(
                    resultSet.getInt("idPessoa"),
                    resultSet.getString("nome"),
                    resultSet.getString("logradouro"),
                    resultSet.getString("cidade"),
                    resultSet.getString("estado"),
                    resultSet.getString("telefone"),
                    resultSet.getString("email"),
                    resultSet.getString("cpf")
                );
            }
        } finally {
            ConectorBD.close(resultSet);
            ConectorBD.close(preparedStatement);
            ConectorBD.close(connection);
        }

        return pessoa;
    }
    
    public List<PessoaFisica> getPessoas() throws SQLException {
        List<PessoaFisica> pessoas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConectorBD.getConnection();
            
            String sql = "SELECT p.idPessoa, p.nome, p.logradouro, p.cidade, p.estado, p.telefone, p.email, pf.cpf " +
                         "FROM pessoa p " +
                         "JOIN pessoaFisica pf ON p.idPessoa = pf.idPessoa";
            
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                PessoaFisica pessoa = new PessoaFisica(
                    resultSet.getInt("idPessoa"),
                    resultSet.getString("nome"),
                    resultSet.getString("logradouro"),
                    resultSet.getString("cidade"),
                    resultSet.getString("estado"),
                    resultSet.getString("telefone"),
                    resultSet.getString("email"),
                    resultSet.getString("cpf")
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

    public void incluir(PessoaFisica pessoa) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
        connection = ConectorBD.getConnection();
        connection.setAutoCommit(false);
        
        String sqlPessoa = "INSERT INTO pessoa (nome, logradouro, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?)";
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

        String sqlPessoaFisica = "INSERT INTO pessoaFisica (idPessoa, cpf) VALUES (?, ?)";
        preparedStatement = connection.prepareStatement(sqlPessoaFisica);
        preparedStatement.setInt(1, pessoaId);
        preparedStatement.setString(2, pessoa.getCpf());
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
    
    public void alterar(PessoaFisica pessoa) throws SQLException {
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

            String sqlPessoaFisica = "UPDATE pessoafisica SET cpf = ? WHERE idPessoa = ?";
            preparedStatement = connection.prepareStatement(sqlPessoaFisica);
            preparedStatement.setString(1, pessoa.getCpf());
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
            
            String sqlPessoaFisica = "DELETE FROM pessoaFisica WHERE idPessoa = ?";
            
            connection.setAutoCommit(false);
            
            preparedStatement = connection.prepareStatement(sqlPessoa);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
            preparedStatement = connection.prepareStatement(sqlPessoaFisica);
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