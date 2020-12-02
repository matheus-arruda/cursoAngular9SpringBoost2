package org.matheus.api.apimodulo2.rest;

import org.matheus.api.apimodulo2.model.entity.Cliente;
import org.matheus.api.apimodulo2.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
//Trata a url base
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    //Classe para salvar os clientes
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente) {

        return repository.save(cliente);

    }

    //Classe de pesquisa de clientes
    //Passa como parametro o id (/api/clientes/1) por exemplo
    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id) {
        //Se achar o cliente retorno se não retorna uma exceção
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }
}
