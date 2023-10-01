package ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes;

import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.ImpostoDeRenda;
import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes.ValidacaoImpostoDeRenda.Validacao;

public class Validarcpf implements Validacao {
    @Override
    public void validar(ImpostoDeRenda impostoDeRenda) {
        String cpf = impostoDeRenda.getCpfContribuinte();
        if (cpf.length() != 11 || cpf == null || cpf == "") {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

}
