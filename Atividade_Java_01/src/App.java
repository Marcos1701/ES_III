/*
 Membros: 
- Marcos Eduardo
- Gabriel Amaral
- Daniel Luca
 */

import java.util.Vector;

public class App {

    public static void main(String[] args) throws Exception {

        Vector<Biblioteca> bibliotecas = new Vector<Biblioteca>();
        Vector<Livro> livros = new Vector<Livro>();
        Vector<autor> autores = new Vector<autor>();
        int id_a = 1;
        System.out.println("Olá, seja bem vindo...");

        Menu.menu();

        System.out.println("Digite a opção desejada: ");
        int opcao = utils.getValidOption(0, 9);
        int id = 1;

        while (opcao != 0) {
            switch (opcao) {
                case 1: // Cadastrar biblioteca
                    System.out.println("Digite o nome da biblioteca: ");
                    String nome = utils.getValidString();
                    Biblioteca biblioteca = new Biblioteca(id, nome);
                    id++;
                    bibliotecas.add(biblioteca);
                    System.out.println("Biblioteca cadastrada com sucesso!");
                    // Limpar console
                    utils.clearConsole(); // Não sei se funciona em todos os sistemas operacionais...

                    break;
                case 2: // Cadastrar livro
                    System.out.println("Digite o titulo do livro: ");
                    String titulo = utils.getValidString();
                    System.out.println("Digite o autor do livro: ");
                    String Nome_autor = utils.getValidString();
                    autor autor = utils.confereAutor(Nome_autor, autores);
                    if (autor == null) {
                        autor = new autor(id_a, Nome_autor);
                        autores.add(autor);
                        id_a++;
                    }
                    System.out.println("Digite a editora do livro: ");
                    String editora = utils.getValidString();
                    System.out.println("Digite o ano do livro: ");
                    int ano = utils.getYear();
                    Livro livro = new Livro(id, autor, titulo, editora, ano);
                    id++;
                    livros.add(livro);
                    System.out.println("Livro cadastrado com sucesso!");
                    // Limpar console
                    utils.clearConsole(); // Não sei se funciona em todos os sistemas operacionais...
                    break;
                case 3: // Acessar Biblioteca

                    utils.printBibliotecas(bibliotecas);
                    System.out.println("Digite o id da biblioteca: ");
                    int id_B = utils.getValidInt();
                    Biblioteca bibliotecaSelecionada = null;

                    for (Biblioteca b : bibliotecas) {
                        if (b.getId() == id_B) {
                            bibliotecaSelecionada = b;
                            break;
                        }
                    }

                    if (bibliotecaSelecionada == null) {
                        System.out.println("Ops, nenhuma biblioteca foi encontrada..");
                        break;
                    }
                    System.console().readLine("precione <enter> para continuar");
                    Menu.menu_biblioteca();
                    int op = utils.getValidOption(0, 5);

                    while (op != 0) {
                        if (op == 1) {
                            utils.printbiblioteca(bibliotecaSelecionada);
                        } else if (op == 2) {
                            System.out.println("\nLivros: ");
                            utils.printLivros(bibliotecaSelecionada.getLivros());
                        } else if (op == 3) {
                            System.out.println("\nDigite o id do Livro: ");
                            int id_L = utils.getValidInt();
                            bibliotecaSelecionada.removeLivro(id_L);
                        } else if (op == 4) {
                            System.out.println("Acervo de Livros: ");
                            utils.printLivros(livros);
                            System.out.println("Digite o id do Livro: ");
                            int id_Livro = utils.getValidInt();

                            if (bibliotecaSelecionada.livroExiste(id_Livro)) {
                                System.out.println("Ops, este Livro já está presente na biblioteca selecionada..");
                                continue;
                            }

                            Livro LivroSelecionado = utils.getLivro(id_Livro, livros);
                            bibliotecaSelecionada.addLivro(LivroSelecionado);
                        } else if (op == 5) {
                            Menu.menu_de_alteracao_biblioteca();
                            int op2 = utils.getValidOption(0, 1);

                            if (op2 == 1) {
                                System.out.println("Digite o novo nome: ");
                                String new_name = utils.getValidString();
                                bibliotecaSelecionada.setNome(new_name);

                                System.out.println("Nome alterado com sucesso!!");
                            }

                        } else if (op == 6) {
                            utils.removeBiblioteca(id_B, bibliotecas);
                        } else {
                            break;
                        }

                        System.console().readLine("precione <enter> para continuar");
                        utils.clearConsole();
                        Menu.menu_biblioteca();
                        op = utils.getValidInt();
                    }
                    break;

                case 4:
                    System.out.println("Livros do Acervo: ");
                    utils.printLivros(livros);
                    System.out.println("Digite o id do Livro: ");
                    int id_livro = utils.getValidInt();
                    utils.removeLivro(id_livro, livros);
                    break;

                case 5:
                    System.out.println("Bibliotecas cadastradas: ");
                    utils.printBibliotecas(bibliotecas);
                    break;
                case 6:
                    System.out.println("Livros cadastrados: ");
                    utils.printLivros(livros);
                case 7:
                    System.out.println("Livros do Acervo: ");
                    utils.printLivros(livros);
                    System.out.println("Digite o id do Livro: ");
                    int id_livr = utils.getValidInt();
                    if (utils.confereLivro(id_livr, livros) == null) {
                        System.out.println("Livro não encontrado...");
                        break;
                    }

                    System.out.println("Certo, agora selecione um das opções abaixo: ");
                    Menu.menu_de_alteracao_livro();
                    int op1 = utils.getValidOption(0, 5);

                    int indexLivro = 0;

                    for (int i = 0; i < livros.size(); i++) {
                        if (livros.elementAt(i).getId() == id_livr) {
                            indexLivro = i;
                            break;
                        }
                    }

                    switch (op1) {
                        case 1:
                            System.out.println("Digite o novo título: ");
                            String title = utils.getValidString();
                            livros.elementAt(indexLivro).setTitulo(title);

                            for (Biblioteca b : bibliotecas) {
                                b.alterarLivro(id_livr, title, null, null, -1);
                            }
                        case 2:
                            System.out.println("Digite o nome do novo autor: ");
                            String name = utils.getValidString();
                            autor new_autor = new autor(id_a, name);
                            livros.elementAt(indexLivro).setAutor(new_autor);

                            for (Biblioteca b : bibliotecas) {
                                b.alterarLivro(id_livr, null, new_autor, null, -1);
                            }
                        case 3:
                            System.out.println("Digite a nova editora: ");
                            String edit = utils.getValidString();
                            livros.elementAt(indexLivro).setEditora(edit);

                            for (Biblioteca b : bibliotecas) {
                                b.alterarLivro(id_livr, null, null, edit, -1);
                            }
                        case 4:
                            System.out.println("Digite o novo título: ");
                            int age = utils.getValidInt();
                            livros.elementAt(indexLivro).setAno(age);

                            for (Biblioteca b : bibliotecas) {
                                b.alterarLivro(id_livr, null, null, null, age);
                            }
                        case 5:
                            System.out.println("Digite o novo título: ");
                            String new_title = utils.getValidString();
                            System.out.println("Digite o nome do novo autor: ");
                            String name_autor = utils.getValidString();
                            autor newautor = new autor(id_a, name_autor);
                            System.out.println("Digite a nova editora: ");
                            String Editora = utils.getValidString();
                            System.out.println("Digite o novo título: ");
                            int new_age = utils.getValidInt();
                            livros.elementAt(indexLivro).setTitulo(new_title);
                            livros.elementAt(indexLivro).setAutor(newautor);
                            livros.elementAt(indexLivro).setEditora(Editora);
                            livros.elementAt(indexLivro).setAno(new_age);

                            for (Biblioteca b : bibliotecas) {
                                b.alterarLivro(id_livr, new_title, newautor, Editora, new_age);
                            }
                            break;

                        default:
                            break;

                    }

                default:
                    break;
            }

            System.console().readLine("precione <enter> para continuar");
            utils.clearConsole();
            Menu.menu();
            System.out.println("Digite a opção desejada: ");
            opcao = utils.getValidOption(0, 9);
        }

        System.out.println("\n\n Já vais tarde ;)");
    }
}
