package navegador.backend;

public abstract class Componente implements Pagina {
    protected final String Etiqueta;
    protected final String Information;

    protected Componente(String etiqueta, String information) {
        this.Etiqueta = etiqueta;
        this.Information = information;
    }
}
