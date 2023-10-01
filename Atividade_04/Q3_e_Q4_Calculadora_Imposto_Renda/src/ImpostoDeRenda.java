package ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src;

import java.util.List;

import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes.ValidacaoImpostoDeRenda;
import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes.ValidarDespesas;
import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes.ValidarRendimentos;
import ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src.Validacoes.Validarcpf;

public class ImpostoDeRenda {
    private String cpfContribuinte;
    private List<Double> rendimentos;
    private List<Double> despesas;

    public ImpostoDeRenda(String cpfContribuinte, List<Double> rendimentos,
            List<Double> despesas) {
        this.cpfContribuinte = cpfContribuinte;
        this.rendimentos = rendimentos;
        this.despesas = despesas;
    }

    public void processar() {

        // Validação inicial (antes da criação da classe de validação
        // if (cpfContribuinte == null || cpfContribuinte.isEmpty() ||
        // cpfContribuinte.length() != 11 ) {
        // throw new IllegalArgumentException("CPF inválido");
        // }

        // for (Double rendimento : rendimentos) {
        // if (rendimento < 0) {
        // throw new IllegalArgumentException("Rendimento não pode ser negativo");
        // }
        // }

        // for (Double despesa : despesas) {
        // if (despesa < 0) {
        // throw new IllegalArgumentException("Despesa não pode ser negativa");
        // }
        // }

        // Validação após a criação da classe de validação
        ValidacaoImpostoDeRenda validacao = new ValidacaoImpostoDeRenda(
                List.of(new Validarcpf(), new ValidarRendimentos(), new ValidarDespesas()));
        validacao.validar(this);

        CalculadoraImpostoDeRenda calculadora = new CalculadoraImpostoDeRenda();
        double impostoDevido = calculadora.calcularImposto(rendimentos, despesas);
        RelatorioImpostoRenda relatorio = new RelatorioImpostoRenda();
        relatorio.gerarRelatorio(this, impostoDevido);
    }

    public String getCpfContribuinte() {
        return cpfContribuinte;
    }

    public List<Double> getRendimentos() {
        return rendimentos;
    }

    public List<Double> getDespesas() {
        return despesas;
    }
}