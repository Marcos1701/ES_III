package ES_III.Atividade_04.Q5_e_Q6;

import java.util.List;

public class AuditoriaFinanceiraService {
    public void executar(List<ContaCorrente> contas,
            List<Investimento> investimentos,
            List<Transacao> transacoes) {
        // Auditoria para Conta Corrente
        for (ContaCorrente conta : contas) {
            List<Transacao> transacoesInvalidas = conta.getTransacoesInvalidas();

            for (Transacao transacao : transacoesInvalidas) { // inventando uma lógica qualqer de auditoria
                if (transacao.getValor() > 1000) {
                    System.out.println("Transação inválida: " + transacao);
                }
            }
        }
        // Auditoria para Investimento
        for (Investimento investimento : investimentos) {

            if (investimento.getTipo() == TipoInvestimento.RENDA_FIXA) {
                if (investimento.getValor() < 50000) {
                    System.out.println("Risco BAIXO");
                }
                if (investimento.getValor() < 200000) {
                    System.out.println("Risco MEDIO");
                }
                System.out.println("Risco ALTO");
            }
            if (investimento.getValor() < 50000) {
                System.out.println("Risco BAIXO");
            }
            if (investimento.getValor() < 200000) {
                System.out.println("Risco MEDIO");
            }
            System.out.println("Risco ALTO");
        }
        // Auditoria para Transacao
        for (Transacao transacao : transacoes) {
            // Lógica de auditoria para Transacao...
        }
    }
}
