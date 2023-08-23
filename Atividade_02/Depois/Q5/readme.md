# Questão 5
Identifique casos em que você aplicaria os princípios “Tell, don’t ask” e “Fail
first” e faça a alteração em um repositório que você tenha usado em
disciplinas anteriores. Documente em um repositório o “antes e depois”.

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