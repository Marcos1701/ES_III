public class Autor {
    private int id;
    private String nome;
    private String email;

    public Autor(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    // Métodos de acesso (getters) aqui.

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
