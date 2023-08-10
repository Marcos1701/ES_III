import java.util.List;
import java.util.Vector;

public class App {

    public static void main(String[] args) throws Exception {

        Vector<Biblioteca> bibliotecas = new Vector<Biblioteca>();

        System.out.println("Seja bem vindo ao sistema de biblioteca");
        System.out.println("Digite o seu nome: ");
        String nome = System.console().readLine("=> ");

        Menu.menu();

        System.out.println("Digite a opção desejada: ");
        int opcao = utils.getValidOption(0, 5);

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o titulo do livro: ");
                    String titulo = utils.getValidString();
                    System.out.println("Digite o autor do livro: ");
                    String autor = utils.getValidString();
                    System.out.println("Digite a editora do livro: ");
                    String editora = utils.getValidString();
                    System.out.println("Digite o ano do livro: ");
                    int ano = utils.getValidInt();
                    break;
                case 2:
                    System.out.println("Digite o id do livro: ");
                    int idLivro = utils.getValidInt();
                    break;
                case 3:
                    break;

                case 4:
                    System.out.println("Digite o novo nome: ");
                    String novoNome = utils.getValidString();
                    break;

                case 5:
                    System.out.println("Digite o id do livro: ");
                    int idLivro2 = utils.getValidInt();

                    // while (pessoa.conferenciaLivro(idLivro2)) {
                    System.out.println("Livro não encontrado");
                    String op = System.console().readLine("Deseja continuar? (s/n)");
                    if (op.equals("n")) {
                        break;
                    }

                    // pessoa.listaLivros();
                    System.out.println("Digite o id do livro: ");
                    idLivro2 = utils.getValidInt();
                    // }

                    if (pessoa.conferenciaLivro(idLivro2)) {
                        break;
                    }

                    Menu.menu_de_alteracao_livro();
                    System.out.println("Digite a opção desejada: ");
                    // Livro livro = pessoa.getLivro(idLivro2);
                    int opcao2 = utils.getValidOption(0, 5);

                    switch (opcao2) {
                        case 1:
                            System.out.println("Titulo atual: " + livro.getTitulo());
                            System.out.println("Digite o novo titulo: ");
                            String novoTitulo = utils.getValidString();
                            livro.setTitulo(novoTitulo);
                            break;
                        case 2:
                            System.out.println("Autor atual: " + livro.getAutor());
                            System.out.println("Digite o novo autor: ");
                            String novoAutor = utils.getValidString();
                            // livro.setAutor(novoAutor);
                            break;
                        case 3:
                            System.out.println("Editora atual: " + livro.getEditora());
                            System.out.println("Digite a nova editora: ");
                            String novaEditora = utils.getValidString();
                            livro.setEditora(novaEditora);
                            break;
                        case 4:
                            System.out.println("Ano atual: " + livro.getAno());
                            System.out.println("Digite o novo ano: ");
                            int novoAno = utils.getValidInt();
                            livro.setAno(novoAno);
                            break;

                        case 5:
                            System.out.println("Titulo atual: " + livro.getTitulo());
                            System.out.println("Digite o novo titulo: ");
                            String novoTitulo2 = utils.getValidString();
                            livro.setTitulo(novoTitulo2);
                            System.out.println("Autor atual: " + livro.getAutor() + "\n");
                            System.out.println("Digite o novo autor: ");
                            String novoAutor2 = utils.getValidString();
                            // livro.setAutor(novoAutor2);
                            System.out.println("Editora atual: " + livro.getEditora());
                            System.out.println("Digite a nova editora: ");
                            String novaEditora2 = utils.getValidString();
                            livro.setEditora(novaEditora2);
                            System.out.println("Ano atual: " + livro.getAno());
                            System.out.println("Digite o novo ano: ");
                            int novoAno2 = utils.getValidInt();
                            livro.setAno(novoAno2);
                            break;

                        default:
                            break;
                    }

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
