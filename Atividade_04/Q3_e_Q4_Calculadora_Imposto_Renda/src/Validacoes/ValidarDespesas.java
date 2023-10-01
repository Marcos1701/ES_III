package ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes;

import java.util.List;

import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.ImpostoDeRenda;
import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes.ValidacaoImpostoDeRenda.Validacao;

public class ValidarDespesas
        implements Validacao {
    @Override
    public void validar(ImpostoDeRenda impostoDeRenda) {
        List<Double> despesas = impostoDeRenda.getDespesas();
        for (Double despesa : despesas) {
            if (despesa < 0) {
                throw new IllegalArgumentException("Despesa inválida");
            }
        }
    }

}
