package spider.navegador.backend.etiquetas;

import spider.navegador.backend.Componente;
import spider.navegador.backend.Compuesto;
import spider.navegador.backend.NoCompuesto;

import java.util.ArrayList;
import java.util.List;

public class Body extends Compuesto {
    public Body(){
        super("dody","");
        this.lista = new ArrayList<>();
    }
    public void addChild(Componente componente){
        this.lista.add(componente);
    }

    @Override
    public List<NoCompuesto> getInformationComponent() {
        return null;
    }
}
