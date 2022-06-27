package spider.navegador.backend.etiquetas;

import spider.navegador.backend.NoCompuesto;

import java.util.List;

public class Title extends NoCompuesto {
    Title(String cadena){
        super("title",cadena);
    }
    @Override
    public List<NoCompuesto> getInformationComponent() {
        return null;
    }
}
