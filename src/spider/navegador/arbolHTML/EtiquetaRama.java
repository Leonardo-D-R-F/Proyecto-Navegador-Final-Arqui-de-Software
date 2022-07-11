package spider.navegador.arbolHTML;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static spider.navegador.arbolHTML.EtiquetaEnum.*;

public class EtiquetaRama extends JFrame implements EtiquetaHTML{
     //Nodo con hijos
    EtiquetaEnum tipoDeEtiqueta;
    String contenido;

    List<EtiquetaHTML> ListaDeEtiqueta;
    public EtiquetaRama(EtiquetaEnum etiqueta){
        this.tipoDeEtiqueta = etiqueta;
        this.ListaDeEtiqueta = new ArrayList<>();
    }

    @Override
    public String toString(){
        return contenido;
    }

    @Override
    public JComponent graficar() {
        int posiX = 10;
        int posiY = 30;
        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);
        if(this.tipoDeEtiqueta == BODY){
            jpanel.setBounds(0,0,1000,600);
            for (EtiquetaHTML e : ListaDeEtiqueta) {
                JComponent componente = e.graficar();
                componente.setBounds(posiX, posiY, 350, 30);
                jpanel.add(componente);
                posiY = posiY + 30;
            }
        }else{
            jpanel = (JPanel) ListaDeEtiqueta.get(0).graficar();
        }
        return jpanel;
    }
    public void insertarHijo(EtiquetaHTML hijo){
        ListaDeEtiqueta.add(hijo);
    }
    @Override
    public String desplegar() {
        StringBuilder cadena = new StringBuilder();
        if(this.tipoDeEtiqueta == BODY){
            for (EtiquetaHTML e : ListaDeEtiqueta) {
                String componente = e.desplegar();
                cadena.append("\n").append(componente);
            }
        }else{
            cadena = new StringBuilder(ListaDeEtiqueta.get(0).desplegar());
        }

        return cadena.toString();
    }
}
