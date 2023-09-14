# Exercícios 02 - Engenharia de Software III

## 1. Qual a relação que coesão possui com as responsabilidades de uma classe?

<span style="color: grey">

***R- A coesão é a medida pela responsabilidade de uma classe por uma única tarefa.*** <br>
***R- Quanto mais coesa uma classe,indica que ela é responsável por poucas ou uma única tarefa.***<br>
***R- Quanto menos coesa uma classe, indica que ela é responsável por várias tarefas.***

</span>

## 2. Contextualize o conceito de coesão de acordo com as fontes abaixo:
- **a. Livro Clean Code: páginas de 140 a 151;**

<span style="color: grey">

***R- A coesão se dá pela relação entre a quantidade de varáreis presentes em uma classe e quais destas são*** <br>
***R- utilizadas pelos métodos da classe, quanto mais variáveis utilizadas pelos métodos, mais coesa é a classe.*** <br>

</span>

- **b. Artigo Coesão e Acoplamento em Sistemas Orientados a Objetos
disponível em https://www.researchgate.net/publication/261026207_Coesao_e_Acoplamento_em_Sistemas_OO;**

<span style="color: grey">

***R- A coesão se dá pela relação existente entre as responsabilidades de uma determinada classe e de cada um de seus métodos.*** <br>
***R- Uma classe altamente coesa tem responsabilidades e propósitos claros e bem definidos, enquanto uma classe com baixa coesão tem muitas responsabilidades diferentes e pouco relacionadas.*** <br>

</span>

- **c. Livro Orientação a Objetos e SOLID para Ninjas Projetando classes
flexíveis - Casa do Codigo. Princípio da responsabilidade única. Página 5 em diante.**

<span style="color: grey">

***R- uma classe coesa é aquela que possui uma unica responsabilidade.*** <br>
***R- Ou seja, ela não toma conta de mais de um conceito no sistema.*** <br>

</span>

## 3. A classe abaixo possui problemas de coesão:
```java
    public class Cliente {
        private int id;
        private String nome;
        private String endereco;
        private double valorCompra;
        private String numeroConta;
        private double saldo;

        public void exibirInformacoes() {
        // exibir informações do cliente
        }
        public void realizarCompra() {
        // lógica de compra
        }
        public void atualizarSaldo() {
        
        // atualizar saldo do cliente
        }
    }
```
### Refatore o código criando classes Conta, Compra e Cliente de forma que cada uma fique coesa.

```java

    public class Cliente {
        private int id;
        private String nome;
        private String endereco;
        private double valorCompra; // valor total das compras
        private Conta conta;

        // construtor omitido..

        public void exibirInformacoes() {
            // exibir informações do cliente
        }

        public void realizarCompra(Compra compra) {
            // lógica de compra
            this.valorCompra += compra.getValorCompra();
        }
    }

    public class Conta {
        private String numeroConta;
        private double saldo;

        // construtor omitido..

        public void atualizarSaldo() {
            // atualizar saldo do cliente
        }
    }

    public class Compra {
        private double valorCompra;

        // construtor omitido..

        public double getValorCompra(){
            return this.valorCompra;
        }
    }
```

## 4. Classes utilitárias são muito comuns, pois elas agregam funcionalidades usadas por outras classes para centralizar códigos de utilidade geral. A classe abaixo entretanto possui problemas de coesão por ter diferentes aspectos de utilidades.Refatore-a criando classes necessárias de forma a deixar as classes resultantes coesas. Implemente os métodos e além disso, modifique os métodos para acessarem atributos e não usar os parâmetros passados.

```java
    public class Utilitarios {
        public void ordenar(int[] array) {
        // lógica de ordenação
        }
        public void embaralhar(int[] array) {
        // lógica de ordenação
        }

        public String removerEspacos(String texto) {
        // lógica de remoção de espaços
        }
        public String[] quebrarEmPalavras(String texto) {
        // lógica de remoção de espaços
        }
        public double calcularMedia(double[] numeros) {
        // lógica de cálculo de média
        }
        public double calcularDesvioPadrão(double[] numeros) {
        // lógica de cálculo de média
        }

    }
```

