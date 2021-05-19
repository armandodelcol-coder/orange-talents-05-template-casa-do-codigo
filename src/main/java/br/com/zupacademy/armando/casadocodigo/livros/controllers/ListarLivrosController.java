package br.com.zupacademy.armando.casadocodigo.livros.controllers;

import br.com.zupacademy.armando.casadocodigo.livros.reponsedtos.LivrosListaDto;
import br.com.zupacademy.armando.casadocodigo.livros.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListarLivrosController {

    @Autowired
    private LivrosRepository livrosRepository;

    @GetMapping("/livros")
    public Page<LivrosListaDto> listarLivros(Pageable paginacao) {
        return livrosRepository.findAll(paginacao).map(livro -> new LivrosListaDto(livro));
    }

}
