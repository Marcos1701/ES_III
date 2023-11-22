import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static class Persistencia {
        public void salvar(String dados, String arquivo) throws IOException {
            try (FileWriter writer = new FileWriter(arquivo)) {
                writer.write(dados);
            }
        }
    }

    public static class PersistenciaJSON {
        private final Persistencia persistencia;

        public PersistenciaJSON() {
            this.persistencia = new Persistencia();
        }

        public void salvar(String dados, String arquivo) throws IOException {
            if (!dados.startsWith("{")) {
                throw new IllegalArgumentException("Dados não estão em formato JSON.");
            }
            this.persistencia.salvar(dados, arquivo);
        }
    }

    public static void main(String[] args) throws IOException {
        PersistenciaJSON persistencia = new PersistenciaJSON();
        persistencia.salvar("{\"nome\": \"João\", \"idade\": 25}", "joao.json");
        System.out.println("Arquivos salvos com sucesso.");
    }
}
