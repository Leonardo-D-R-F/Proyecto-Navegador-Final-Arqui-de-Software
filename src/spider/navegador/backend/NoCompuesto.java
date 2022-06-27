package spider.navegador.backend;

public abstract class NoCompuesto extends Componente{
    protected final String Information;

    protected NoCompuesto(String etiqueta, String information) {
        super(etiqueta);
        this.Information = information;
    }
}
