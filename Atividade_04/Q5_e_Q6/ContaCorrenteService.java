package ES_III.Atividade_04.Q5_e_Q6;

import java.util.ArrayList;
import java.util.List;

import ES_III.Atividade_04.Q5_e_Q6.AuditoriaFinanceiraService.Auditavel;

public class ContaCorrenteService implements Auditavel{

    ContaCorrente conta;

    ContaCorrenteService(ContaCorrente contaCorrente){
        this.conta = contaCorrente;
    }

    public List<Transacao> filtrarTransacoesInvalidas() {
        List<Transacao> transacoes = this.conta.getTransacoes();
        List<Transacao> transacoesInvalidas = new ArrayList<Transacao>();

        for (Transacao transacao : transacoes) {

            if (transacao.getValor() < 0) {
                transacoesInvalidas.add(transacao);
                continue;
            }
            if (transacao.getTipo() == TipoTransacao.CREDITO) {
                if (transacao.getValor() > 1000) {
                    transacoesInvalidas.add(transacao);
                }
                continue;
            }
            if (transacao.getValor() > 500 || this.conta.getSaldo() < transacao.getValor()) {
                transacoesInvalidas.add(transacao);
            }

        }

        return transacoesInvalidas;
    }

    public boolean executar() {
        List<Transacao> transacoesInvalidas = this.conta.getTransacoesInvalidas();
        for (Transacao transacao : transacoesInvalidas) { // inventando uma lógica qualqer de auditoria
            if (transacao.getValor() > 1000) {
                return true;
            }
        }
        return false;
    }
}
