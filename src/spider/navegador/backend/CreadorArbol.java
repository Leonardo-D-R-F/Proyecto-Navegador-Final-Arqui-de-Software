package spider.navegador.backend;

import spider.navegador.arbolHTML.EtiquetaEnum;
import spider.navegador.arbolHTML.EtiquetaHTML;
import spider.navegador.arbolHTML.EtiquetaHoja;
import spider.navegador.arbolHTML.EtiquetaRama;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static spider.navegador.arbolHTML.EtiquetaEnum.*;

public class CreadorArbol {
    EtiquetaRama arbol = new EtiquetaRama(HTML);

    public EtiquetaHTML crearDOM(String html){
        //..cuerpo del metodo que procesa el archivo HTML
        parsearHtml(html);
        return this.arbol;
    }
    private void parsearHtml(String html){
       if(formatoHTMLvalido(html)){

           EtiquetaRama body = new EtiquetaRama(BODY);
           System.out.println("formato valido BODY");
           String tagBody = getContenidoDeTag(getContenidoDeTag(html));
           String limpiandoDeEspacios = tagBody.replace("/n","");
           String [] Hojas = limpiandoDeEspacios.split("/",-1);
           System.out.println("Cantidad de hojas:" + Hojas.length);

           for (int i = 0; i < Hojas.length-1; i++) {
               if (contieneEtiquetaHojaDeRedireccion(Hojas[i])){
                   int inicio = Hojas[1].indexOf(">");
                   int fin = Hojas[1].indexOf("<");
                   StringBuilder contenido = new StringBuilder();
                   for (int j = inicio; j < fin; j++) {
                       contenido.append(Hojas[j]);
                   }
               }
               else{
                   int inicio = Hojas[i].indexOf(">");
                   int fin = segundaOcurrenciaDelCaracter(Hojas[i]);
                   String contenido = Hojas[i].substring(inicio+1,fin);
                   if (cadenaConEtiqueta(contenido)){
                       contenido = eliminarEtiqueta(contenido);
                   }
                   EtiquetaEnum etiqueta = identificarEtiqueta(Hojas[i]);
                   EtiquetaHTML element = new EtiquetaHoja(etiqueta,contenido);
                   System.out.println("Etiqueta ; "+etiqueta);
                   System.out.println(contenido);
                   body.insertarHijo(element);
               }
           }
           this.arbol.insertarHijo(body);
       };
    }
    public static void main(String[] args) {
        String documento =
                "<HTML>"+"/n"+
                "<BODY>"+"/n"+
                "<H1>Documento 2</H1><H1>PRUEBA</H1>"+"/n"+
                "<P>Este es el texto de la primera seccion.</P>"+"/n"+
                "<H2>Subseccion</H2>"+"/n"+
                "<P>Contenido de la subseccion 1.</P>"+"/n"+
                "<H2>Subseccion</H2>"+"/n"+
                "<P>Contenido de la subseccion 2</P>"+"/n"+
                "</BODY>"+"/n"+
                "</HTML>";

                CreadorArbol creador = new CreadorArbol();
                EtiquetaHTML prueba = null;
                prueba = creador.crearDOM(documento);
        System.out.println(prueba);

    }
    private String getContenidoDeTag(String html){
        String [] document = html.split("/n");
        List <String> documentList = new ArrayList<>();
        for (int i = 0; i < document.length; i++) {
            System.out.println(document[i]);
            documentList.add(document[i]);
        }
        documentList.remove(0);
        documentList.remove(documentList.size()-1);
        System.out.println(documentList.size());
        String documento = "";
        boolean firstElement = true;
        for (String s : documentList) {
            if(firstElement){
                documento = s;
                firstElement = false;
            }else{
                documento += "/n" + s;
            }
        }

        return  documento;
    }
    private boolean formatoHTMLvalido(String html){
        boolean respuesta = false;
        if(conEtiquetaHTMLValidas(html)){
            if(conEtiquetaBODYValidas(getContenidoDeTag(html))){
                respuesta = true;
            }
            else{
                System.out.println("Formato BODY invalido");
            }
        }
        else{
            System.out.println("Formato HTML invalido");
        }
        //conEtiquetaHTMLValidas(html);
        //System.out.println(html);
        return respuesta;
    }
    private boolean conEtiquetaHTMLValidas(String html){
        boolean valida = false;
        List<String> lista = new ArrayList<>();
        String [] document = html.split(">");
        Collections.addAll(lista, document);

        if(Objects.equals(document[0], "<HTML") && Objects.equals(document[document.length - 1], "/n</HTML")){
            valida = true;
        }
        return valida;
    }
    private boolean conEtiquetaBODYValidas (String html){
        boolean valida = false;
        List<String> lista = new ArrayList<>();
        String [] document = html.split(">");
        Collections.addAll(lista, document);
        if(Objects.equals(document[0], "<BODY") && Objects.equals(document[document.length - 1], "/n</BODY")){
            valida = true;
        }
        return valida;
    }
    private boolean contieneEtiquetaHojaDeRedireccion(String cadena){
        return cadena.contains("<A");
    }
    private EtiquetaEnum identificarEtiqueta(String cadena){
        EtiquetaEnum tipoEtiqueta = null;
        if(cadena.contains("<BODY>")){
            tipoEtiqueta = BODY;
        }
        if(cadena.contains("<HTML>")){
            tipoEtiqueta = HTML;
        }
        if (cadena.contains("<H1>")){
            tipoEtiqueta = H1;
        }
        if(cadena.contains("<H2>")){
            tipoEtiqueta = H2;
        }
        if(cadena.contains("<P>")){
            tipoEtiqueta = P;
        }
        if(cadena.contains("<A>")){
            tipoEtiqueta = A;
        }
        return tipoEtiqueta;
    }
    private int segundaOcurrenciaDelCaracter(String cadena){
        char x = '<';
        int contador = 0;
        int posicion = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i)==x){
                contador++;
                if (contador == 2){
                    posicion = i;
                }
            }
        }
        return posicion;
    }
    private Boolean cadenaConEtiqueta(String cadena){
        return cadena.contains("<") && cadena.contains(">");
    }
    private String eliminarEtiqueta(String cadena){
        String aux = cadena;
        int inicio = cadena.indexOf("<");
        int fin = cadena.indexOf(">");;
        for (int i = inicio; i < fin; i++) {
            String caracter = cadena.charAt(i)+"";
            aux = aux.replace(caracter,"");
        }
        aux = aux.replace(">","");
        return aux;
    }
}
