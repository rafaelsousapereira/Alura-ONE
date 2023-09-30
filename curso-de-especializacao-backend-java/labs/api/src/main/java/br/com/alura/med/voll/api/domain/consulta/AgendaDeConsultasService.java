package br.com.alura.med.voll.api.domain.consulta;

import br.com.alura.med.voll.api.domain.exception.ValidacaoException;
import br.com.alura.med.voll.api.domain.medico.Medico;
import br.com.alura.med.voll.api.domain.medico.MedicoRepository;
import br.com.alura.med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultasService {

    @Autowired
    private ConsultaRepopsitory consultaRepopsitory;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {

        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado não existe!");
        }

        if (dados.idMedico() != null && medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do médico informado não existe!");
        }
        
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepopsitory.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória quando o médico não for escolhido");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

}