R- 
```java

    public class ordena{
        int[] valores;

        public ordena(int[] valores){
            this.valores = valores;
        }

        public void ordenar() {
            // lógica de ordenação
        }
        public void embaralhar() {
            // lógica de ordenação
        }

        public int[] getValores(){
            return this.valores;
        }
    }

    public class removeEspacos{
        String texto;

        public removeEspacos(String texto){
            this.texto = texto;
        }

        public String removerEspacos() {
            // lógica de remoção de espaços
        }
        public String[] quebrarEmPalavras() {
            // lógica de remoção de espaços
        }

        public String getTexto(){
            return this.texto;
        }
    }

    public class calcula{
        double[] numeros;

        public calcula(double[] numeros){
            this.numeros = numeros;
        }

        public double calcularMedia() {
            // lógica de cálculo de média
        }
        public double calcularDesvioPadrão() {
            // lógica de cálculo de média
        }

        public double[] getNumeros(){
            return this.numeros;
        }
    }
```


## 5. Demonstre com Classes os principais tipos de coesão presentes no artigo Acoplamento e Coesão, disponível em https://www.facom.ufu.br/~ronaldooliveira/PDS-2019-1/Aula10-Complemento-AcoplamentoCoesao.pdf

R- 
```java

    // Coesão Lógica

    public class Calculadora {
        public double calcular(double a, double b, String operacao) {
            switch(operacao) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    return a / b;
                default:
                    throw new IllegalArgumentException("Operação inválida");
            }
        }
    }

    // Coesão Temporal

    public class Calculadora {
        private double a;
        private double b;
        private String operacao;

        public void setA(double a) {
            this.a = a;
        }
        public void setB(double b) {
            this.b = b;
        }
        public void setOperacao(String operacao) {
            this.operacao = operacao;
        }
        public double calcular() {
            switch(operacao) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    return a / b;
                default:
                    throw new IllegalArgumentException("Operação inválida");
            }
        }
    }

    // Coesão de Comunicação

    public class Calculadora {
        private double a;
        private double b;
        private String operacao;

        public void setA(double a) {
            this.a = a;
        }
        public void setB(double b) {
            this.b = b;
        }
        public void setOperacao(String operacao) {
            this.operacao = operacao;
        }
        public double calcular() {
            if(operacao.equals("+")) {
                return somar();
            } else if(operacao.equals("-")) {
                return subtrair();
            } else if(operacao.equals("*")) {
                return multiplicar();
            } else if(operacao.equals("/")) {
                return dividir();
            } else {
                throw new IllegalArgumentException("Operação inválida");
            }
        }
        private double somar() {
            return a + b;
        }
        private double subtrair() {
            return a - b;
        }
        private double multiplicar() {
            return a * b;
        }
        private double dividir() {
            return a / b;
        }
    }

    // Coesão funcional

    public class Somar {
        public double somar(double a, double b) {
            return a + b;
        }
    }

    public class Subtracao {
        public double subtrair(double a, double b) {
            return a - b;
        }
    }

    public class Multiplicacao {
        public double multiplicar(double a, double b) {
            return a * b;
        }
    }

    public class Divisao {
        public double dividir(double a, double b) {
            return a / b;
        }
    }

    public class Calculadora {
        private Somar somar;
        private Subtracao subtrair;
        private Multiplicacao multiplicar;
        private Divisao dividir;

        public Calculadora() {
            somar = new Somar();
            subtrair = new Subtracao();
            multiplicar = new Multiplicacao();
            dividir = new Divisao();
        }

        public double somar(double a, double b) {
            return somar.somar(a, b);
        }
        public double subtrair(double a, double b) {
            return subtrair.subtrair(a, b);
        }
        public double multiplicar(double a, double b) {
            return multiplicar.multiplicar(a, b);
        }
        public double dividir(double a, double b) {
            return dividir.dividir(a, b);
        }
    }
    
    /* 
      Resumindo cada tipo de coesão e diferenciando-as:
        * Coesão Lógica: A classe possui uma única responsabilidade, porém, possui vários métodos que realizam a mesma tarefa.
        * Coesão Temporal: A classe possui uma única responsabilidade, porém, possui vários métodos que realizam a mesma tarefa, porém, em momentos diferentes.
        * Coesão de Comunicação: A classe possui uma única responsabilidade, porém, possui vários métodos que realizam a mesma tarefa, porém, de formas diferentes.
        * Coesão Funcional: A classe possui uma única responsabilidade, porém, possui vários métodos que realizam a mesma tarefa, porém, de formas diferentes e com nomes diferentes.
    */
```

