import java.util.HashMap;
import java.util.Map;

public class Livro {
    private String titulo;
    private Pessoa autor;
    private Genero genero;
    private Map<String, String> caracteristicas;

    public Livro(String titulo, Pessoa autor, Genero genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.caracteristicas = new HashMap<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Map<String, String> getCaracteristicas() {
        return caracteristicas;
    }

    public void adicionarCaracteristica(String chave, String valor) {
        this.caracteristicas.put(chave, valor);
    }

    public void removerCaracteristica(String chave) {
        this.caracteristicas.remove(chave);
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor.getNomeCompleto() + ", Gênero: " + genero.getNome();
    }
}
