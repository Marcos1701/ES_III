package ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src;

public class RelatorioImpostoRenda {
    public void gerarRelatorio(ImpostoDeRenda impostoDeRenda, double impostoDevido) {
        System.out.println("CPF: " + impostoDeRenda.getCpfContribuinte());
        System.out.println("Rendimentos: " + impostoDeRenda.getRendimentos());
        System.out.println("Despesas: " + impostoDeRenda.getDespesas());
        System.out.println("Imposto devido: " + impostoDevido);
    }
}
