# Questão 5
Aplique em códigos de repositórios públicos ou seus o princípio “nunca usar
else” do Object Calisthenics com as duas vertentes:
a. Early return;
b. Polimorfismo

### **Itens Alterados e trechos de código para exemplificação:**

- Early return:
    - Antes
        ```typescript
        // src: https://github.com/bdrupieski/GameOfLifeTypeScript/blob/master/GameOfLifeObelisk.ts
        private cellAliveAt(x, y): number {
            if (x >= 0 && x < this.boardWidth &&
                y >= 0 && y < this.boardHeight) {
                return this.boardState[(y * this.boardWidth) + x];
            } else {
                return 0;
            }
        }
        ```
    - Depois
        ```typescript
        // src: https://github.com/bdrupieski/GameOfLifeTypeScript/blob/master/GameOfLifeObelisk.ts
        private cellAliveAt(x, y): number {
            if (x >= 0 && x < this.boardWidth &&
                y >= 0 && y < this.boardHeight) {
                return this.boardState[(y * this.boardWidth) + x];
            }
                return 0;
        }
        ```
- Polimorfismo:
    - Antes
        ```typescript
        // src:
        
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
        ```
    - Depois
    
        ```typescript
        // src:

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
        ```