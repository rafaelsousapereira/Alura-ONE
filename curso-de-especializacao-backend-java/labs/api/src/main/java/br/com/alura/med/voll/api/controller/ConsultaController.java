package br.com.alura.med.voll.api.controller;

import br.com.alura.med.voll.api.domain.consulta.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultasService agendaDeConsultasService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsulta> agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        agendaDeConsultasService.agendar(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<DadosCancelamentoConsulta> cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agendaDeConsultasService.cancelar(dados);

        return ResponseEntity.noContent().build();
    }
}
