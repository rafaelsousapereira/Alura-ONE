package br.com.alura.med.voll.api.domain.consulta.validacoes;

import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.med.voll.api.domain.exception.ValidacaoException;
import br.com.alura.med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;
    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());

        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
