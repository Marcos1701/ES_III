package ES_III.Atividade_04.Q3_e_Q4_Calculadora_Imposto_Renda.src;

import java.util.List;

public class CalculadoraImpostoDeRenda {
    public double calcularImposto(List<Double> rendimentos, List<Double> despesas) {
        double rendaTotal = rendimentos.stream().mapToDouble(Double::doubleValue).sum();
        double despesaTotal = despesas.stream().mapToDouble(Double::doubleValue).sum();
        double baseCalculo = rendaTotal - despesaTotal;
        if (baseCalculo <= 1903.98) {
            return 0.0;
        }
        if (baseCalculo <= 2826.65) {
            return baseCalculo * 0.075 - 142.80;
        }
        // E assim por diante, para outros intervalos...
        return baseCalculo * 0.275 - 869.36; // Para bc acima de 4664.68
    }
}
