
/* object calisthenics don’t use the “else” keyword using polimorfism example*/

abstract class usuario {
    nome: string;
    tipo: string;

    constructor(nome: string, tipo: string) {
        this.nome = nome;
        this.tipo = tipo;
    }
}

class usuario_premium extends usuario {
    constructor(nome: string) {
        super(nome, "premium");
    }
    // ... other methods
}

class usuario_basico extends usuario {
    constructor(nome: string) {
        super(nome, "normal");
    }
    // ... other methods
}

const usuario_p: usuario_premium = new usuario_premium("Jose");
const usuario_n: usuario_basico = new usuario_basico("Maria");

function getPrivileges(user: usuario): void {
    if (user.tipo === "premium") {
        console.log(`O usuario ${user.nome} tem privilegios premium`)
    } else {
        console.log(`O usuario ${user.nome} tem privilegios basicos`)
    }
}

getPrivileges(usuario_p);
getPrivileges(usuario_n);