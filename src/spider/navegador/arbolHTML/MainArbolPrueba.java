package spider.navegador.arbolHTML;

import javax.swing.*;

import static spider.navegador.arbolHTML.EtiquetaEnum.*;

public class MainArbolPrueba {
    public static void main(String[] args) {

        EtiquetaHTML p1 = new EtiquetaHoja(P,"Ir a");
        EtiquetaHTML a1 = new EtiquetaHoja(A,"Contenido 1");
        EtiquetaHTML p2 = new EtiquetaHoja(P,"sigue el texto 1");
        EtiquetaHTML p3 = new EtiquetaHoja(P,"Ir a ");
        EtiquetaHTML a2 = new EtiquetaHoja(A,"Contenido 2");
        EtiquetaHTML p4 = new EtiquetaHoja(P,"sigue el texto 2");
        EtiquetaRama body = new EtiquetaRama(BODY);
        body.insertarHijo(p1);
        body.insertarHijo(a1);
        body.insertarHijo(p2);
        body.insertarHijo(p3);
        body.insertarHijo(a2);
        body.insertarHijo(p4);
        EtiquetaRama html = new EtiquetaRama(HTML);
        html.insertarHijo(body);

        //body.graficar();
        //html.graficar();
        JFrame vista = new JFrame();
        vista.setBounds(0, 0, 750, 651);
        vista.setResizable(false);
        vista.setLocationRelativeTo(null);
        vista.setLayout(null);
        vista.setVisible(true);

        vista.add(html.graficar());
        System.out.println(html.desplegar());

    }
}
