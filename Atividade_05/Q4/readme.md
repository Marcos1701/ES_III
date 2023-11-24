
### 4. Comente as seguintes frases à luz do ISP:
#### a. “Nenhum cliente deve ser forçado a depender de métodos que ele não usa”;

> Seguindo o contexto, o `cliente` é uma classe que depende de uma interface, e essa interface possui métodos que não são utilizados pela classe. Neste caso, a classe está sendo forçada a implementar métodos que não serão utilizados, o que viola o ISP. </br> </br>

#### b. “Classes não devem ser forçadas a implementar interfaces que não usam”;

> Se uma classe implementa uma interface, ela deve utilizar todos os métodos da interface. Caso contrário, a classe não deve implementar a interface, pois isso apenas infla o código e dificulta a manutenção do sistema, comprometendo também sua legibilidade. </br> </br>
