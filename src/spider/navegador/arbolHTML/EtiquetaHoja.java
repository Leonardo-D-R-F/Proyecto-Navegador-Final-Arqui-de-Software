package spider.navegador.arbolHTML;

import javax.swing.*;

import java.awt.*;

import static spider.navegador.arbolHTML.EtiquetaEnum.*;

public class EtiquetaHoja implements EtiquetaHTML{
    //Nodo sin hijos
    EtiquetaEnum tipoDeEtiqueta;
    String contenido;
    public EtiquetaHoja(EtiquetaEnum etiqueta,String contenido){
        this.tipoDeEtiqueta = etiqueta;
        this.contenido = contenido;
    }
    @Override
    public String toString(){
        return this.contenido;
    }

    @Override
    public JComponent graficar() {
        JComponent componenteGrafico= null;
        if(this.tipoDeEtiqueta == H1) {
            componenteGrafico = new JLabel(this.contenido);
            componenteGrafico.setFont(new Font("Verdana", Font.BOLD, 18));
            componenteGrafico.setBounds(0,0,100,50);
        }if(this.tipoDeEtiqueta == H2) {
            componenteGrafico = new JLabel(this.contenido);
            componenteGrafico.setFont(new Font("Verdana", Font.BOLD, 16));
            componenteGrafico.setBounds(0,0,100,50);
        }if(this.tipoDeEtiqueta == P) {
            componenteGrafico = new JLabel(this.contenido);
            componenteGrafico.setFont(new Font("Verdana", Font.PLAIN, 16));
            componenteGrafico.setBounds(0,0,100,50);
        }if(this.tipoDeEtiqueta == A) {
//            componenteGrafico = new JLabel(this.contenido);
//            componenteGrafico.setForeground(Color.BLUE.darker());
//            componenteGrafico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            componenteGrafico = new JButton(this.contenido);
            componenteGrafico.setBounds(0,0,70,20);
        }
        return componenteGrafico;
    }

    @Override
    public String desplegar() {
        String red="\033[31m";
        String green="\033[32m";
        String blue="\033[34m";
        String yellow="\033[33m";
        String respuesta = "";
        if(this.tipoDeEtiqueta == H1) {
            respuesta = red+this.contenido;
        }if(this.tipoDeEtiqueta == H2) {
            respuesta = green+this.contenido;
        }if(this.tipoDeEtiqueta == P) {
            respuesta = blue+this.contenido;
        }if(this.tipoDeEtiqueta == A) {
            respuesta = yellow+this.contenido;
        }
    return respuesta;
    }
}
