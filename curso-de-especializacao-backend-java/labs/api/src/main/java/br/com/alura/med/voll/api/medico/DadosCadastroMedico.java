package br.com.alura.med.voll.api.medico;

import br.com.alura.med.voll.api.endereco.DadosEndereco;
import br.com.alura.med.voll.api.enums.Especialidade;

public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
