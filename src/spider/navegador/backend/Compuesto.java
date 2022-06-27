package spider.navegador.backend;

import java.util.List;

public abstract class Compuesto extends Componente {
    protected final String Information;
    public List<Componente> lista;

    protected Compuesto(String etiqueta, String information) {
        super(etiqueta);
        this.Information = information;
    }

}
