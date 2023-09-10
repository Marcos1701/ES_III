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