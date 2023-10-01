package ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes;

import java.util.List;

import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.ImpostoDeRenda;
import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes.ValidacaoImpostoDeRenda.Validacao;

public class ValidarRendimentos
        implements Validacao {
    @Override
    public void validar(ImpostoDeRenda impostoDeRenda) {
        List<Double> rendimentos = impostoDeRenda.getRendimentos();
        for (Double rendimento : rendimentos) {
            if (rendimento < 0) {
                throw new IllegalArgumentException("Rendimento inválido");
            }
        }
    }

}
