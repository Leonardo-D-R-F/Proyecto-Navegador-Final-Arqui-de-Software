package spider.navegador.backend;

import spider.navegador.arbolHTML.EtiquetaHTML;

public class MainArbol {
    public static void main(String[] args) {
        CreadorArbol creador = new CreadorArbol();
        String cadena = "<HTML>\n" +
                "<BODY>\n" +
                "<P>Ir a </P><A 1>Contenido 1</A><P> sigue el texto 1.</P>\n" +
                "<P>Ir a </P><A 2>Contenido 2</A><P> sigue el texto 2.</P>\n" +
                "</BODY>\n" +
                "</HTML>\n";
        EtiquetaHTML respuesta = creador.crearDOM(cadena);
        System.out.println( respuesta);
    }
}
