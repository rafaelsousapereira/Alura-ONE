package br.com.alura.med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(

        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo) {
}
