package spider.navegador.backend.etiquetas;

import spider.navegador.backend.NoCompuesto;

import java.util.ArrayList;
import java.util.List;

public class H1 extends NoCompuesto {
    int size;
    public H1(String Informacion){
        super("h1",Informacion);
        this.size=30;
    }
    @Override
    public String toString() {
        return this.Etiqueta+";"+this.Information+";"+size;
    }
    public List<NoCompuesto> getInformationComponent() {
        List<NoCompuesto> lista = new ArrayList<>();
        lista.add(this);
        return lista;
    }
}
