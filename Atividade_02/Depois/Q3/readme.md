# Questão 3
Identifique casos em que você aplicaria os princípios “Tell, don’t ask” e “Fail
first” e faça a alteração em um repositório que você tenha usado em
disciplinas anteriores. Documente em um repositório o “antes e depois”.

### **Itens Alterados e trechos de código para exemplificação:**

- Tell, dont’t ask
    - Antes
        ```typescript
        
        ```
    
    - Depois
        ```typescript

        ```

- Fail fist
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
