package br.com.alura.med.voll.api.domain.consulta.validacoes;

import br.com.alura.med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.alura.med.voll.api.domain.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedência de 30 minutos");
        }
    }
}
