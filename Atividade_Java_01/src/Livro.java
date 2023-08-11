
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
