
/* object calisthenics don’t use the “else” keyword using polimorfism example*/

abstract class Abs_usuario {
    nome: string;
    tipo: string;

    constructor(nome: string, tipo: string) {
        this.nome = nome;
        this.tipo = tipo;
    }

    abstract getPrivileges(): void;
}

class usuario_prem extends Abs_usuario {
    constructor(nome: string) {
        super(nome, "premium");
    }

    getPrivileges(): void {
        console.log(`O usuario ${this.nome} tem privilegios premium`)
    }
    // ... other methods
}

class usuario_basic extends Abs_usuario {
    constructor(nome: string) {
        super(nome, "normal");
    }

    getPrivileges(): void {
        console.log(`O usuario ${this.nome} tem privilegios basicos`)
    }
    // ... other methods
}

const usuario_pr: usuario_prem = new usuario_prem("Jose");
const usuario_b: usuario_basic = new usuario_basic("Maria");

usuario_b.getPrivileges();
usuario_pr.getPrivileges();