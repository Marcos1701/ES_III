### Proponha uma solução que evite o uso da herança no código abaixo:


```java
public class Conta {
    private double saldo;
    private String numeroConta;

    public Conta(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    // Outros métodos relevantes...
}

public class ContaCliente extends Conta {
    private String nome;
    private String cpf;
    private String endereco;

    public ContaCliente(String numeroConta, double saldoInicial, String nome, String cpf, String endereco) {
        super(numeroConta, saldoInicial);
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Métodos específicos do cliente...
}
```

## Possível Solução:

```java
public class Conta {
    private double saldo;
    private String numeroConta;

    public Conta(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    // Outros métodos relevantes...
}

public class Cliente {
    public Conta conta;
    private String nome;
    private String cpf;
    private String endereco;

    public Cliente(String numeroConta, double saldoInicial, String nome, String cpf, String endereco) {
        this.conta = new Conta(numeroConta,  saldoInicial);
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    // Métodos específicos do cliente...
}
```