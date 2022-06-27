package spider.navegador.backend.etiquetas;


import spider.navegador.backend.NoCompuesto;

import java.util.ArrayList;
import java.util.List;

public class Img extends NoCompuesto {
    int alto;
    int ancho;
    public Img(String enlace,int alto ,int  ancho){
        super("h1",enlace);
        this.alto=alto;
        this.ancho=ancho;
    }
    @Override
    public String toString() {
        return this.Etiqueta+";"+this.Information+";"+this.alto+";"+this.ancho ;
    }
    public List<NoCompuesto> getInformationComponent() {
        List<NoCompuesto> lista = new ArrayList<>();
        lista.add(this);
        return lista;
    }
}