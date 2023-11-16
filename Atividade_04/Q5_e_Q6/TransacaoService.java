package ES_III.Atividade_04.Q5_e_Q6;

import ES_III.Atividade_04.Q5_e_Q6.AuditoriaFinanceiraService.Auditavel;

public class TransacaoService implements Auditavel{

    private Transacao transacao;
    TransacaoService(Transacao Transacao){
        this.transacao = Transacao;
    }

    public boolean verificarFraude() {
        if (this.transacao.getTipo() == TipoTransacao.CREDITO) {
            if (this.transacao.getValor() > 1000) {
                return true;
            }
            return false;
        }
        if (this.transacao.getValor() > 500) {
            return true;
        }

        return false;
    }

    public boolean executar() {
        if (this.verificarFraude()) {
            return true;
        }
        return false;
    }

}
