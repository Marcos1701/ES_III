package ES_III.Atividade_04.Q5_e_Q6;

import ES_III.Atividade_04.Q5_e_Q6.AuditoriaFinanceiraService.Auditavel;

public class InvestimentoService implements Auditavel{

    private Investimento investimento;
    InvestimentoService(Investimento invest){
        this.investimento = invest;
    }

    public String avaliarRisco() {
        if (this.investimento.getTipo() == TipoInvestimento.RENDA_FIXA) {
            if (this.investimento.getValor() < 50000) {
                return "BAIXO";
            }
            if (this.investimento.getValor() < 200000) {
                return "MEDIO";
            }
            return "ALTO";
        }
        if (this.investimento.getValor() < 50000) {
            return "BAIXO";
        }
        if (this.investimento.getValor() < 200000) {
            return "MEDIO";
        }
        return "ALTO";
    }

    public boolean executar() {
        // Lógica de auditoria para Investimento...
        if (this.investimento.getTipo() == TipoInvestimento.RENDA_VARIAVEL && this.investimento.getValor() > 5000) {
            return true;
        }
        if (this.investimento.getValor() > 50000) {
            return true;
        }
        return false;
    }
}