## 6. Explique com suas palavras o que é o acoplamento entre classes.

<span style="color: grey">

***R- O acoplamento entre classes ocorre quando uma classe depende de uma ou mais classes para realizar suas tarefas.*** <br>
***R- Quanto mais acoplada uma classe, mais dependente ela é de outra classe.*** <br>

</span>

## 7. Crie e exemplifique uma classse com alto acoplamento e refatore-a para ter o acoplamento reduzido.

R-
```java

    // Alto acoplamento

    public class Calculadora {
        private Somar somar;
        private Subtracao subtrair;
        private Multiplicacao multiplicar;
        private Divisao dividir;

        public Calculadora() {
            somar = new Somar();
            subtrair = new Subtracao();
            multiplicar = new Multiplicacao();
            dividir = new Divisao();
        }

        public double somar(double a, double b) {
            return somar.somar(a, b);
        }
        public double subtrair(double a, double b) {
            return subtrair.subtrair(a, b);
        }
        public double multiplicar(double a, double b) {
            return multiplicar.multiplicar(a, b);
        }
        public double dividir(double a, double b) {
            return dividir.dividir(a, b);
        }
    }

    // Melhorando o acoplamento

    public class Calculadora {
        private Operacao operacao;

        public Calculadora(Operacao operacao) {
            this.operacao = operacao;
        }

        public double calcular(double a, double b) {
            return operacao.calcular(a, b);
        }
    }

    public interface Operacao {
        public double calcular(double a, double b);
    }

    public class Somar implements Operacao {
        public double calcular(double a, double b) {
            return a + b;
        }
    }

    public class Subtracao implements Operacao {
        public double calcular(double a, double b) {
            return a - b;
        }
    }

    public class Multiplicacao implements Operacao {
        public double calcular(double a, double b) {
            return a * b;
        }
    }

    public class Divisao implements Operacao {
        public double calcular(double a, double b) {
            return a / b;
        }
    }
```

## 8. Por que dizemos que o princípio ”Tell, don’t ask” mitiga problema de acoplamento. Demonstre.

<span style="color: grey">

***R- O princípio "Tell, don't ask" mitiga o problema de acoplamento pois ele diz que uma classe*** <br>
***R- não deve perguntar a outra classe sobre seus dados para realizar uma tarefa.*** <br>
***R- Dessa forma, uma classe não precisa saber como a outra classe faz para realizar uma tarefa,*** <br>
***R- ela apenas precisa saber que a outra classe faz aquela tarefa.*** <br>

</span>

## 9. É possivel zerar o acoplamento em um software simples ou complexo? Justifique.

<span style="color: grey">

***R- Não, pois sempre haverá uma classe que depende de outra para realizar uma tarefa.*** <br>
***R- Porém, é possível reduzir o acoplamento entre as classes.*** <br>

</span>

## 10. O encapsulamento também mitiga o acoplamento alto? Discuta o exemplo da pánina 7 do artigo Coesão e Acoplamento em Sistemas Orientados a Objetos.


<span style="color: grey">

