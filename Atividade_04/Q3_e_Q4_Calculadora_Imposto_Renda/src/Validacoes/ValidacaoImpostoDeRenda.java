package ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes;

import java.util.List;

import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.ImpostoDeRenda;

// Classe antes da refatoração
// public class ValidacaoImpostoDeRenda {
//     public void validar(String cpfContribuinte, List<Double> rendimentos,
//             List<Double> despesas) {
//         if (cpfContribuinte == null || cpfContribuinte.isEmpty()) {
//             throw new IllegalArgumentException("CPF do contribuinte não pode ser nulo ou vazio");
//         }
//         if (rendimentos == null || rendimentos.isEmpty()) {
//             throw new IllegalArgumentException("Lista de rendimentos não pode ser nula ou vazia");
//         }
//         if (despesas == null || despesas.isEmpty()) {
//             throw new IllegalArgumentException("Lista de despesas não pode ser nula ou vazia");
//         }
//     }
// }

// Classe após a refatoração
public class ValidacaoImpostoDeRenda {
    public interface Validacao {
        public void validar(ImpostoDeRenda impostoDeRenda);
    }

    private List<Validacao> validacoes;

    public ValidacaoImpostoDeRenda(List<Validacao> validacoes) {
        this.validacoes = validacoes;
    }

    public void validar(ImpostoDeRenda impostoDeRenda) {
        for (Validacao validacao : validacoes) {
            validacao.validar(impostoDeRenda);
        }
    }
}
