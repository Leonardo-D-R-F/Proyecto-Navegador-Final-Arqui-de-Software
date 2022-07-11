package spider.navegador.frontend;

import spider.navegador.arbolHTML.*;
import spider.navegador.backend.CreadorArbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActionsBotonesNavegadorGUI implements ActionListener {
    private  final NavegadorUI vista;

    public ActionsBotonesNavegadorGUI(NavegadorUI vista){
        this.vista = vista;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();
        switch (comando){
            case "Buscar" -> {
                String pedido = vista.cuadroDeBusqueda.getText();
                String respuesta = null;
                try {
                    respuesta = vista.navegadorWeb.ejecutarPedido(pedido);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String [] CodigoYRecurso = respuesta.split(";");
                String Codigo = CodigoYRecurso[0];

                String Recurso = CodigoYRecurso[1];
                CreadorArbol creadorArbol = new CreadorArbol();
                System.out.println(Recurso);
                EtiquetaRama arbolHTML = (EtiquetaRama) creadorArbol.crearDOM(Recurso);
                List<JComponent> listaParaGraficar = interpreteGrafico(arbolHTML);
                arbolHTML.graficar();
                vista.despliegueDeInfomracion.removeAll();
                vista.despliegueDeInfomracion.add(arbolHTML.graficar());
                //System.out.println(respuesta);
                vista.despliegueDeInfomracion.setVisible(false);
                vista.despliegueDeInfomracion.setVisible(true);
            }
        }
    }

    public List<JComponent> interpreteGrafico(EtiquetaHTML arbol){
        List<JComponent> jComponents = new ArrayList<>();

        //arbol.

        return jComponents;
    }
}
