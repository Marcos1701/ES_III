package ES_III.Atividade_04.Q1_redeSocial.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ES_III.Atividade_04.Q1_redeSocial.src.Autor;
import ES_III.Atividade_04.Q1_redeSocial.src.ManipulaArquivo;
import ES_III.Atividade_04.Q1_redeSocial.src.Post;
import ES_III.Atividade_04.Q1_redeSocial.src.RepositorioDePosts;

public class teste {
    @Test
    public void RepositorioTest() {
        Autor autor = new Autor(1, "João", "joao123321@gmail.com");
        assertEquals(autor.getId(), 1, "Id não é igual");
        assertEquals(autor.getNome(), "João", "Nome não é igual");
        assertEquals(autor.getEmail(), "joao123321@gmail.com", "Email não é igual");
        Post post = new Post(1, "Conteúdo do post 1", autor, new java.util.Date());
        assertEquals(post.getId(), 1, "Id não é igual");
        assertEquals(post.getTexto(), "Conteúdo do post 1", "Texto não é igual");
        assertEquals(post.getAutor(), autor, "Autor não é igual");
        assertEquals(post.getQuantidadeDeLikes(), 0, "Quantidade de likes não é igual");

        RepositorioDePosts repositorio = new RepositorioDePosts(System.getProperty("user.dir") + "/src/posts.txt");
        repositorio.addPost(post);
        assertEquals(repositorio.getPosts().get(0), post, "Post não é igual");
        repositorio.savePost(1);

        ManipulaArquivo manipulaArquivo = new ManipulaArquivo(System.getProperty("user.dir") + "/src/poststest.txt");
        manipulaArquivo.saveToFile(post);

        // para pegar o que foi salvo no arquivo
        try {
            Scanner scanner = new Scanner(System.getProperty("user.dir") + "/src/poststest.txt");
            Scanner scanner2 = new Scanner(System.getProperty("user.dir") + "/src/posts.txt");
            scanner.nextLine(); // pula a primeira linha, pois ela apresenta o caminho do arquivo
            scanner2.nextLine();
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String linha2 = scanner2.nextLine();
                assertEquals(linha, linha2, "Linha não é igual");
            }
            scanner.close();
            scanner2.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo");
        }
    }

}
