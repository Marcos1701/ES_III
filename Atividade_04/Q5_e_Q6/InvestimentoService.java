package ES_III.Atividade_04.Q5_e_Q6;

public class InvestimentoService {

    public String avaliarRisco(Investimento investimento) {
        if (investimento.getTipo() == TipoInvestimento.RENDA_FIXA) {
            if (investimento.getValor() < 50000) {
                return "BAIXO";
            }
            if (investimento.getValor() < 200000) {
                return "MEDIO";
            }
            return "ALTO";
        }
        if (investimento.getValor() < 50000) {
            return "BAIXO";
        }
        if (investimento.getValor() < 200000) {
            return "MEDIO";
        }
        return "ALTO";
    }
}
