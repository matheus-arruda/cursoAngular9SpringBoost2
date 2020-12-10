package org.matheus.api.apimodulo2.rest;

import org.matheus.api.apimodulo2.model.entity.Cliente;
import org.matheus.api.apimodulo2.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
//Trata a url base
@RequestMapping("/api/clientes")
//Permitir tudo no cross '*'
@CrossOrigin("http://localhost:4200")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    //Classe para salvar os clientes
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {

        return repository.save(cliente);

    }

    //Metodo de pesquisa de clientes
    //Passa como parametro o id (/api/clientes/1) por exemplo
    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id) {
        //Se achar o cliente retorno se não retorna uma exceção
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado")
                );
    }

    //Metodo para deletar o cliente
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {

        repository
                .findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
                );

    }

    //Metodo de atualização do cliente
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado) {

        repository
                .findById(id)
                .map(cliente -> {
                    clienteAtualizado.setNome(cliente.getNome());
                    clienteAtualizado.setCpf(cliente.getCpf());
                    return repository.save(clienteAtualizado);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );

    }


}
