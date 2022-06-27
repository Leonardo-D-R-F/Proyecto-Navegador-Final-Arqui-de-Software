package spider.navegador.backend.etiquetas;

import spider.navegador.backend.NoCompuesto;

import java.util.List;

public class Button extends NoCompuesto {
    int size;
    public Button(String information) {
        super("Button", information);
        this.size=20;
    }
    @Override
    public List<NoCompuesto> getInformationComponent() {
        return null;
    }
}
