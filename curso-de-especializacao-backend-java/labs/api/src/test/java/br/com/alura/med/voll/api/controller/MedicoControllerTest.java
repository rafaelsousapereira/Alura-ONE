package br.com.alura.med.voll.api.controller;

import br.com.alura.med.voll.api.domain.endereco.DadosEndereco;
import br.com.alura.med.voll.api.domain.endereco.Endereco;
import br.com.alura.med.voll.api.domain.medico.DadosCadastroMedico;
import br.com.alura.med.voll.api.domain.medico.DadosDetalhamentoMedico;
import br.com.alura.med.voll.api.domain.medico.Medico;
import br.com.alura.med.voll.api.domain.medico.MedicoRepository;
import br.com.alura.med.voll.api.enums.Especialidade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroMedico> dadosCadastroMedicoJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoMedico> dadosDetalhamentoMedicoJson;

    @MockBean
    private MedicoRepository repository;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void cadastrar_cenario1() throws Exception {
        var response = mvc.perform(post("/medicos").contentType(MediaType.APPLICATION_JSON).content("{}")).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {
        var dadosDoMedico = new DadosCadastroMedico("Medico", "medico@voll.med", "61999999999", "123456", Especialidade.CARDIOLOGIA, dadosEndereco());
        when(repository.save(any())).thenReturn(new Medico(dadosDoMedico));

        var response = mvc.perform(post("/medicos").contentType(MediaType.APPLICATION_JSON).content(dadosCadastroMedicoJson.write(dadosDoMedico).getJson())).andReturn().getResponse();
        var dadosDetalhamentoMedico = new DadosDetalhamentoMedico(null, dadosDoMedico.nome(), dadosDoMedico.email(), dadosDoMedico.telefone(), dadosDoMedico.crm(), dadosDoMedico.especialidade(), new Endereco(dadosDoMedico.endereco()));
        var jsonEsperado = dadosDetalhamentoMedicoJson.write(dadosDetalhamentoMedico).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }
}