package spider.navegador.arbolHTML;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static spider.navegador.arbolHTML.EtiquetaEnum.*;

public class EtiquetaRama extends JFrame implements EtiquetaHTML{
    private final EtiquetaEnum tipoDeEtiqueta;
    private final List<EtiquetaHTML> ListaDeEtiqueta;
    public EtiquetaRama(EtiquetaEnum etiqueta){
        this.tipoDeEtiqueta = etiqueta;
        this.ListaDeEtiqueta = new ArrayList<>();
    }
    @Override
    public String toString(){
        String html = this.tipoDeEtiqueta.toString() + "\n";

        EtiquetaHTML e;
        for(Iterator<EtiquetaHTML> var2 = this.ListaDeEtiqueta.iterator();
            var2.hasNext();
            html = html + e.toString() + "\n") {
            e = var2.next();
        }
        return html;
    }
    @Override
    public JComponent graficar() {
        JPanel jpanel = null;
        if(this.tipoDeEtiqueta == BODY){
           jpanel = graficarPanelDeHijos(ListaDeEtiqueta);
        }if(this.tipoDeEtiqueta!=BODY){
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
            cadena = desplegarhHijos(this.ListaDeEtiqueta);
        }if(this.tipoDeEtiqueta != BODY){
            cadena = new StringBuilder(ListaDeEtiqueta.get(0).desplegar());
        }
        return cadena.toString();
    }
    public StringBuilder desplegarhHijos(List<EtiquetaHTML> ListaDeEtiquetas){
        StringBuilder cadenaDeDespliegue = new StringBuilder();
        for (EtiquetaHTML e : ListaDeEtiquetas) {
            String componente = e.desplegar();
            cadenaDeDespliegue.append("\n").append(componente);
        }
        return cadenaDeDespliegue;
    }
    private JPanel graficarPanelDeHijos(List<EtiquetaHTML> listaDehijos){
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
        jpanel.setBounds(0,0,1000,600);
        int posiX = 10;
        int posiY = 30;
        for (EtiquetaHTML e : listaDehijos) {
            JComponent componente = e.graficar();
            componente.setBounds(posiX, posiY, 350, 30);
            jpanel.add(componente);
            posiY = posiY + 30;
        }
        return jpanel;
    }

}
