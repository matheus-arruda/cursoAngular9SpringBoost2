package org.matheus.api.apimodulo2.model.repository;

import org.matheus.api.apimodulo2.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
