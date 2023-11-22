### 5°) As classes Postagem, Reacao e Comentario possuem uma herança apenas para aproveitar alguns atributos e reescrever o método exibir().

```java
public class Perfil {
    private int id;
    private String nomeUsuario;

    public Perfil(int id, String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.id = id;
    }

    // Outros métodos
}

public class Postagem {
    private String id;
    private Perfil autor;
    private String conteudo;

    public Postagem(String id, Perfil autor, String conteudo) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
    }

    public void exibir() {
        System.out.println("Postagem [" + id + "] de " + autor.getNomeUsuario() + ": " + conteudo);
    }

    // outros métodos
}

public class Reacao extends Postagem {
    private String tipoReacao;

    public Reacao(String id, Perfil autor, String tipoReacao) {
        super(id, autor, null);
        this.tipoReacao = tipoReacao;
    }

    @Override
    public void exibir() {
        System.out.println("Reação [" + tipoReacao + "] de " + getAutor().getNomeUsuario() + " na postagem " + getId());
    }

    // outros métodos
}

public class Comentario extends Postagem {
    private Postagem postagemOriginal;

    public Comentario(String id, Perfil autor, String conteudo, Postagem postagemOriginal) {
        super(id, autor, conteudo);
        this.postagemOriginal = postagemOriginal;
    }

    @Override
    public void exibir() {
        System.out.println("Comentário de " + getAutor().getNomeUsuario() + " em resposta a postagem [" + postagemOriginal.getId() + "]: " + conteudo);
    }

    // outros métodos
}
```

### Refatore as classes de forma a:
#### a. Reacao tenha uma composição com postagem;
#### b. Comentário também tenha uma composição com postagem;
#### c. Postagem tenha uma coleção de reações e comentários;
#### d. Todos implementem a interface abaixo:

```java
public interface Publicavel {
    void exibir();
    Perfil getAutor();
}
```

### Código refatorado:

```java

public interface Publicavel {
    void exibir();
    Perfil getAutor();
}

public class Perfil {
    private int id;
    private String nomeUsuario;

    public Perfil(int id, String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.id = id;
    }

    // Outros métodos
}

public class Postagem implements Publicavel
{
    private String id;
    private Perfil autor;
    private String conteudo;
    private List<Reacao> reacoes;
    private List<Comentario> comentarios;

    public Postagem(String id, Perfil autor, String conteudo) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.reacoes = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    @Override
    public void exibir() {
        System.out.println("Postagem [" + id + "] de " + autor.getNomeUsuario() + ": " + conteudo);
    }

    @Override
    public Perfil getAutor() {
        return autor;
    }

    public void adicionarReacao(Reacao reacao) {
        this.reacoes.add(reacao);
    }

    public void adicionarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    // outros métodos
}

public class Reacao implements Publicavel
{
    private Postagem postagem;
    private String tipoReacao;

    public Reacao(Postagem postagem, String tipoReacao) {
        this.postagem = postagem;
        this.tipoReacao = tipoReacao;
    }

    @Override
    public void exibir() {
        System.out.println("Reação [" + tipoReacao + "] de " + getAutor().getNomeUsuario() + " na postagem " + getId());
    }

    @Override
    public Perfil getAutor() {
        return postagem.getAutor();
    }

    // outros métodos
}

public class Comentario implements Publicavel
{
    private Postagem postagem;
    private Postagem postagemOriginal;

    public Comentario(Postagem postagem, Postagem postagemOriginal) {
        this.postagem = postagem;
        this.postagemOriginal = postagemOriginal;
    }

    @Override
    public void exibir() {
        System.out.println("Comentário de " + getAutor().getNomeUsuario() + " em resposta a postagem [" + postagemOriginal.getId() + "]: " + conteudo);
    }

    @Override
    public Perfil getAutor() {
        return postagem.getAutor();
    }

    // outros métodos
}
```