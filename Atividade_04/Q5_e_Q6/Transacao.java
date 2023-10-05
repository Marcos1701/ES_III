package ES_III.Atividade_04.Q5_e_Q6;


enum TipoTransacao {
    CREDITO, DEBITO
}

public class Transacao{
    private int id;
    private double valor;
    private TipoTransacao tipo;
    private TransacaoService service = new TransacaoService(this);

    public Transacao(int id, double valor, TipoTransacao tipo) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
    }

    public boolean verificarFraude() {
        return service.verificarFraude();
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;

    }

    public TipoTransacao getTipo() {
        return tipo;
    }
}
