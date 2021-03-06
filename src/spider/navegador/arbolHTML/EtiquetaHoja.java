package spider.navegador.arbolHTML;

import javax.swing.*;
import java.awt.*;
import static spider.navegador.arbolHTML.EtiquetaEnum.*;

public class EtiquetaHoja implements EtiquetaHTML{
    private final EtiquetaEnum tipoDeEtiqueta;
    private final String contenido;
    public EtiquetaHoja(EtiquetaEnum etiqueta,String contenido){
        this.tipoDeEtiqueta = etiqueta;
        this.contenido = contenido;
    }
    @Override
    public String toString(){
        String etiqueta = this.tipoDeEtiqueta.toString();
        return "<"+etiqueta + ">" + this.contenido+ "</"+etiqueta + ">";
    }
    @Override
    public JComponent graficar() {
        JComponent componenteGrafico= null;
        if(this.tipoDeEtiqueta == H1) {
            componenteGrafico = crearLabel(Font.BOLD,18);
        }if(this.tipoDeEtiqueta == H2) {
            componenteGrafico = crearLabel(Font.BOLD,16);
        }if(this.tipoDeEtiqueta == P) {
            componenteGrafico = crearLabel(Font.PLAIN,16);
        }if(this.tipoDeEtiqueta == A) {
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
            String variable = this.contenido;
            int last = variable.length()-1;
            char link = variable.charAt(last);
            variable="/"+variable+"/";
            variable=variable+" (Ingrese '"+link+"' para ir)";
            respuesta = yellow+variable;
        }
    return respuesta;
    }
    private JLabel crearLabel(int fount,int tamanio ){
        JLabel label = new JLabel(this.contenido);
        label.setFont(new Font("Verdana", fount, tamanio));
        return label;
    }
}
