package br.com.alura.med.voll.api.medico;

import br.com.alura.med.voll.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco) {
}
