package spider.navegador.frontend;

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

                JComponent panel = arbolHTML.graficar();
                buscarLabel((JPanel) panel);
                vista.despliegueDeInfomracion.removeAll();
                vista.despliegueDeInfomracion.add(panel);
                vista.despliegueDeInfomracion.setVisible(false);
                vista.despliegueDeInfomracion.setVisible(true);
                //this.vista.actualizarFront();
            }
            case "Contenido 1" -> {
                System.out.println("Boton contenido 1 funciona");
                String respuesta = null;
                try {
                    respuesta = vista.navegadorWeb.ejecutarPedido("www.leonardoroldan.as;contenido1.html");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String [] CodigoYRecurso = respuesta.split(";");
                String Codigo = CodigoYRecurso[0];

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
            case "Contenido 2" -> {
                System.out.println("Boton contenido 2 funciona");
                String respuesta = null;
                try {
                    respuesta = vista.navegadorWeb.ejecutarPedido("www.leonardoroldan.as;contenido2.html");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                String [] CodigoYRecurso = respuesta.split(";");
                String Codigo = CodigoYRecurso[0];

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
    }
    private void recorrerLista (Component componente){
        try{
            JPanel aux = (JPanel) componente;
            buscarLabel(aux);
        }catch (Exception e){}
        try {
            aniadirListener(componente);
        } catch (Exception e){}
    }
    public void buscarLabel(JPanel panel){
        Component[] lista = panel.getComponents();
        for (int i = 0; i < lista.length; i++) {
            recorrerLista(lista[i]);
        }
    }
     private void aniadirListener(Component componente){
        JButton aux = (JButton) componente;
        aux.addActionListener(this);
     }
}
