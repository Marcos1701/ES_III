import java.util.List;
import java.util.Vector;

public class App {

    public static void menu() {
        System.out.println("----------------- Menu -----------------");
        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Adicionar biblioteca");
        System.out.println("2 - Adicionar livro");
        System.out.println("3 - Acessar biblioteca");
        System.out.println("4 - Remover biblioteca");
        System.out.println("5 - Remover livro");
        System.out.println("6 - Listar bibliotecas");
        System.out.println("7 - Listar livros");
        System.out.println("8 - Alterar biblioteca");
        System.out.println("9 - Alterar livro");
        System.out.println("\n\n0 - Sair");
    }

    public static void menu_de_alteracao_livro() {

        System.out.println("------- Alterar Livro --------");
        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Alterar titulo");
        System.out.println("2 - Alterar autor");
        System.out.println("3 - Alterar editora");
        System.out.println("4 - Alterar ano");
        System.out.println("5 - Alterar tudo");
        System.out.println("\n\n0 - Sair");
    }

    public static void menu_de_alteracao_biblioteca() {

        System.out.println("------- Alterar Biblioteca --------");
        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Alterar nome");
        System.out.println("2 - alterar livros");
        System.out.println("\n\n0 - Sair");
    }

    public static void menu_de_acesso_biblioteca() {

        System.out.println("------- Acessar Biblioteca --------");
        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Acessar biblioteca por nome");
        System.out.println("2 - Acessar biblioteca por id");
        System.out.println("\n\n0 - Sair");
    }

    public static void menu_de_remocao_livro() {

        System.out.println("------- Remover Livro --------");
        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Remover livro por titulo");
        System.out.println("2 - Remover livro por id");
        System.out.println("\n\n0 - Sair");
    }

    public static void menu_de_remocao_biblioteca() {

        System.out.println("------- Remover Biblioteca --------");
        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Remover biblioteca por nome");
        System.out.println("2 - Remover biblioteca por id");
        System.out.println("\n\n0 - Sair");
    }

