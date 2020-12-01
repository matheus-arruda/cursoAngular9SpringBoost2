package org.matheus.api.apimodulo2.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//Biblioteca Lombok, gera os metodos Get e Set automáticamente na compilação
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column
    private LocalDate dataCadastro;

}
