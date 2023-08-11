import java.util.Vector;

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

    public boolean livroExiste(int idLivro) {
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

    public void addLivro(Livro livro) {
        if (livroExiste(livro.getId())) {
            System.out.println("Livro já existe");
            return;
        }
        this.livros.add(livro);
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

    public void alterarLivro(int id,String titulo , autor autor, String editora, int ano){
        int index = -1;
        for (int i = 0; i < this.livros.size(); i++) {
            if(this.livros.elementAt(i).getId() == id){
                index = i;
            }
        }
        if(index == -1){System.out.println("Livro não encontrado.");}

        if(titulo != null){
            this.livros.elementAt(index).setTitulo(titulo);
        }
        if(autor != null){
            this.livros.elementAt(index).setAutor(autor);
        }
        if(editora != null){
            this.livros.elementAt(index).setEditora(editora);
        }
        if(ano != -1 && ano > 0 && ano <= utils.getYear()){
            this.livros.elementAt(index).setAno(ano);
        }
    }


    public String toString() {
        return "ID: " + this.id + "\nNome: " + this.nome;
    }
}
