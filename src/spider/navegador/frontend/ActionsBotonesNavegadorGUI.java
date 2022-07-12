package spider.navegador.frontend;

import spider.navegador.ServerNameNotFound;
import spider.navegador.arbolHTML.*;
import spider.navegador.backend.CreadorArbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionsBotonesNavegadorGUI implements ActionListener {
    private  final NavegadorUI vista;

    public ActionsBotonesNavegadorGUI(NavegadorUI vista){
        this.vista = vista;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();
        switch (comando){
            case "Buscar" -> desplegarPedido(vista.cuadroDeBusqueda.getText());
            case "Contenido 1" -> {
                String [] nombreServidor = vista.cuadroDeBusqueda.getText().split(";");
                desplegarPedido(nombreServidor[0]+";"+"contenido1.html");
            }
            case "Contenido 2" -> {
                String [] nombreServidor = vista.cuadroDeBusqueda.getText().split(";");
                desplegarPedido(nombreServidor[0]+";"+"contenido2.html");
            }
        }
    }
    private void recorrerLista(Component componente){
        try{
            JPanel aux = (JPanel) componente;
            buscarLabel(aux);
        }catch (Exception ignored){}
        try {
            aniadirActionListener(componente);
        } catch (Exception ignored){}
    }
    public void buscarLabel(JPanel panel){
        Component[] lista = panel.getComponents();
        for (Component component : lista) {
            recorrerLista(component);
        }
    }
     private void aniadirActionListener(Component componente){
        JButton aux = (JButton) componente;
        aux.addActionListener(this);
     }
     private void desplegarPedido(String pedidoNavegador){
         String respuesta = null;
         try {
             respuesta = vista.navegadorWeb.ejecutarPedido(pedidoNavegador);
         } catch (ServerNameNotFound ex) {
             ex.printStackTrace();
         }
         assert respuesta != null;
         String [] CodigoYRecurso = respuesta.split(";");
         String Recurso = CodigoYRecurso[1];
         CreadorArbol creadorArbol = new CreadorArbol();
         System.out.println(Recurso);
         EtiquetaRama arbolHTML = (EtiquetaRama) creadorArbol.crearDOM(Recurso);
         JComponent panel = arbolHTML.graficar();
         buscarLabel((JPanel) panel);
         vista.despliegueDeInfomracion.removeAll();
         vista.despliegueDeInfomracion.add(panel);
         vista.despliegueDeInfomracion.setVisible(false);
         vista.despliegueDeInfomracion.setVisible(true);
     }
}