    public static int getValidOption(int min, int max) {
        boolean invalid_option = false;
        int opcao = 0;
        try {
            opcao = Integer.parseInt(System.console().readLine("=> "));
        } catch (NumberFormatException e) {
            invalid_option = true;
        }

        while (invalid_option || opcao < min || opcao > max) {
            System.out.println("Opção inválida");
            System.out.println("Digite a opção desejada: ");
            invalid_option = false;
            try {
                opcao = Integer.parseInt(System.console().readLine("=> "));
            } catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    invalid_option = true;
                }
            }
        }

        return opcao;
    }

    public static String getValidString() {
        String string = System.console().readLine("=> ");

        String aux = string.replaceAll("\\s+", "");

        while (aux.length() == 0) {
            System.out.println("String inválida");
            System.out.println("Digite novamente: ");
            string = System.console().readLine("=> ");
            aux = string.replaceAll("\\s+", "");
        }

        return string;
    }

    public static int getValidInt() {
        boolean invalid_option = false;
        int value = 0;
        try {
            value = Integer.parseInt(System.console().readLine("=> "));
        } catch (Exception e) {
            if (e instanceof NumberFormatException) {
                invalid_option = true;
            }
        }

        while (invalid_option) {
            System.out.println("Opção inválida");
            System.out.println("Digite a opção desejada: ");
            invalid_option = false;
            try {
                value = Integer.parseInt(System.console().readLine("=> "));
            } catch (NumberFormatException e) {
                invalid_option = true;
            }
        }

        return value;
    }

    public static void main(String[] args) throws Exception {

        abstract class Pessoa {

            private String nome;

            public Pessoa(String nome) {
                this.nome = nome;
            }

            public String getNome() {
                return this.nome;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }
        }

        class autor extends Pessoa {

            private int id;

            public autor(int id, String nome) {
                super(nome);
                this.id = id;
            }

            public int getId() {
                return this.id;
            }

        }
        interface Ilivro {
            public int getId();

            public String getTitulo();

            public autor getAutor();

            public String getEditora();

            public int getAno();

            public void setTitulo(String titulo);

            public void setAutor(autor autor);

            public void setEditora(String editora);

            public void setAno(int ano);
        }

        class Livro implements Ilivro {
            int id;
            String titulo;
            autor autor;
            String editora;
            int ano;

            public Livro(int id, autor Autor, String titulo, String editora, int ano) {
                this.id = id;
                this.titulo = titulo;
                this.autor = Autor;
                this.editora = editora;
                this.ano = ano;
            }

            public int getId() {
                return this.id;
            }

            public String getTitulo() {
                return this.titulo;
            }

            public autor getAutor() {
                return this.autor;
            }

            public String getEditora() {
                return this.editora;
            }

            public int getAno() {
                return this.ano;
            }

            public void setTitulo(String titulo) {
                this.titulo = titulo;
            }

            public void setAutor(autor autorLivro) {
                this.autor = autorLivro;
            }

            public void setEditora(String editora) {
                this.editora = editora;
            }

            public void setAno(int ano) {
                this.ano = ano;
            }

            public String toString() {
                return "ID: " + this.id + "\nTitulo: " + this.titulo + "\nAutor: " + this.autor + "\nEditora: "
                        + this.editora + "\nAno: "
                        + this.ano;
            }
        }

        interface IBiblioteca {
            public int getId();

            public String getNome();

            public Vector<Livro> getLivros();

            public void setNome(String nome);

            public void setLivros(Vector<Livro> livros);

            public void addLivro(String titulo, autor autor, String editora, int ano);

            public void removeLivro(int idLivro);

            public void removeLivro(String titulo);
        }

        class Biblioteca implements IBiblioteca {
            int id;
            String nome;
            Vector<Livro> livros = new Vector<Livro>();
            int idLivro = 1;

            public Biblioteca(int id, String nome) {
                this.id = id;
                this.nome = nome;
            }

            public int getId() {
                return this.id;
            }

            public String getNome() {
                return this.nome;
            }

            public Vector<Livro> getLivros() {
                return this.livros;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }

            public void setLivros(Vector<Livro> livros) {
                this.livros = livros;
            }

            private boolean livroExiste(String titulo) {
                for (Livro l : this.livros) {
                    if (l.getTitulo().equals(titulo)) {
                        return true;
                    }
                }
                return false;
            }

            private boolean livroExiste(int idLivro) {
                for (Livro l : this.livros) {
                    if (l.getId() == idLivro) {
                        return true;
                    }
                }
                return false;
            }

            public void addLivro(String titulo, autor autor, String editora, int ano) {
                if (livroExiste(titulo)) {
                    System.out.println("Livro já existe");
                    return;
                }
                Livro livro = new Livro(this.idLivro, autor, titulo, editora, ano);
                this.livros.add(livro);
                this.idLivro++;
                System.out.println("Livro adicionado com sucesso");
            }

            public void removeLivro(int idLivro) {

                boolean livroExiste = false;
                for (Livro l : this.livros) {
                    if (l.getId() == idLivro) {
                        this.livros.remove(l);
                        System.out.println("Livro removido com sucesso");
                        livroExiste = true;
                        break;
                    }
                }
                if (!livroExiste) {
                    System.out.println("Livro não existe");
                }
            }

            public void removeLivro(String titulo) {
                boolean livroExiste = false;
                for (Livro l : this.livros) {
                    if (l.getTitulo().equals(titulo)) {
                        livroExiste = true;
                        this.livros.remove(l);
                        System.out.println("Livro removido com sucesso");
                        break;
                    }
                }
                if (!livroExiste) {
                    System.out.println("Livro não existe");
                }
            }

            public String toString() {
                return "ID: " + this.id + "\nNome: " + this.nome + "\nLivros: " + this.livros;
            }
        }

        Vector<Biblioteca> bibliotecas = new Vector<Biblioteca>();

        System.out.println("Seja bem vindo ao sistema de biblioteca");
        System.out.println("Digite o seu nome: ");
        String nome = System.console().readLine("=> ");
        Pessoa pessoa = new Pessoa(nome);
        menu();

        System.out.println("Digite a opção desejada: ");
        int opcao = getValidOption(0, 5);

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o titulo do livro: ");
                    String titulo = getValidString();
                    System.out.println("Digite o autor do livro: ");
                    String autor = getValidString();
                    System.out.println("Digite a editora do livro: ");
                    String editora = getValidString();
                    System.out.println("Digite o ano do livro: ");
                    int ano = getValidInt();
                    pessoa.addLivro(titulo, autor, editora, ano);
                    break;
                case 2:
                    System.out.println("Digite o id do livro: ");
                    int idLivro = getValidInt();
                    pessoa.removeLivro(idLivro);
                    break;
                case 3:
                    pessoa.listaLivros();
                    break;

                case 4:
                    System.out.println("Nome atual: " + pessoa.nome);
                    System.out.println("Digite o novo nome: ");
                    String novoNome = getValidString();
                    pessoa.nome = novoNome;
                    break;

                case 5:
                    pessoa.listaLivros();
                    System.out.println("Digite o id do livro: ");
                    int idLivro2 = getValidInt();

                    while (pessoa.conferenciaLivro(idLivro2)) {
                        System.out.println("Livro não encontrado");
                        String op = System.console().readLine("Deseja continuar? (s/n)");
                        if (op.equals("n")) {
                            break;
                        }

                        pessoa.listaLivros();
                        System.out.println("Digite o id do livro: ");
                        idLivro2 = getValidInt();
                    }

                    if (pessoa.conferenciaLivro(idLivro2)) {
                        break;
                    }

                    menu_de_alteracao_livro();
                    System.out.println("Digite a opção desejada: ");
                    Livro livro = pessoa.getLivro(idLivro2);
                    int opcao2 = getValidOption(0, 5);

                    switch (opcao2) {
                        case 1:
                            System.out.println("Titulo atual: " + livro.getTitulo());
                            System.out.println("Digite o novo titulo: ");
                            String novoTitulo = getValidString();
                            livro.setTitulo(novoTitulo);
                            break;
                        case 2:
                            System.out.println("Autor atual: " + livro.getAutor());
                            System.out.println("Digite o novo autor: ");
                            String novoAutor = getValidString();
                            livro.setAutor(novoAutor);
                            break;
                        case 3:
                            System.out.println("Editora atual: " + livro.getEditora());
                            System.out.println("Digite a nova editora: ");
                            String novaEditora = getValidString();
                            livro.setEditora(novaEditora);
                            break;
                        case 4:
                            System.out.println("Ano atual: " + livro.getAno());
                            System.out.println("Digite o novo ano: ");
                            int novoAno = getValidInt();
                            livro.setAno(novoAno);
                            break;

                        case 5:
                            System.out.println("Titulo atual: " + livro.getTitulo());
                            System.out.println("Digite o novo titulo: ");
                            String novoTitulo2 = getValidString();
                            livro.setTitulo(novoTitulo2);
                            System.out.println("Autor atual: " + livro.getAutor() + "\n");
                            System.out.println("Digite o novo autor: ");
                            String novoAutor2 = getValidString();
                            livro.setAutor(novoAutor2);
                            System.out.println("Editora atual: " + livro.getEditora());
                            System.out.println("Digite a nova editora: ");
                            String novaEditora2 = getValidString();
                            livro.setEditora(novaEditora2);
                            System.out.println("Ano atual: " + livro.getAno());
                            System.out.println("Digite o novo ano: ");
                            int novoAno2 = getValidInt();
                            livro.setAno(novoAno2);
                            break;

                        default:
                            break;
                    }

                default:
                    break;
            }

            menu();
            System.out.println("Digite a opção desejada: ");
            opcao = getValidOption(0, 5);
        }

        System.out.println("\n\n Já vais tarde ;)");
    }
}
