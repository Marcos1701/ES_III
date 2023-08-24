# Questão 3
Aplique os dois princípios vistos a um código de repositório público.

### **Itens Alterados e trechos de código para exemplificação:**

- <a href = "https://github.com/injulkarnilesh/design-principles/tree/master/TELL_DONT_ASK/example" >Tell, dont’t ask </a>

    - Antes:
        ```java
        // Animal.java
        public class Animal {
            private boolean isHungry;      

            public boolean isHungry() {
                return isHungry;
            }      

            public void feed(Food food) {
                System.out.println("Thanks for the food");
            }
        }
        // Huuman.java
        public class Huuman {
            private Animal animal;

            public void pet(Animal animal){ 
                if (animal.isHungry()) { // se o animal estiver com fome
                    animal.feed(food()); // alimente-o
                }
            }

            private Food food() {
                return null;
            }
        }
        
        ```

    - Depois:
        ```java
        // Animal.java
        public class Animal {
            private boolean isHungry;            

            public void feed(Food food) {
                if (isHungry) { // se o animal estiver com fome, alimente-o
                    System.out.println("Thanks for the food");
                }
            }
        }
        // Huuman.java
        public class Huuman {
                
            public void pet(Animal animal){
                // remove o if e passa a responsabilidade de alimentar o animal para a classe Animal
                animal.feed(food());
            }

            private Food food() {
                return null;
            }

        }

- Fail fast (não encontrei um exemplo de código que pudesse aplicar o princípio, mas vou colocar um exemplo qualquer)

    - Antes:
        ```java
        // Classe
        public class Classe {
            public void metodo() {
                if (condicao) {
                    // faça algo
                } else {
                    // faça outra coisa
                }
            }
        }
        ```
    - Depois:
        ```java
        // Classe
        public class Classe {
            public void metodo() {
                if (condicao) {
                    // faça algo (normalmente é utilizado para lançar uma exceção)
                    return;
                }
                // faça outra coisa
            }
        }
        ```
 