### 4. Entenda o problema da herança entre patos e suas capacidades presentes no exemplo do link:
https://www.quora.com/What-are-some-Java-examples-for-the-OOP-principle-of-favoring-object-composition-over-inheritance
### Proponha um exemplo que também viola o LISP e exiba sua solução.


### Exemplo de problema:
```java
// comparar carro com carro de brinquedo
public class Carro {
    private String cor;
    private String modelo;
    private int ano;

    public Carro(String cor, String modelo, int ano) {
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void acelerar() {
        System.out.println("Acelerando...");
    }

    public void frear() {
        System.out.println("Freando...");
    }

    public void ligar() {
        System.out.println("Ligando...");
    }

    public void desligar() {
        System.out.println("Desligando...");
    }
}

public class CarroDeControleRemoto extends Carro { // carro de brinquedo
    public CarroDeControleRemoto(String cor, String modelo, int ano) {
        super(cor, modelo, ano);
    }

    @Override
    public void acelerar() {
        throw new RuntimeException("Carro de brinquedo não acelera.");
    }

    @Override
    public void frear() {
        throw new RuntimeException("Carro de brinquedo não freia.");
    }
}
```

### Solução para o problema:

```java
public class Carro {
    private String cor;
    private String modelo;
    private int ano;

    public Carro(String cor, String modelo, int ano) {
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void acelerar() {
        System.out.println("Acelerando...");
    }

    public void frear() {
        System.out.println("Freando...");
    }

    public void ligar() {
        System.out.println("Ligando...");
    }

    public void desligar() {
        System.out.println("Desligando...");
    }
}

public class CarroDeControleRemoto {
    private Carro carro;

    public CarroDeControleRemoto(String cor, String modelo, int ano) {
        this.carro = new Carro(cor, modelo, ano);
    }

    public void ligar() {
        this.carro.ligar();
    }

    public void desligar() {
        this.carro.desligar();
    }
}
```

Dessa forma, o `carro de controle remoto` não herda o comportamento de `acelerar` e `frear`, mas ainda pode `ligar` e `desligar`.