***R- Sim, pois o encapsulamento permite que uma classe não tenha acesso aos dados de outra classe,*** <br>
***R- dessa forma, uma classe não precisa saber como a outra classe faz para realizar uma tarefa, ela apenas precisa saber que a outra classe faz aquela tarefa.*** <br>
***R- No exemplo presente no artigo, se a classe Evento tivesse seus atributos encapsulados, as outras classes não precisariam saber como a classe Evento armazena a data,*** <br>
***R- elas apenas precisariam saber que a classe Evento armazena a data.*** <br>

</span>

## 11. A classe abaixo no contexto de uma rede social é fortemente acoplada a Posts e Comentários.

```java
    public class Usuario {
        private List<Post> posts;
        private List<Comentario> comentarios;
        public void criarPost(String conteudo) {
            Post novoPost = new Post(conteudo);
            posts.add(novoPost);
        }
        public void criarPost(String conteudo) {
            Comentario novoComentario = new Comentario(conteudo);
            comentarios.add(novoComentario);
        }

    }
```

### Crie uma interface interface ou classe abstrata chamada Conteudo que seja implementada tanto por Post quanto por outras classes de conteúdo, como Comentario. Dessa forma, a classe Usuario terá uma lista de Conteudo e pode criar e gerenciar qualquer tipo de conteúdo sem conhecer as implementações específicas.

R- 
```java
    abstract public class Conteudo {
        private String conteudo;

        public Conteudo(String conteudo) {
            this.conteudo = conteudo;
        }

        public String getConteudo() {
            return conteudo;
        }
    }

    public class Post extends Conteudo {
        public Post(String conteudo) {
            super(conteudo);
        }
    }

    public class Comentario extends Conteudo {
        public Comentario(String conteudo) {
            super(conteudo);
        }
    }

    public class Usuario {
        private List<Conteudo> conteudos;

        public void addConteudo(Conteudo conteudo) {
            conteudos.add(conteudo);
        }
    }
```

## 12. A classe usuário abaixo está acoplada a si mesmo como uma lista de amigos. Só que nem todos são amigos, podem ser seguidores ou outro tipo de relacionamento. Proponha uma classe intermediária, como Relacionamento, que armazene o usuario que iniciou o relacionamento, o usuario que aceitou, bem como o tipo de relacionamento (enum) entre dois usuários. Refatore a classe usuário para em vez de uma lista de Usuarios, tenha uma lista de relacionamentos.

```java
    public class Usuario {
        private List<Usuario> amigos;
        public void adicionarAmigo(Usuario amigo) {
            amigos.add(amigo);
        }
    }
```

R-
```java
    public enum TipoRelacionamento {
        AMIGO, SEGUIDOR, BLOQUEADO;
    }

    public class Relacionamento {
        private Usuario usuarioSolicitante;
        private Usuario usuarioSolicitado;
        private TipoRelacionamento tipoRelacionamento;

        public Relacionamento(Usuario usuarioSolicitante, Usuario usuarioSolicitado, TipoRelacionamento tipoRelacionamento) {
            this.usuarioSolicitante = usuarioSolicitante;
            this.usuarioSolicitado = usuarioSolicitado;
            this.tipoRelacionamento = tipoRelacionamento;
        }

        public Usuario getSolicitante() {
            return usuarioSolicitante;
        }

        public Usuario getSolicitado() {
            return usuarioSolicitado;
        }

        public TipoRelacionamento getTipoRelacionamento() {
            return tipoRelacionamento;
        }
        // resumo do que a classe faz
        /* 
         * A classe Relacionamento armazena o usuário que solicitou o relacionamento, o usuário que foi solicitado e o tipo de relacionamento entre os dois.
        */
    }

    public class Usuario {
        private List<Relacionamento> relacionamentos;

        public void adicionarRelacionamento(Relacionamento relacionamento) {
            relacionamentos.add(relacionamento);
        }
    }
```


## 13. Verifique seus repositórios e repositórios públicos e identifique pelo menos 1 problemas de coesão de cada categoria acima listada na questão 5, classifique-os e proponha melhorias.

R- 
```java
// coesão lógica
```

## 14. Verifique seus repositórios e repositórios públicos e identifique problemas de acoplamento e proponha melhorias.

