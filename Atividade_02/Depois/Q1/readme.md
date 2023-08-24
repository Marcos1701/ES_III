# Questão 1
Faça uma pesquisa nos seus primeiros repositórios e aponte trechos de
código que você hoje melhoraria e/ou não escreveria mais da mesma forma
e proponha uma melhoria.

### **Itens Alterados e trechos de código para exemplificação:**

- **1° adição de comentários em alguns métodos para melhor entendimento do código.**

    - Antes:
        ```javascript
        private no(valor: T): No<T> {
            return new No<T>(valor)
        }
        ```

    - Depois:

        ```javascript
        /***
         * @param valor: valor a ser inserido no nó
         * @returns retorna um nó com o valor inserido
         */
        private no(valor: T): No<T> {
            return new No<T>(valor)
        }
        ```

- **2° Remoção de elses desnecessários e adição de um return no final do método.**

    - Antes:
        ```javascript
        push(Valor: T): void {
            const no_valor: No<T> = this.no(Valor)
            if (this._inicio == null) {
                this._inicio = no_valor
                this._fim = no_valor
            } else {
                if (this._fim) {
                    this._fim.proximo = no_valor
                    no_valor.anterior = this._fim
                    this._fim = no_valor
                }
            }
        }
        ```

    - Depois:
    
        ```javascript
        push(Valor: T): void {
            const no_valor: No<T> = this.no(Valor)
            if (this._inicio == null) {
                this._inicio = no_valor
                this._fim = no_valor
                return;
            }

            if (this._fim) {
                this._fim.proximo = no_valor
                no_valor.anterior = this._fim
                this._fim = no_valor
            }

        }
        ```
    - **3° Adição de mensagens em alguns erros e alteração de let para const em algumas variáveis, pois não haverá alteração de valor.**

    - Antes:
        ```javascript
        pop(): T {
            if (this._inicio == null) {
                throw new Valor_inexistente("Erro!")
            }
            let aux: No<T> | null = this._inicio
            this._inicio = aux.proximo
            return aux.Valor
        }
        ```

    - Depois:
    
    ```javascript
    pop(): T {
        if (this._inicio == null) {
            throw new Valor_inexistente("Ops, não há nenhum valor para ser removido!!")
        }
        const aux: No<T> | null = this._inicio
        this._inicio = aux.proximo
        return aux.Valor
    }
    ```