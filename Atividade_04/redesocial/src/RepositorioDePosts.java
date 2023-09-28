import java.util.List;

public class RepositorioDePosts {
    private List<Post> posts;
    private ManipulaArquivo saver = new ManipulaArquivo(System.getProperty("user.dir"));

    public void addPost(Post post){
        posts.add(post);
    }
}
