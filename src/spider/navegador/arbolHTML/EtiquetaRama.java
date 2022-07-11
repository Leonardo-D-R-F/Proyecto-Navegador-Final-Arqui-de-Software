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

            //EtiquetaRama body = (EtiquetaRama) ListaDeEtiqueta.get(0);
            jpanel.setBounds(0,0,1000,600);
            for (int i = 0; i < ListaDeEtiqueta.size(); i++) {
                EtiquetaHTML e = ListaDeEtiqueta.get(i);
                JComponent componente= e.graficar();
                componente.setBounds(posiX,posiY,200,30);
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

        String cadena = "";

        if(this.tipoDeEtiqueta == BODY){

            //EtiquetaRama body = (EtiquetaRama) ListaDeEtiqueta.get(0);

            for (int i = 0; i < ListaDeEtiqueta.size(); i++) {
                EtiquetaHTML e = ListaDeEtiqueta.get(i);
                String componente= e.desplegar();

                cadena = cadena + "\n"+componente;

            }
        }else{
            cadena =  ListaDeEtiqueta.get(0).desplegar();
        }

        return cadena;
    }
}
