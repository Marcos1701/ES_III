package ES_III.Atividade_04.Q5_e_Q6;

enum TipoInvestimento {
    RENDA_FIXA, RENDA_VARIAVEL
}

public class Investimento {
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

    public TipoInvestimento getTipo() {
        return tipo;
    }
}
