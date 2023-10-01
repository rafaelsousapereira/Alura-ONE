package br.com.alura.med.voll.api.domain.consulta.validacoes;

import br.com.alura.med.voll.api.domain.consulta.ConsultaRepository;
import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.med.voll.api.domain.exception.ValidacaoException;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

    private ConsultaRepository repository;
    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo hórario");
        }
    }
}
