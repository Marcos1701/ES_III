import java.sql.Date;
import java.util.List;
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

                    for(Biblioteca b : bibliotecas){
                        if(b.getId() == id_B){
                            bibliotecaSelecionada = b;
                            break;
                        }
                    }

                    if(bibliotecaSelecionada == null){
                        System.out.println("Ops, nenhuma biblioteca foi encontrada..");
                        break;
                    }
                    Menu.menu_biblioteca();
                    int op = utils.getValidOption(0, 5);

                    while(op != 0){
                        if(op == 1){
                            utils.printbiblioteca(bibliotecaSelecionada);
                        }else if(op == 2){
                            System.out.println("\nLivros: ");
                            utils.printLivros(bibliotecaSelecionada.getLivros());
                        }else if(op == 3){
                            System.out.println("\nDigite o id do Livro: ");
                            int id_L = utils.getValidInt();
                            bibliotecaSelecionada.removeLivro(id_L);
                        }else if(op == 4){
                            System.out.println("Acervo de Livros: ");
                            utils.printLivros(livros);
                            System.out.println("Digite o id do Livro: ")
                            int id_Livro = utils.getValidInt();

                            if(bibliotecaSelecionada.livroExiste(id_Livro)){
                                System.out.println("Ops, este Livro já está presente na biblioteca selecionada..");
                                continue;
                            }

                            Livro LivroSelecionado = utils.getLivro(id_Livro, livros);
                            biblioteca.addLivro(titulo, autor, editora, ano);
                        }else if(op == 5){
                            Menu.menu_de_alteracao_biblioteca();
                            int op2 = utils.getValidOption(0, 1);

                            if(op == 1){
                                System.out.println("Digite o novo nome: ");
                                String new_name = utils.getValidString();
                                bibliotecaSelecionada.setNome(new_name);

                                System.out.println("Nome alterado com sucesso!!");
                            }

                        }
                    }

                case 4:
                    break;

                case 5:
                    break;
                default:
                    break;
            }

            Menu.menu();
            System.out.println("Digite a opção desejada: ");
            opcao = utils.getValidOption(0, 5);
        }

        System.out.println("\n\n Já vais tarde ;)");
    }
}
