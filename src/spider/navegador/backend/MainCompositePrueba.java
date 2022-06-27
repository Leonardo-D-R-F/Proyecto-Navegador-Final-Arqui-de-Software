package spider.navegador.backend;

import spider.navegador.backend.etiquetas.*;

public class MainCompositePrueba {
    public static void main(String[] args) {

        Html documentoHtml = new Html();
        Body body = new Body();
        H1 titulo1 = new H1("Titulo 1");
        H2 parrafo1 = new H2("Parrafo 1 de prueba");
        H1 titulo2= new H1("Titulo 2");
        H2 parrafo2 = new H2("Parrafo 2 de prueba");
        Img imagen = new Img("'http://www.imagenes.com/4324452'",20,30);

        body.addChild(titulo1);
        body.addChild(parrafo1);
        body.addChild(titulo2);
        body.addChild(parrafo2);
        body.addChild(imagen);
        documentoHtml.addBody(body);
        documentoHtml.updateTitle("Spider");

        System.out.println(titulo1);
        System.out.println(parrafo2);
        System.out.println(imagen);
    }
}
