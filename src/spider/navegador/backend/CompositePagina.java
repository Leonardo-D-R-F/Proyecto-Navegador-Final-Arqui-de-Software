package spider.navegador.backend;

import java.util.ArrayList;
import java.util.List;

public class CompositePagina implements  Pagina{
    private final List<Componente> lista= new ArrayList<>();
    public CompositePagina(String recurso){

    }
    @Override
    public List<NoCompuesto> getInformationComponent() {
        return null;
    }
}
