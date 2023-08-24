public class RedeSocial {
    public static void main(String[] args) {
        Post post = new Post(1, "Hello Word", Status.DRAFT);
        post.publish();
    }
}