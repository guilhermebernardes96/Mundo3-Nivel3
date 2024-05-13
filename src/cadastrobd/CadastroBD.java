package cadastrobd;

import cadastro.model.PessoaFisicaDAO;
import cadastro.model.PessoaJuridicaDAO;
import cadastrobd.model.Pessoa;
import cadastrobd.model.PessoaFisica;
import cadastrobd.model.PessoaJuridica;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.List;

public class CadastroBD {
    public static void main(String[] args) throws SQLException {
        int opcao;
        PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
        PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
        Scanner scanner = new Scanner(System.in);
        String tipoPessoa;
        
        do {
            System.out.println("=================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("0 - Finalizar Programa");
            System.out.println("=================================");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    tipoPessoa = scanner.nextLine().toUpperCase();
            
                    if (tipoPessoa.equals("F")) {
                        System.out.println("Insira os dados: ");
                        System.out.print("NOME: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("LOGRADOURO: ");
                        String logradouro = scanner.nextLine();
                        System.out.print("CIDADE: ");
                        String cidade = scanner.nextLine();
                        System.out.print("ESTADO: ");
                        String estado = scanner.nextLine();
                        System.out.print("TELEFONE: ");
                        String telefone = scanner.nextLine();
                        System.out.print("E-MAIL: ");
                        String email = scanner.nextLine();

                        PessoaFisica pessoaFisica = new PessoaFisica(00, nome, logradouro, cidade, estado, telefone, email, cpf);

                        try {
                            pessoaFisicaDAO.incluir(pessoaFisica);
                        } catch (SQLException e) {
                            System.out.println("Erro ao incluir: " + e.getMessage());
                        }
                    } else if (tipoPessoa.equals("J")) {                    
                        System.out.println("Insira os dados: ");
                        System.out.print("NOME: ");
                        String nome = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();
                        System.out.print("LOGRADOURO: ");
                        String logradouro = scanner.nextLine();
                        System.out.print("CIDADE: ");
                        String cidade = scanner.nextLine();
                        System.out.print("ESTADO: ");
                        String estado = scanner.nextLine();
                        System.out.print("TELEFONE: ");
                        String telefone = scanner.nextLine();
                        System.out.print("E-MAIL: ");
                        String email = scanner.nextLine();

                        PessoaJuridica pessoaJuridica = new PessoaJuridica(00, nome, logradouro, cidade, estado, telefone, email, cnpj);

                        try {
                            pessoaJuridicaDAO.incluir(pessoaJuridica);
                        } catch (SQLException e) {
                            System.out.println("Erro ao incluir: " + e.getMessage());
                        }
                    }
                    break;
                case 2:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    tipoPessoa = scanner.nextLine().toUpperCase();
            
                    System.out.println("Insira o Id que será alterado: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoPessoa.equals("F")) {
                        System.out.println("INSIRA OS NOVOS DADOS: ");
                        System.out.print("NOME: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("LOGRADOURO: ");
                        String logradouro = scanner.nextLine();
                        System.out.print("CIDADE: ");
                        String cidade = scanner.nextLine();
                        System.out.print("ESTADO: ");
                        String estado = scanner.nextLine();
                        System.out.print("TELEFONE: ");
                        String telefone = scanner.nextLine();
                        System.out.print("E-MAIL: ");
                        String email = scanner.nextLine();
                        PessoaFisica pessoaFisica = pessoaFisicaDAO.getPessoa(id);

                        try {
                            pessoaFisica.setNome(nome);
                            pessoaFisica.setCpf(cpf);
                            pessoaFisica.setLogradouro(logradouro);
                            pessoaFisica.setCidade(cidade);
                            pessoaFisica.setEstado(estado);
                            pessoaFisica.setTelefone(telefone);
                            pessoaFisica.setEmail(email);
                            pessoaFisicaDAO.alterar(pessoaFisica);
                        } catch (SQLException e) {
                            System.out.println("Erro ao alterar: " + e.getMessage());
                        }
                    } else if (tipoPessoa.equals("J")) {
                        System.out.print("NOME: ");
                        String nome = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();
                        System.out.print("LOGRADOURO: ");
                        String logradouro = scanner.nextLine();
                        System.out.print("CIDADE: ");
                        String cidade = scanner.nextLine();
                        System.out.print("ESTADO: ");
                        String estado = scanner.nextLine();
                        System.out.print("TELEFONE: ");
                        String telefone = scanner.nextLine();
                        System.out.print("E-MAIL: ");
                        String email = scanner.nextLine();
                        PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.getPessoa(id);

                        try {
                            pessoaJuridica.setNome(nome);
                            pessoaJuridica.setCnpj(cnpj);
                            pessoaJuridica.setLogradouro(logradouro);
                            pessoaJuridica.setCidade(cidade);
                            pessoaJuridica.setEstado(estado);
                            pessoaJuridica.setTelefone(telefone);
                            pessoaJuridica.setEmail(email);
                            pessoaJuridicaDAO.alterar(pessoaJuridica);
                        } catch (SQLException e) {
                            System.out.println("Erro ao alterar: " + e.getMessage());
                        }
                    }
                    break;
                case 3:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    tipoPessoa = scanner.nextLine().toUpperCase();

                    System.out.println("Insira o ID da pessoa que será excluido: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoPessoa.equals("F")) {
                        try {
                            pessoaFisicaDAO.excluir(idExcluir);
                            System.out.println("Pessoa fisica excluida com sucesso.");
                        } catch (SQLException e) {
                            System.out.println("Erro ao excluir: " + e.getMessage());
                        }
                    } else if (tipoPessoa.equals("J")) {
                        try {
                            pessoaJuridicaDAO.excluir(idExcluir);
                            System.out.println("Pessoa juridica excluida com sucesso.");
                        } catch (SQLException e) {
                            System.out.println("Erro ao excluir: " + e.getMessage());
                        }
                    }
                    break;
                case 4:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    tipoPessoa = scanner.nextLine().toUpperCase();

                    System.out.println("Insira o ID da pessoa que será buscada: ");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoPessoa.equals("F")) {
                        try {
                            PessoaFisica pessoaFisica = pessoaFisicaDAO.getPessoa(idBuscar);
                            if (pessoaFisica != null) {
                                System.out.println("Dados da Pessoa Fisica: ");
                                System.out.println("ID: " + pessoaFisica.getId());
                                System.out.println("NOME: " + pessoaFisica.getNome());
                                System.out.println("CPF: " + pessoaFisica.getCpf());
                                System.out.println("LOGRADOURO: " + pessoaFisica.getLogradouro());
                                System.out.println("CIDADE: " + pessoaFisica.getCidade());
                                System.out.println("ESTADO: " + pessoaFisica.getEstado());
                                System.out.println("TELEFONE: " + pessoaFisica.getTelefone());
                                System.out.println("E-MAIL: " + pessoaFisica.getEmail());
                                
                            } else {
                                System.out.println("Pessoa fisica não encontrada.");
                            }
                        } catch (SQLException e) {
                            System.out.println("Erro ao buscar pessoa fisica: " + e.getMessage());
                        }
                    } else if (tipoPessoa.equals("J")) {
                        try {
                            PessoaJuridica pessoaJuridica = pessoaJuridicaDAO.getPessoa(idBuscar);
                            if (pessoaJuridica != null) {
                                System.out.println("Dados da Pessoa Jurídica:");
                                System.out.println("ID: " + pessoaJuridica.getId());
                                System.out.println("NOME: " + pessoaJuridica.getNome());
                                System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
                                System.out.println("LOGRADOURO: " + pessoaJuridica.getLogradouro());
                                System.out.println("CIDADE: " + pessoaJuridica.getCidade());
                                System.out.println("ESTADO: " + pessoaJuridica.getEstado());
                                System.out.println("TELEFONE: " + pessoaJuridica.getTelefone());
                                System.out.println("E-MAIL: " + pessoaJuridica.getEmail());
                                
                            } else {
                                System.out.println("Pessoa juridica não encontrada.");
                            }
                        } catch (SQLException e) {
                            System.out.println("Erro ao buscar pessoa juridica: " + e.getMessage());
                        }
                    }
                    break;
                case 5:
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    tipoPessoa = scanner.nextLine().toUpperCase();
                    
                    if (tipoPessoa.equals("F")) {
                        try {
                            List<PessoaFisica> pessoasFisicas = pessoaFisicaDAO.getPessoas();
                            if (!pessoasFisicas.isEmpty()) {
                                System.out.println("Dados de todas as Pessoas Fisicas:");
                                for (PessoaFisica pessoa : pessoasFisicas) {
                                    System.out.println("ID: " + pessoa.getId());
                                    System.out.println("Nome: " + pessoa.getNome());
                                    System.out.println("CPF: " + pessoa.getCpf());
                                    System.out.println("Logradouro: " + pessoa.getLogradouro());
                                    System.out.println("Cidade: " + pessoa.getCidade());
                                    System.out.println("Estado: " + pessoa.getEstado());
                                    System.out.println("Telefone: " + pessoa.getTelefone());
                                    System.out.println("Email: " + pessoa.getEmail());
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Nenhuma pessoa fisica encontrada.");
                            }
                        } catch (SQLException e) {
                            System.out.println("Erro ao buscar pessoas fisicas: " + e.getMessage());
                        }
                    } else if (tipoPessoa.equals("J")) {
                        try {
                            List<PessoaJuridica> pessoasJuridicas = pessoaJuridicaDAO.getPessoas();
                            if (!pessoasJuridicas.isEmpty()) {
                                System.out.println("Dados de todas as Pessoas Jurídicas:");
                                for (PessoaJuridica pessoa : pessoasJuridicas) {
                                    System.out.println("ID: " + pessoa.getId());
                                    System.out.println("Nome: " + pessoa.getNome());
                                    System.out.println("CNPJ: " + pessoa.getCnpj());
                                    System.out.println("Logradouro: " + pessoa.getLogradouro());
                                    System.out.println("Cidade: " + pessoa.getCidade());
                                    System.out.println("Estado: " + pessoa.getEstado());
                                    System.out.println("Telefone: " + pessoa.getTelefone());
                                    System.out.println("Email: " + pessoa.getEmail());
                                    System.out.println();
                                }
                            } else {
                                System.out.println("Nenhuma pessoa juridica encontrada.");
                            }
                        } catch (SQLException e) {
                            System.out.println("Erro ao buscar pessoas juridicas: " + e.getMessage());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

    }
    
}
