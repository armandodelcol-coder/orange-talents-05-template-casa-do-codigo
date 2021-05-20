package br.com.zupacademy.armando.casadocodigo.estados.repository;

import br.com.zupacademy.armando.casadocodigo.estados.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findByNomeAndPaisId(String nome, Long paisId);

}
