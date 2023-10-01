package ES_III.Atividade_04.Q1_redeSocial.src;

import java.util.List;

public class RepositorioDePosts {
    private List<Post> posts;
    private ManipulaArquivo saver;

    public RepositorioDePosts(String path) {
        posts = new java.util.ArrayList<Post>();
        saver = new ManipulaArquivo(path);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void removePost(Post post) {
        posts.remove(post);
    }

    public void savePosts() {
        for (Post post : posts) {
            saver.saveToFile(post);
        }
    }

    public void savePost(int id) {
        for (Post post : posts) {
            if (post.getId() == id) {
                saver.saveToFile(post);
                break;
            }
        }
    }

    public List<Post> getPosts() {
        return posts;
    }
}
