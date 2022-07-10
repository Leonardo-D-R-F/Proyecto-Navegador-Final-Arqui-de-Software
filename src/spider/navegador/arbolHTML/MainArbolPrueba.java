package spider.navegador.arbolHTML;

import static spider.navegador.arbolHTML.EtiquetaEnum.*;

public class MainArbolPrueba {
    public static void main(String[] args) {


        EtiquetaHTML p1 = new EtiquetaHoja(P,"Ir a");
        EtiquetaHTML a1 = new EtiquetaHoja(A,"Contenido 1");
        EtiquetaHTML p2 = new EtiquetaHoja(P,"sigue el texto 1");
        EtiquetaHTML p3 = new EtiquetaHoja(P,"Ir a ");
        EtiquetaHTML a2 = new EtiquetaHoja(A,"Contenido 2");
        EtiquetaHTML p4 = new EtiquetaHoja(P,"sigue el texto 2");
        EtiquetaRama body = new EtiquetaRama(BODY);
        body.insertarHijo(p1);
        body.insertarHijo(a1);
        body.insertarHijo(p2);
        body.insertarHijo(p3);
        body.insertarHijo(a2);
        body.insertarHijo(p4);
        EtiquetaRama html = new EtiquetaRama(HTML);
        html.insertarHijo(body);


    }
}
