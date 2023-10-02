package ES_III.Atividade_04.Q5_e_Q6;

import ES_III.Atividade_04.Q5_e_Q6.AuditoriaFinanceiraService.Auditavel;

enum TipoInvestimento {
    RENDA_FIXA, RENDA_VARIAVEL
}

public class Investimento implements Auditavel {
    private int id;
    private double valor;
    private TipoInvestimento tipo;
    private InvestimentoService service = new InvestimentoService();

    public Investimento(int id, double valor, TipoInvestimento tipo) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getRisco() {
        return service.avaliarRisco(this);
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public boolean executar() {
        // Lógica de auditoria para Investimento...
        if (this.getTipo() == TipoInvestimento.RENDA_VARIAVEL) {
            if (this.getValor() > 10000 || this.getValor() > 5000) {
                return true;
            }
            return false;
        }
        if (this.getValor() > 100000 || this.getValor() > 50000) {
            return true;
        }
        return false;
    }

    public TipoInvestimento getTipo() {
        return tipo;
    }
}
