package ES_III.Atividade_04.Q5_e_Q6;

import java.util.List;

import ES_III.Atividade_04.Q5_e_Q6.AuditoriaFinanceiraService.Auditavel;

class ContaCorrente implements Auditavel {
    private String numero;
    private double saldo;
    private List<Transacao> transacoes;
    private ContaCorrenteService servise = new ContaCorrenteService();

    public ContaCorrente(String numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoesInvalidas() {
        return servise.filtrarTransacoesInvalidas(this);
    }

    public boolean executar() {
        List<Transacao> transacoesInvalidas = this.getTransacoesInvalidas();
        for (Transacao transacao : transacoesInvalidas) { // inventando uma lógica qualqer de auditoria
            if (transacao.getValor() > 1000) {
                return true;
            }
        }
        return false;
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
