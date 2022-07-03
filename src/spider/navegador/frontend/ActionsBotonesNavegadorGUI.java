package spider.navegador.frontend;

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
                    respuesta = vista.navegadorWeb.request(pedido);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                String [] CodigoYRecurso = respuesta.split(";");
                String Codigo = CodigoYRecurso[0];
                String Recurso = CodigoYRecurso[1];
                vista.contenido.setText(Recurso);
                System.out.println(respuesta);
            }
        }
    }
}
