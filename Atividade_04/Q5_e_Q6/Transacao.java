package ES_III.Atividade_04.Q5_e_Q6;

import ES_III.Atividade_04.Q5_e_Q6.AuditoriaFinanceiraService.Auditavel;

enum TipoTransacao {
    CREDITO, DEBITO
}

public class Transacao implements Auditavel {
    private int id;
    private double valor;
    private TipoTransacao tipo;
    private TransacaoService service = new TransacaoService();

    public Transacao(int id, double valor, TipoTransacao tipo) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
    }

    public boolean verificarFraude() {
        return service.verificarFraude(this);
    }

    public boolean executar() {
        if (this.verificarFraude()) {
            return true;
        }
        return false;
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