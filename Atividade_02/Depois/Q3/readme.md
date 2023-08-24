# Questão 3
Identifique casos em que você aplicaria os princípios “Tell, don’t ask” e “Fail
first” e faça a alteração em um repositório que você tenha usado em
disciplinas anteriores. Documente em um repositório o “antes e depois”.

### **Itens Alterados e trechos de código para exemplificação:**

- Tell, dont’t ask
    - Antes
        ```typescript
        //redes_sociais : ../../Antes/Q1/redes_sociais.ts
        //... restante do código omitido
        class RedeSocial{
            //... restante do código omitido
            
            inserir_post(post: Post): void {
                this.posts.inserir(post)
                this._id_post++;
            }
            //... restante do código omitido
        }
        
        // Aplicação : ../../Antes/Q1/aplicacao.ts
        // ... restante do código omitido
        function opcoes_para_rede_social(): void {
            //... restante do código omitido
            if (op_rede_social == 1) {
                repo_aplicacao.inserir_post(id_rede_social, criar_post(rede_social))
                console.log("\nPost criado com sucesso!!\n")
            }
            //... restante do código omitido
        }

        function criar_post(rede: RedeSocial): Post {
            if (!repo_aplicacao.logado) { throw new usuario_inexistente("Erro, você não está logado!!") }

            let texto: string = coletar_valor_nao_nulo("Digite o texto do seu post: ")
            while(texto.length > 100){
                console.log("Erro, o texto inserido é muito grande!!")
                texto = coletar_valor_nao_nulo("Digite o texto do seu post: ")
            }
            let legenda: string = coletar_valor_nao_nulo("Digite a legenda do seu post: ")
            while(legenda.length > 200){
                console.log("Erro, a legenda inserida é muito grande!!")
                legenda = coletar_valor_nao_nulo("Digite a legenda do seu post: ")
            }

            const post: Post = new Post(rede.id_post, texto, repo_aplicacao.usuario_logado, legenda, new Date())
            return post
        } 
        ```
    
    - Depois
        ```typescript
        //... restante do código omitido
        class RedeSocial{
            //... restante do código omitido
            
            inserir_post(post: Post): void {
                if(post.texto.length > 100 || post.legenda.length > 200){
                    throw new TamanhoExcedidoError("Erro, um dos valores inseridos é inválido!!");
                }
                this.posts.inserir(post)
                this._id_post++;
            }
            //... restante do código omitido
        }
        
        // Aplicação
        // ... restante do código omitido
        function opcoes_para_rede_social(): void {
            //... restante do código omitido
            if (op_rede_social == 1) {
                repo_aplicacao.inserir_post(id_rede_social, criar_post(rede_social))
                console.log("\nPost criado com sucesso!!\n")
            }
            //... restante do código omitido
        }

        function criar_post(rede: RedeSocial): Post {
            if (!repo_aplicacao.logado) { throw new usuario_inexistente("Erro, você não está logado!!") }

            const texto: string = coletar_valor_nao_nulo("Digite o texto do seu post: ")
            
            const legenda: string = coletar_valor_nao_nulo("Digite a legenda do seu post: ")

            const post: Post = new Post(rede.id_post, texto, repo_aplicacao.usuario_logado, legenda, new Date())
            return post
        }

        ```

- Fail first
    - Antes
        ```typescript
        async function Login_via_Google(req: Request, res: Response) {
            // ...restante do código omitido
            
            if (email && name) {
                //...restante do código omitido
                if (result.rows.length == 0) {
                    client.query("SELECT ADICIONAR_USUARIO($1, $2, $3, $4, $5)", [id, name, email, 1, token], (err, result) => {
                    if (err) {
                        console.log(err);
                        return res.status(500).json({ error: "Erro ao acessar o banco de dados" });
                    }
                    return res.status(200).json({ token: token });
                });
            } else if (result.rows[0].id_metodo_login == 1) {
                return res.status(200).json({ token: token });
            } else {
                return res.status(500).json({ error: "Email já cadastrado via Email" });
            }
            } else {
                return res.status(500).json({ error: "Erro ao acessar o Google" });
            }
        }
        ```
    - Depois:
        ```typescript
            async function Login_via_Google(req: Request, res: Response) {
                // ...restante do código omitido
                
                if (!email || !name) {
                    return res.status(500).json({ error: "Erro ao acessar o Google" });
                }
                //...restante do código omitido
                    
                if(result.rows.length > 0 && result.rows[0].id_metodo_login != 1){
                    return res.status(500).json({ error: "Email já cadastrado" });
                }
                if (result.rows.length == 0) {
                    client.query("SELECT ADICIONAR_USUARIO($1, $2, $3, $4, $5)", [id, name, email, 1, token], (err, result) => {
                        if (err) {
                           console.log(err);
                          return res.status(500).json({ error: "Erro ao acessar o banco de dados" });
                        }
                        return res.status(200).json({ token: token });
                    });
                }
                if (result.rows[0].id_metodo_login == 1) {
                    return res.status(200).json({ token: token });
                }
            }
            ```