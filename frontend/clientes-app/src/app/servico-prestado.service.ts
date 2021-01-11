import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { ServicoPrestado } from './servico-prestado/servicoPrestado';
import { ServicoPrestadoBusca } from './servico-prestado/servico-prestado-lista/servicoPrestadoBusca'

@Injectable({
  providedIn: 'root'
})
export class ServicoPrestadoService {

  apiUrl: String = environment.apiUrlBase + '/api/servicos-prestados'

  constructor(private http: HttpClient) { }

  salvar(servicoPrestado: ServicoPrestado) : Observable<ServicoPrestado> {
    return this.http.post<ServicoPrestado>(`${this.apiUrl}`, servicoPrestado)
  }

  buscar(nome:string, mes:number) : Observable<ServicoPrestadoBusca[]> {
   
    const httpParams = new HttpParams().set("nome", nome).set("mes", mes.toString());

    if(!nome) {
      nome = ""
    }


    if(mes) {
      
    }

    const url = this.apiUrl + "?" + httpParams.toString()

    return this.http.get<any>(url);
  }
}
