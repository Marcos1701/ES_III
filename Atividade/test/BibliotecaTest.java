import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {
    
    @Test
    public void testGetNome() {
        Biblioteca b = new Biblioteca(0, "Sei lá");
        assertEquals("Sei lá", b.getNome());
    }

    @Test
    public void testGetNameLivro() {
        Livro livro = new Livro(0, new autor(0, "Jose"), "Sei la", "editora 1", 2023);
        assertEquals("Sei la", livro.getTitulo());
    }
}
