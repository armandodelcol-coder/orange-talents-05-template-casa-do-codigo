package br.com.zupacademy.armando.casadocodigo.clientes.responsedtos;

import br.com.zupacademy.armando.casadocodigo.clientes.models.Cliente;

public class ClienteCadastradoDto {

    private Long id;

    public ClienteCadastradoDto(Cliente cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }

}
