import java.util.List;

public class Usuarios {

    abstract public class Conteudo {
        private String conteudo;

        public Conteudo(String conteudo) {
            this.conteudo = conteudo;
        }

        public String getConteudo() {
            return conteudo;
        }
    }

    public class Post extends Conteudo {
        public Post(String conteudo) {
            super(conteudo);
        }
    }

    public class Comentario extends Conteudo {
        public Comentario(String conteudo) {
            super(conteudo);
        }
    }

    public class Usuario {
        private List<Conteudo> conteudos;

        public void addConteudo(Conteudo conteudo) {
            conteudos.add(conteudo);
        }
    }
}
