public class Menu {
    public static void menu() {
        System.out.println("----------------- Menu -----------------");
        System.out.println("\nSelecione uma opção:");
        System.out.println("1 - Cadastrar biblioteca");
        System.out.println("2 - Cadastrar livro");
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
}
