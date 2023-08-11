import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class utils {
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

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static boolean validYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        return year >= 0 && year <= cal.get(Calendar.YEAR);
    }

    public static int getYear() {
        boolean invalid_option = false;
        int value = 0;
        try {
            value = Integer.parseInt(System.console().readLine("=> "));
        } catch (Exception e) {
            if (e instanceof NumberFormatException) {
                invalid_option = true;
            }
        }

        while (invalid_option || !validYear(value)) {
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

    public static autor confereAutor(String nome, Vector<autor> autores) {
        for (autor autor : autores) {
            if (autor.getNome().equals(nome)) {
                return autor;
            }
        }
        return null;
    }

    public static void printAutores(Vector<autor> autores) {
        for (autor autor : autores) {
            System.out.println(autor.getNome());
        }
    }

    public static Livro getLivro(int id, Vector<Livro> livros){
        for(Livro l : livros){
            if(l.getId() == id){
                return l;
            }
        }
        return null;
    }

    public static boolean LivroExistente(int id_Livro, Vector<Livro> livros){
        for(Livro l : livros){
            if(l.getId() == id_Livro){
                return true;
            }
        }
        return false;
    }

    public static void printBibliotecas(Vector<Biblioteca> bibliotecas){
        for(Biblioteca b : bibliotecas){
            System.out.println(b.toString());
            System.out.println("\nLivros: ");
            printLivros(b.getLivros());
        }
    }

    public static void printbiblioteca(Biblioteca b){
        if(!(b instanceof Biblioteca)){
            System.out.println("Biblioteca inválida");
            return;
        }
        System.out.println(b.toString());
        System.out.println("\nLivros: ");
        printLivros(b.getLivros());
    }

    public static void printLivros(Vector<Livro> livros) {
        for (Livro livro : livros) {
            System.out.println(livro.getTitulo());
        }
    }

    public static Livro confereLivro(String titulo, Vector<Livro> livros) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public static void printLivrosAutor(autor autor, Vector<Livro> livros) {
        for (Livro livro : livros) {
            if (livro.getAutor().getNome().equals(autor.getNome())) {
                System.out.println(livro.getTitulo());
            }
        }
    }

    public static Biblioteca confereBiblioteca(String nome, Vector<Biblioteca> bibliotecas) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getNome().equals(nome)) {
                return biblioteca;
            }
        }
        return null;
    }

    public static Biblioteca confereBiblioteca(int id, Vector<Biblioteca> bibliotecas) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId() == id) {
                return biblioteca;
            }
        }
        return null;
    }

}
