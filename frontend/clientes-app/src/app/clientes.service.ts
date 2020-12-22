import { Injectable } from '@angular/core';
import {  HttpClient } from '@angular/common/http'

import { Cliente } from './clientes/cliente';
import { Observable } from 'rxjs';

import { environment } from '../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  apiUrl: String = environment.apiUrlBase + '/api/clientes'

  constructor(private http: HttpClient) { 
    
  }

  salvar(cliente: Cliente) : Observable<Cliente> {
    return this.http.post<Cliente>(`${this.apiUrl}`, cliente)
  }

  getClientes() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${this.apiUrl}`);
  }

  getClienteById(id: number) : Observable<Cliente>{
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  deletar(cliente:Cliente) : Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${cliente.id}`);
  }
  
}
