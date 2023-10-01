package br.com.alura.med.voll.api.domain.consulta.validacoes;

import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.med.voll.api.domain.exception.ValidacaoException;
import br.com.alura.med.voll.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
//      dados do medico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluído");
        }
    }

}
