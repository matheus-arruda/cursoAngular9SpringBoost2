import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";

import { Cliente } from '../cliente'
import { ClientesService } from '../../clientes.service'

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {

  cliente: Cliente;
  success: boolean = false;
  errors: String[];
  id: number;

  constructor
  (private service: ClientesService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { 

      this.cliente = new Cliente();
  }

  ngOnInit(): void {
    let params
    params = this.activatedRoute.params

    if(params && params.value && params.value.id) {
      this.id = params.value.id;
      this.service.getClienteById(this.id).subscribe(response => this.cliente = response, errorResponse => this.cliente = new Cliente())
    }
  }


  onSubmit() {
    this.service
    .salvar(this.cliente)
    .subscribe( 
      //Resposta Ok
      response => {
      this.success = true;
      this.errors = null;
      //Envia a resposta para a classe Cliente e popula na tela
      this.cliente = response;
    }, 
      //Erro
      errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;
      })
  }

  voltarParaListagem() {
    this.router.navigate(['/clientes-lista'])
  }

}
