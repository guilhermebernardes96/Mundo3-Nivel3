package cadastro;

import cadastrobd.model.PessoaFisica;
import cadastro.model.PessoaFisicaDAO;
import cadastro.model.PessoaJuridicaDAO;
import cadastrobd.model.PessoaJuridica;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class CadastroBDTeste {
    public static void main(String[] args) {
        // CADASTRO PF
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("NOVA PESSOA FISICA: ");
//        
//        System.out.print("NOME: ");
//        String nome = scanner.nextLine();
//        System.out.print("LOGRADOURO: ");
//        String logradouro = scanner.nextLine();
//        System.out.print("CIDADE: ");
//        String cidade = scanner.nextLine();
//        System.out.print("ESTADO: ");
//        String estado = scanner.nextLine();
//        System.out.print("TELEFONE: ");
//        String telefone = scanner.nextLine();
//        System.out.print("E-MAIL: ");
//        String email = scanner.nextLine();
//        System.out.print("CPF: ");
//        String cpf = scanner.nextLine();
//        
//        PessoaFisica pessoa = new PessoaFisica();
//        pessoa.setNome(nome);
//        pessoa.setLogradouro(logradouro);
//        pessoa.setCidade(cidade);
//        pessoa.setEstado(estado);
//        pessoa.setTelefone(telefone);
//        pessoa.setEmail(email);
//        pessoa.setCpf(cpf);
//
//        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
//
//        try {
//            pessoaFisicaDAO.incluir(pessoa);
//            System.out.println("Pessoa fisica incluida com sucesso!");
//        } catch (SQLException e) {
//            System.err.println("Erro ao incluir pessoa fisica: " + e.getMessage());
//        } finally {
//            scanner.close();
//        }

        // ALTERAR DADOS PF
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("ALTERAR DADOS DE PESSOA FISICA: ");
//        System.out.println();
//        System.out.println("ID da pessoa fisica que será alterada: ");
//        
//        int id = scanner.nextInt();
//        scanner.nextLine();
//        
//        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
//
//        try {
//            PessoaFisica pessoa = pessoaFisicaDAO.getPessoa(id);
//
//            if (pessoa != null) {
//                System.out.println("DADOS ATUAIS: ");
//                System.out.println("Nome: " + pessoa.getNome());
//                System.out.println("Logradouro: " + pessoa.getLogradouro());
//                System.out.println("Cidade: " + pessoa.getCidade());
//                System.out.println("Estado: " + pessoa.getEstado());
//                System.out.println("Telefone: " + pessoa.getTelefone());
//                System.out.println("Email: " + pessoa.getEmail());
//                System.out.println("CPF: " + pessoa.getCpf());
//                
//                System.out.println();
//                
//                System.out.println("INSIRA OS NOVOS DADOS: ");
//                System.out.print("NOME: ");
//                String nome = scanner.nextLine();
//                System.out.print("LOGRADOURO: ");
//                String logradouro = scanner.nextLine();
//                System.out.print("CIDADE: ");
//                String cidade = scanner.nextLine();
//                System.out.print("ESTADO: ");
//                String estado = scanner.nextLine();
//                System.out.print("TELEFONE: ");
//                String telefone = scanner.nextLine();
//                System.out.print("E-MAIL: ");
//                String email = scanner.nextLine();
//                System.out.print("CPF: ");
//                String cpf = scanner.nextLine();
//                
//                pessoa.setNome(nome);
//                pessoa.setLogradouro(logradouro);
//                pessoa.setCidade(cidade);
//                pessoa.setEstado(estado);
//                pessoa.setTelefone(telefone);
//                pessoa.setEmail(email);
//                pessoa.setCpf(cpf);
//
//                pessoaFisicaDAO.alterar(pessoa);
//                System.out.println("Dados da pessoa fisica alterados com sucesso!");
//            } else {
//                System.out.println("Nenhuma pessoa fisica encontrada com esse ID.");
//            }
//        } catch (SQLException e) {
//            System.err.println("Erro ao alterar pessoa fisica: " + e.getMessage());
//        } finally {
//            scanner.close();
//        }
        
        // CONSULTAR TODOS DADOS DAS PF
//        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
//        
//        try {
//            List<PessoaFisica> pessoas = pessoaFisicaDAO.getPessoas();
//
//            System.out.println("DADOS DE PESSOAS FISICAS:");
//            System.out.println();
//            for (PessoaFisica pessoa : pessoas) {
//                System.out.println("ID: " + pessoa.getId());
//                System.out.println("Nome: " + pessoa.getNome());
//                System.out.println("Logradouro: " + pessoa.getLogradouro());
//                System.out.println("Cidade: " + pessoa.getCidade());
//                System.out.println("Estado: " + pessoa.getEstado());
//                System.out.println("Telefone: " + pessoa.getTelefone());
//                System.out.println("Email: " + pessoa.getEmail());
//                System.out.println("CPF: " + pessoa.getCpf());
//                System.out.println();
//            }
//        } catch (SQLException e) {
//            System.err.println("Erro ao consultar pessoas fisica: " + e.getMessage());
//        }

        // EXCLUIR PF
//        Scanner scanner = new Scanner(System.in);
//        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
//
//        try {
//            List<PessoaFisica> pessoas = pessoaFisicaDAO.getPessoas();
//            System.out.println("DADOS DE PESSOAS FISICAS:");
//            System.out.println();
//            for (PessoaFisica pessoa : pessoas) {
//                System.out.println("ID: " + pessoa.getId());
//                System.out.println("Nome: " + pessoa.getNome());
//                System.out.println("Logradouro: " + pessoa.getLogradouro());
//                System.out.println("Cidade: " + pessoa.getCidade());
//                System.out.println("Estado: " + pessoa.getEstado());
//                System.out.println("Telefone: " + pessoa.getTelefone());
//                System.out.println("Email: " + pessoa.getEmail());
//                System.out.println("CPF: " + pessoa.getCpf());
//                System.out.println();
//            }
//
//            System.out.println("Digite o ID da pessoa física que será excluida:");
//            int idPessoa = scanner.nextInt();
//            pessoaFisicaDAO.excluir(idPessoa);
//            System.out.println("Pessoa fisica excluida com sucesso!");
//        } catch (SQLException e) {
//            System.err.println("Erro ao excluir pessoa fisica: " + e.getMessage());
//        } finally {
//            scanner.close();
//        }

        // CADASTRO PJ
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.println("NOVA PESSOA JURIDICA: ");
//        System.out.print("NOME: ");
//        String nome = scanner.nextLine();
//        System.out.print("LOGRADOURO: ");
//        String logradouro = scanner.nextLine();
//        System.out.print("CIDADE: ");
//        String cidade = scanner.nextLine();
//        System.out.print("ESTADO: ");
//        String estado = scanner.nextLine();
//        System.out.print("TELEFONE: ");
//        String telefone = scanner.nextLine();
//        System.out.print("E-MAIL: ");
//        String email = scanner.nextLine();
//        System.out.print("CNPJ: ");
//        String cnpj = scanner.nextLine();
//        
//        PessoaJuridica pessoa = new PessoaJuridica();
//        pessoa.setNome(nome);
//        pessoa.setLogradouro(logradouro);
//        pessoa.setCidade(cidade);
//        pessoa.setEstado(estado);
//        pessoa.setTelefone(telefone);
//        pessoa.setEmail(email);
//        pessoa.setCnpj(cnpj);
//
//        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
//
//        try {
//            pessoaJuridicaDAO.incluir(pessoa);
//            System.out.println("Pessoa juridica incluida com sucesso!");
//        } catch (SQLException e) {
//            System.err.println("Erro ao incluir pessoa juridica: " + e.getMessage());
//        } finally {
//            scanner.close();
//        }

        // ALTERAR DADOS PJ
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("ALTERAR DADOS DE PESSOA JURIDICA: ");
//        System.out.println();
//        System.out.println("ID da pessoa juridica que será alterada: ");
//        
//        int id = scanner.nextInt();
//        scanner.nextLine();
//        
//        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
//
//        try {
//            PessoaJuridica pessoa = pessoaJuridicaDAO.getPessoa(id);
//
//            if (pessoa != null) {
//                System.out.println("DADOS ATUAIS: ");
//                System.out.println("Nome: " + pessoa.getNome());
//                System.out.println("Logradouro: " + pessoa.getLogradouro());
//                System.out.println("Cidade: " + pessoa.getCidade());
//                System.out.println("Estado: " + pessoa.getEstado());
//                System.out.println("Telefone: " + pessoa.getTelefone());
//                System.out.println("Email: " + pessoa.getEmail());
//                System.out.println("CNPJ: " + pessoa.getCnpj());
//                
//                System.out.println();
//                
//                System.out.println("INSIRA OS NOVOS DADOS: ");
//                System.out.print("NOME: ");
//                String nome = scanner.nextLine();
//                System.out.print("LOGRADOURO: ");
//                String logradouro = scanner.nextLine();
//                System.out.print("CIDADE: ");
//                String cidade = scanner.nextLine();
//                System.out.print("ESTADO: ");
//                String estado = scanner.nextLine();
//                System.out.print("TELEFONE: ");
//                String telefone = scanner.nextLine();
//                System.out.print("E-MAIL: ");
//                String email = scanner.nextLine();
//                System.out.print("CNPJ: ");
//                String cnpj = scanner.nextLine();
//                
//                pessoa.setNome(nome);
//                pessoa.setLogradouro(logradouro);
//                pessoa.setCidade(cidade);
//                pessoa.setEstado(estado);
//                pessoa.setTelefone(telefone);
//                pessoa.setEmail(email);
//                pessoa.setCnpj(cnpj);
//
//                pessoaJuridicaDAO.alterar(pessoa);
//                System.out.println("Dados da pessoa juridica alterado com sucesso!");
//            } else {
//                System.out.println("Nenhuma pessoa juridica encontrada com esse ID.");
//            }
//        } catch (SQLException e) {
//            System.err.println("Erro ao alterar pessoa juridica: " + e.getMessage());
//        } finally {
//            scanner.close();
//        }

        // CONSULTAR TODOS DADOS DAS PF
//        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
//        
//        try {
//            List<PessoaJuridica> pessoas = pessoaJuridicaDAO.getPessoas();
//
//            System.out.println("DADOS DE PESSOAS JURIDICA:");
//            System.out.println();
//            for (PessoaJuridica pessoa : pessoas) {
//                System.out.println("ID: " + pessoa.getId());
//                System.out.println("Nome: " + pessoa.getNome());
//                System.out.println("Logradouro: " + pessoa.getLogradouro());
//                System.out.println("Cidade: " + pessoa.getCidade());
//                System.out.println("Estado: " + pessoa.getEstado());
//                System.out.println("Telefone: " + pessoa.getTelefone());
//                System.out.println("Email: " + pessoa.getEmail());
//                System.out.println("CNPJ: " + pessoa.getCnpj());
//                System.out.println();
//            }
//        } catch (SQLException e) {
//            System.err.println("Erro ao consultar pessoas juridicas: " + e.getMessage());
//        }

        // EXCLUIR PJ
//        Scanner scanner = new Scanner(System.in);
//        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
//
//        try {
//            List<PessoaJuridica> pessoas = pessoaJuridicaDAO.getPessoas();
//            System.out.println("DADOS DE PESSOAS JURIDICAS:");
//            System.out.println();
//            for (PessoaJuridica pessoa : pessoas) {
//                System.out.println("ID: " + pessoa.getId());
//                System.out.println("Nome: " + pessoa.getNome());
//                System.out.println("Logradouro: " + pessoa.getLogradouro());
//                System.out.println("Cidade: " + pessoa.getCidade());
//                System.out.println("Estado: " + pessoa.getEstado());
//                System.out.println("Telefone: " + pessoa.getTelefone());
//                System.out.println("Email: " + pessoa.getEmail());
//                System.out.println("CNPJ: " + pessoa.getCnpj());
//                System.out.println();
//            }
//
//            System.out.println("Digite o ID da pessoa juridica que será excluido: ");
//            int idPessoa = scanner.nextInt();
//            pessoaJuridicaDAO.excluir(idPessoa);
//            System.out.println("Pessoa juridica excluída com sucesso!");
//        } catch (SQLException e) {
//            System.err.println("Erro ao excluir pessoa juridica: " + e.getMessage());
//        } finally {
//            scanner.close();
//        }

    }
}

