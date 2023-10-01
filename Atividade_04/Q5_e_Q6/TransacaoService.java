package ES_III.Atividade_04.Q5_e_Q6;

public class TransacaoService {

    public boolean verificarFraude(Transacao transacao) {
        if (transacao.getTipo() == TipoTransacao.CREDITO) {
            if (transacao.getValor() > 1000) {
                return true;
            }
            return false;
        }
        if (transacao.getValor() > 500) {
            return true;
        }

        return false;
    }

}
