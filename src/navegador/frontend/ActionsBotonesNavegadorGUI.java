package navegador.frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                PedidoHTTP pedido = new PedidoHTTP("GET",vista.cuadroDeBusqueda.getText());
                RespuestaHTTP respuesta = vista.navegadorWeb.request(pedido.getUrl());
                vista.contenido.setText(respuesta.getRecurso());
                System.out.println(respuesta.getCodigoRespuesta());
            }
        }
    }
}
