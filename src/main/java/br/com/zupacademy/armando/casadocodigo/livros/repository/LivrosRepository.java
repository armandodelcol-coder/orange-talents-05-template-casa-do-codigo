package br.com.zupacademy.armando.casadocodigo.livros.repository;

import br.com.zupacademy.armando.casadocodigo.livros.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<Livro, Long> {
}
