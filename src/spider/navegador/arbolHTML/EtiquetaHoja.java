package spider.navegador.arbolHTML;

import javax.swing.*;

public class EtiquetaHoja implements EtiquetaHTML{
    //Nodo sin hijos
    EtiquetaEnum tipoDeEtiqueta;
    String contenido;
    public EtiquetaHoja(EtiquetaEnum etiqueta,String contenido){
        this.tipoDeEtiqueta = etiqueta;
        this.contenido = contenido;
    }
    public EtiquetaEnum getTipoEtiquetaHTML() {
        return tipoDeEtiqueta;
    }
    @Override
    public String toString(){
        return this.contenido;
    }

    @Override
    public JComponent graficar() {
        return null;
    }

    @Override
    public String desplegar() {
        return null;
    }
}
