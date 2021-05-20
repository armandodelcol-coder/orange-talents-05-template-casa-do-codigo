package br.com.zupacademy.armando.casadocodigo.livros.controllers;

import br.com.zupacademy.armando.casadocodigo.livros.models.Livro;
import br.com.zupacademy.armando.casadocodigo.livros.reponsedtos.DetalhesLivroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class DetalhesLivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/livros/{id}")
    public ResponseEntity<DetalhesLivroDto> buscarPorId(@PathVariable Long id) {
        Livro livro = entityManager.find(Livro.class, id);
        if (livro == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new DetalhesLivroDto(livro));
    }

}
