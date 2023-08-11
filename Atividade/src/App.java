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
                case 3:
                    Menu.menu_de_acesso_biblioteca();
                    System.out.println("Digite a opção desejada: ");
                    int opcao2 = utils.getValidOption(0, 2);

                    switch (opcao2) {
                        case 1: // acessar via nome
                    }
                    break;

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
