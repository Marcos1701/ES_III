package ES_III.Atividade_04.Q5_e_Q6;

import java.util.List;

// Versão Inicial
// public class AuditoriaFinanceiraService {
//     public void executar(List<ContaCorrente> contas,
//             List<Investimento> investimentos,
//             List<Transacao> transacoes) {
//         // Auditoria para Conta Corrente
//         for (ContaCorrente conta : contas) {
//             List<Transacao> transacoesInvalidas = conta.getTransacoesInvalidas();

//             for (Transacao transacao : transacoesInvalidas) { // inventando uma lógica qualqer de auditoria
//                 if (transacao.getValor() > 1000) {
//                     System.out.println("Transação inválida: " + transacao);
//                 }
//             }
//         }
//         // Auditoria para Investimento
//         for (Investimento investimento : investimentos) {
//             // Lógica de auditoria para Investimento...
//             if (investimento.getTipo() == TipoInvestimento.RENDA_VARIAVEL) {
//                 if (investimento.getValor() > 10000) {
//                     System.out.println("Investimento de alto risco: " + investimento);
//                     continue;
//                 }
//                 if (investimento.getValor() > 5000) {
//                     System.out.println("Investimento de médio risco: " + investimento);
//                     continue;
//                 }
//                 System.out.println("Investimento de baixo risco: " + investimento);
//                 continue;
//             }
//             if (investimento.getValor() > 100000) {
//                 System.out.println("Investimento de alto risco: " + investimento);
//                 continue;
//             }
//             if (investimento.getValor() > 50000) {
//                 System.out.println("Investimento de médio risco: " + investimento);
//                 continue;
//             }
//             System.out.println("Investimento de baixo risco: " + investimento);
//         }
//         // Auditoria para Transacao
//         for (Transacao transacao : transacoes) {
//             // Lógica de auditoria para Transacao...
//             if (transacao.verificarFraude()) {
//                 System.out.println("Transação fraudulenta: " + transacao);
//             }
//             System.out.println("Transação válida: " + transacao);
//         }
//     }
// }

// Versão Final

public class AuditoriaFinanceiraService {
    public interface Auditavel {
        public boolean executar();
    }

    public void executar(List<Auditavel> auditaveis) {
        for (Auditavel auditavel : auditaveis) {
            if (auditavel.executar()) {
                System.out.println("Auditoria falhou: " + auditavel);
            }
        }
    }
}
