## Princípio de Substituição de Liskov

1. **Por que o uso do nome próprio Liskov?** </br>
            
       O nome "Liskov" vem de Barbara Liskov, a cientista da computação que introduziu o princípio na conferência "Data abstraction" em 1987.

2. **Qual a principal imagem relacionada ao princípio e qual a explicação sobre ela?** </br>
       
       A imagem mais comum associada ao Princípio de Substituição de Liskov é a de um quadrado e um retângulo. Embora um quadrado possa parecer um retângulo, se usarmos um quadrado onde um retângulo é esperado (de acordo com a herança), podemos encontrar problemas devido às diferenças nas propriedades dessas formas geométricas. Por exemplo, se um retângulo tem um método "setAltura" e um método "setLargura", um quadrado não pode ter esses métodos, pois a altura e a largura de um quadrado são sempre iguais. Portanto, se usarmos um quadrado onde um retângulo é esperado, podemos encontrar problemas devido às diferenças nas propriedades dessas formas geométricas.

3. **Cite um exemplo onde a herança pode ser usada de forma conveniente, porém deixa uma impressão de que está sendo mal aplicada.** </br>
   
       Um exemplo seria uma classe "Pássaro" com um método "voar". Se criarmos uma subclasse "Pinguim" a partir de "Pássaro", teríamos um problema, pois pinguins não voam e, portanto, não deveriam herdar o método "voar".

4. **Cite um exemplo onde a herança pode ser usada de forma conveniente, porém deixa futuras expansões comprometidas ou com problemas de design.** </br>
       
       Seguindo o exemplo acima, se quisermos adicionar mais pássaros que não voam (como avestruzes), a herança da classe "Pássaro" se torna problemática e teríamos que criar uma nova classe "Pássaro Não-Voador".

5. **Nos exemplos que você citou, a composição seria mais aplicável? Refaça-os.** </br>
   
       Sim, a composição seria mais aplicável. Em vez de ter "Pinguim" herdar de "Pássaro", poderíamos ter uma classe "Animal" com subclasses "Pássaro Voador" e "Pássaro Não-Voador", ou poderíamos ter uma classe "Habilidade de Voo" que poderia ser composta em classes de animais conforme necessário.
