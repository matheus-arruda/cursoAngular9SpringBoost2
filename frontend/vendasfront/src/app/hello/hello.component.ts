import { Component } from '@angular/core'


@Component({
    selector: 'hello',
    //template: ` <h1>Hello World</h1> `
    templateUrl: './hello.component.html'
})
export class HelloComponent {

    nome: string;
    clientes: Cliente[];

    constructor() {
        this.nome = 'Matheus';
        let fulano = new Cliente('Fulano', 30);
        let matheus = new Cliente('Matheus', 28);
        let outro = new Cliente('Mano Brown', 50);

        this.clientes = [fulano, matheus, outro];

    }
}

class Cliente {

    constructor(
        public nome: string,
        public idade: number
    ) {

    }

}