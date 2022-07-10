package spider.navegador.arbolHTML;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EtiquetaRama implements EtiquetaHTML{
     //Nodo con hijos
    EtiquetaEnum tipoDeEtiqueta;
    String contenido;
    List<EtiquetaHTML> ListaDeEtiqueta;
    public EtiquetaRama(EtiquetaEnum etiqueta){
        this.tipoDeEtiqueta = etiqueta;
        this.ListaDeEtiqueta = new ArrayList<>();
    }
//    public void agregarAListaEtiquetas(EtiquetaHTML etiquetaHtml){
//        ListaDeEtiqueta.add(etiquetaHtml);
//    }
//
//    public EtiquetaEnum getTipoEtiquetaHTML() {
//        return tipoDeEtiqueta;
//    }
//
//    public void insertarHijos(EtiquetaHTML hijo){
//
//    }
    @Override
    public String toString(){
        return contenido;
    }

    @Override
    public JComponent graficar() {
        return null;
    }
    public void insertarHijo(EtiquetaHTML hijo){
        ListaDeEtiqueta.add(hijo);
    }
    @Override
    public String desplegar() {
        return null;
    }
}
