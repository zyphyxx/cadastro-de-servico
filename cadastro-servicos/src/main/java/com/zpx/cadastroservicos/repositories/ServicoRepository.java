package com.zpx.cadastroservicos.repositories;

import com.zpx.cadastroservicos.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository <Servico, Long> {
}
