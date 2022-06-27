package spider.navegador.backend;

public abstract class Componente implements Pagina{
    protected final String Etiqueta;

    protected Componente(String etiqueta) {
        Etiqueta = etiqueta;
    }
}
