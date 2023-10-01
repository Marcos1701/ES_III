package ES_III.Atividade_04.Q5_e_Q6;

import java.util.ArrayList;
import java.util.List;

public class ContaCorrenteService {
    public List<Transacao> filtrarTransacoesInvalidas(ContaCorrente contaCorrente) {
        List<Transacao> transacoes = contaCorrente.getTransacoes();
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
            if (transacao.getValor() > 500 || contaCorrente.getSaldo() < transacao.getValor()) {
                transacoesInvalidas.add(transacao);
            }

        }

        return transacoesInvalidas;
    }
}
