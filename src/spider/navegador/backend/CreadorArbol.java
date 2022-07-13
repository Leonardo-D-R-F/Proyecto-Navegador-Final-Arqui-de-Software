package spider.navegador.backend;

import spider.navegador.arbolHTML.EtiquetaEnum;
import spider.navegador.arbolHTML.EtiquetaHTML;
import spider.navegador.arbolHTML.EtiquetaHoja;
import spider.navegador.arbolHTML.EtiquetaRama;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static spider.navegador.arbolHTML.EtiquetaEnum.*;

public class CreadorArbol {
    EtiquetaRama arbol = new EtiquetaRama(HTML);

    public EtiquetaHTML crearDOM(String html){
        String htmlprocesado2 = html.replace("\n","");
        parsearHtml(htmlprocesado2);
        return this.arbol;
    }
    private void parsearHtml(String html){
        String htmlprocesado = html.replace("\n","");
        htmlprocesado = htmlprocesado.replace(" ","");
       if(formatoDocumentoValido(htmlprocesado)){
           EtiquetaRama body = new EtiquetaRama(BODY);
           String tagBody = getContenidoDeTag(getContenidoDeTag(html));
           String limpiandoDeEspacios = tagBody.replace("\n","");
           String [] Hojas = limpiandoDeEspacios.split("/",-1);

           for (int i = 0; i < Hojas.length-1; i++) {
                   int inicio = Hojas[i].indexOf(">");
                   int fin = posicionSegundaOcurrenciaDelCaracter(Hojas[i]);
                   String contenido = Hojas[i].substring(inicio+1,fin);
                   if (cadenaConEtiqueta(contenido)){
                       contenido = eliminarEtiqueta(contenido);
                   }
                   EtiquetaEnum etiqueta = identificarEtiqueta(Hojas[i]);
                   EtiquetaHTML element = new EtiquetaHoja(etiqueta,contenido);
                   body.insertarHijo(element);
               //}
           }
           this.arbol.insertarHijo(body);
       }
    }
    private String getContenidoDeTag(String html){
        String [] document = html.split(">");
        List <String> documentList = new ArrayList<>();
        for (int i = 0; i < document.length ; i++) {
                documentList.add(document[i]+">");
        }
        documentList.remove(0);
        documentList.remove(documentList.size()-1);
        StringBuilder documento = new StringBuilder();
        boolean firstElement = true;
        for (String s : documentList) {
            if(firstElement){
                documento = new StringBuilder(s);
                firstElement = false;
            }else{
                documento.append("\n").append(s);
            }
        }

        return documento.toString();
    }
    private boolean formatoDocumentoValido(String html){
        boolean respuesta = false;
        if(conEtiquetaHTMLValidas(html)){
            if(conEtiquetaBODYValidas(getContenidoDeTag(html))){
                respuesta = true;
            }
        }
        return respuesta;
    }
    private boolean conEtiquetaHTMLValidas(String html){
        boolean valida = false;
        String [] document = html.split(">",-1);
        if(Objects.equals(document[0], "<HTML") && Objects.equals(document[document.length - 2], "</HTML")){
            valida = true;
        }
        return valida;
    }
    private boolean conEtiquetaBODYValidas (String html){
        boolean valida = false;
        String [] document = html.split(">");
        if(Objects.equals(document[0], "<BODY") && Objects.equals(document[document.length - 1], "\n</BODY")){
            valida = true;
        }
        return valida;
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
        if(cadena.contains("<A")){
            tipoEtiqueta = A;
        }
        return tipoEtiqueta;
    }
    private int posicionSegundaOcurrenciaDelCaracter(String cadena){
        int contador = 0;
        int posicion = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i)=='<'){
                contador++;
            }
            if (contador == 2){
                posicion = i;
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
        int fin = cadena.indexOf(">");
        for (int i = inicio; i < fin; i++) {
            String caracter = cadena.charAt(i)+"";
            aux = aux.replaceFirst(caracter,"");
        }
        aux = aux.replace(">","");
        return aux;
    }
}
