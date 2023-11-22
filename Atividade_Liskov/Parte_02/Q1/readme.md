### 1. Em um sistema bancário temos as seguintes classes:

``` java
public class ContaBancaria {
    private double saldo;
    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    public void depositar(double valor) { saldo += valor; }
    public void sacar(double valor) { saldo -= valor; }
}

public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 1000) {
        throw new
            RuntimeException("Não pode sacar mais de 1000 em uma poupança");

        }
        super.sacar(valor);
    }
}
```

### Por que a herança entre as classes não é justificada?

A herança entre as classes `ContaBancaria` e `ContaPoupanca` não é justificada porque a classe
`ContaPoupanca` está alterando o comportamento do método `sacar` da classe `ContaBancaria`.
Isso viola o Princípio de Substituição de Liskov, que afirma que subclasses devem ser substituíveis
por suas superclasses sem alterar o comportamento do programa.

### Qual a solução proposta?

Uma solução seria usar composição em vez de herança. Poderíamos criar uma interface `Conta` com os métodos `depositar` e `sacar`, e então teríamos classes `ContaBancaria` e `ContaPoupanca` que 
implementam essa interface. A `ContaPoupanca` poderia ter uma instância de `ContaBancaria` e usar
seus métodos, adicionando as restrições específicas de `ContaPoupanca` no método `sacar`.

```java
public interface Conta {
    void depositar(double valor);
    void sacar(double valor);
}

public class ContaBancaria implements Conta {
    private double saldo;

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            throw new RuntimeException("Saldo insuficiente");
        }
        saldo -= valor;
    }
}

public class ContaPoupanca implements Conta {
    private ContaBancaria contaBancaria = new ContaBancaria();

    @Override
    public void depositar(double valor) {
        contaBancaria.depositar(valor);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 1000) {
            throw new RuntimeException("Não pode sacar mais de 1000 em uma poupança");
        }
        contaBancaria.sacar(valor);
    }
}
```