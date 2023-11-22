### 3°) Aplique o princípio LSP à implementação abaixo de forma que persistência seja um atributo da segunda classe. Crie um exemplo real com o resultado da refatoração.

```java
import java.io.*;

public class Persistencia {
    public void salvar(String dados, String arquivo) throws IOException {
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write(dados);
        }
    }
}
    
public class PersistenciaJSON extends Persistencia {
    @Override
    public void salvar(String dados, String arquivo) throws IOException {
        if (!dados.startsWith("{")) {
            throw new
                IllegalArgumentException("Dados não estão em formato JSON.");
        }
        super.salvar(dados, arquivo);
    }
}
```

### Solução:

```java	
import java.io.*;

public class Persistencia {
    public void salvar(String dados, String arquivo) throws IOException {
        try (FileWriter writer = new FileWriter(arquivo)) {
            writer.write(dados);
        }
    }
}

public class PersistenciaJSON{
    private Persistencia persistencia;

    public PersistenciaJSON(){
        this.persistencia = new Persistencia();
    }

    public void salvar(String dados, String arquivo) throws IOException {
        if (!dados.startsWith("{")) {
            throw new
                IllegalArgumentException("Dados não estão em formato JSON.");
        }
        this.persistencia.salvar(dados, arquivo);
    }

    // testando
    public static void main(String[] args) throws IOException {
        PersistenciaJSON persistencia = new PersistenciaJSON();
        persistencia.salvar("{\"nome\": \"João\", \"idade\": 25}", "joao.json");
        System.out.println("Arquivos salvos com sucesso.");
    }
}
```