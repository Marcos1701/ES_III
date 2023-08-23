# Questão 2
Aplique o princípio “Tell, don’t ask” no próprio método publish da classe
Post do slide 18. Crie um método chamado validate() que encapsula as
validações existentes e chame-o.

### **Itens Alterados e trechos de código para exemplificação:**

- Antes: 
    - Post
        ```java
        // Classe Post
        public class Post {
            //...restante do código omitido
            public void publish() {
                this.setStatus(Status.PUBLISHED);
            }
            //...restante do código omitido
        }
        ```
    - Redes Sociais
        ```java
        // Classe RedesSociais
        public class RedeSocial {
            public static void main(String[] args) {
                Post post = new Post(1, "Hello Word", Status.DRAFT);

                if (post.getStatus() == Status.DRAFT) {
                    if (post.getText().trim().length() > 0) {
                        post.setStatus(Status.PUBLISHED);
                        System.out.println("Successfully published text");
                    } else {
                        throw new RuntimeException("A post must have at least one character");
                    }
                } else {
                    throw new RuntimeException("Only drafts can be posted");
                }
            }
        }
        ```
- Depois:

    - Post
        ```java
        // Classe Post
        public class Post {
            //...restante do código omitido
            public void publish() {
                this.validate();
                this.setStatus(Status.PUBLISHED);
                System.out.println("Successfully published text");
            }

            private void validate() {
                if (this.getStatus() != Status.DRAFT) {
                    throw new RuntimeException("Only drafts can be posted");
                }

                if (this.getText().trim().length() == 0) {
                    throw new RuntimeException("A post must have at least one character");
                }
            }
            //...restante do código omitido
        }
        ```
    - Redes Sociais
        ```java
        // Classe RedesSociais
        public class RedeSocial {
            public static void main(String[] args) {
                Post post = new Post(1, "Hello Word", Status.DRAFT);
                post.publish();
            }
        }
        ```