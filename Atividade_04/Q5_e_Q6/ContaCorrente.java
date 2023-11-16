package ES_III.Atividade_04.Q5_e_Q6;

import java.util.List;

class ContaCorrente {
    private String numero;
    private double saldo;
    private List<Transacao> transacoes;
    private ContaCorrenteService servise = new ContaCorrenteService(this);

    public ContaCorrente(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoesInvalidas() {
        return servise.filtrarTransacoesInvalidas();
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
