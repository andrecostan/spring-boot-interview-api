package io.github.andrecostan.springbootinterviewapi.domain.repository;

import io.github.andrecostan.springbootinterviewapi.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    List<Cidade> findAllByNome(String nome);

    @Query(
            value = "SELECT * FROM cidade u WHERE u.estado = :nome",
            nativeQuery = true
    )
    List<Cidade> buscarPorEstado(@Param("nome") String nome);

    Optional<Cidade> findByNomeAndAndEstado(String nome, String estado);

}
