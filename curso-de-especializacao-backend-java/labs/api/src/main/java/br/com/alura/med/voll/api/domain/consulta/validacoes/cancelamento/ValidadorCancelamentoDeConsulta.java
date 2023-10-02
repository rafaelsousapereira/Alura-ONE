package br.com.alura.med.voll.api.domain.consulta.validacoes.cancelamento;

import br.com.alura.med.voll.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);
}
