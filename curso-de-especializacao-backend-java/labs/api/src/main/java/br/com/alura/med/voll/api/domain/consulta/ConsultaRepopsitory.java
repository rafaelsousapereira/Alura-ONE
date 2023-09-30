package br.com.alura.med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepopsitory extends JpaRepository<Consulta, Long> {
}
