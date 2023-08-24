import { login_invalido, rede_social_inexistente } from "./trata_erros"
import { RedeSocial, Post } from "./redes_sociais"
import { No, repo_redes_sociais } from './repositorio'
export { Usuario, IAutenticavel }

abstract class Usuario_base {

    constructor(
        private _id: number,
        private _nome: string,
        private _login: string,
        private _senha: string
    ) { }


    get id(): number {
        return this._id;
    }

    get nome(): string {
        return this._nome;
    }

    get login(): string {
        return this._login
    }

    get senha(): string {
        return this._senha;
    }

}

/***
 * @description Interface que define os métodos que um usuário deve implementar
 * @interface IAutenticavel
 * @method autenticar
 * */
interface IAutenticavel {
    autenticar(login: string, senha: string): boolean;
}

class Usuario extends Usuario_base implements IAutenticavel {

    private Repositorio_de_redes_sociais: repo_redes_sociais = new repo_redes_sociais()

    constructor(id: number, nome: string, login: string, senha: string) {
        super(id, nome, login, senha);
    }

    consultar_rede_social(id: number): RedeSocial {
        const no: No<RedeSocial> = this.Repositorio_de_redes_sociais.consultar(id)
        const rede_social = no.Valor
        return rede_social
    }

    /*** 
        * @description Retorna um array com os ids das redes sociais já utilizadas pelo usuário
        * @returns {number[]} Array com os ids das redes sociais já utilizadas pelo usuário
     * */
    obter_IDs_de_redes_ja_utilizadas(): number[] {
        return this.Repositorio_de_redes_sociais.ids_ja_utilizados()
    }

    /***
     * @description Insere uma nova rede social no repositório de redes sociais do usuário
     * @param {RedeSocial} rede Rede social a ser inserida
     * @returns {void}
     */
    inserir_rede_social(rede: RedeSocial): void {
        this.Repositorio_de_redes_sociais.inserir(rede)
    }

    /***
     * @description Exclui uma rede social do repositório de redes sociais do usuário
     * @param {number} id_rede Id da rede social a ser excluída
     * @returns {void}
     * */

    excluir_rede_social(id_rede: number): void {
        this.Repositorio_de_redes_sociais.excluir(id_rede)
    }

    exibir_redes_sociais(): void {
        console.log('Redes sociais cadastradas: \n')

        for (
            let rede_social: No<RedeSocial> | null = this.Repositorio_de_redes_sociais.inicio;
            rede_social != null;
            rede_social = rede_social.proximo
        ) {
            console.log(`- Id: ${rede_social.Valor.id} \n- Nome: ${rede_social.Valor.nome} \n- URL: ${rede_social.Valor.url}`)
        }
        console.log("\n")
    }

    qtd_redes(): number {
        return this.Repositorio_de_redes_sociais.qtd
    }

    inserir_novo_post(post: Post, id_rede: number): void {
        this.Repositorio_de_redes_sociais.inserir_novo_post(post, id_rede)
    }

    curtir_post(id_rede: number, id_post: number): void {
        const rede: RedeSocial = this.consultar_rede_social(id_rede)
        rede.curtir_post(id_post)
    }

    alterar_post(novo_post: Post, id_rede: number): void {
        this.Repositorio_de_redes_sociais.alterar_post(id_rede, novo_post)
    }

    excluir_post(id_post: number, id_rede: number): void {
        this.Repositorio_de_redes_sociais.excluir_post(id_post, id_rede);
    }

    /***
        * @description Retorna um valor boleano, indicando se o login e senha informados são válidos
        * @param {string} login Login a ser autenticado
        * @param {string} senha Senha a ser autenticada
        * @returns {boolean} Retorna true se o login e senha informados são válidos, e false caso contrário
        * @throws {login_invalido} Se o login ou senha informados forem inválidos
        * */
    autenticar(login: string, senha: string): boolean {
        if (login != this.login || senha != this.senha) {
            throw new login_invalido("Erro, login inválido!!!")
        }
        return true;
    }
}