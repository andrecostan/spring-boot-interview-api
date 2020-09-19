package io.github.andrecostan.springbootinterviewapi.domain.repository;

import io.github.andrecostan.springbootinterviewapi.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findAllByNome(String nome);

}
