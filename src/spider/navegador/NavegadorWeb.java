package spider.navegador;

import spider.navegador.frontend.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NavegadorWeb {
    NavegadorUI front;
    Internet internet;
    public NavegadorWeb(){
        try {
            internet = new Internet();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void run(){
        front = new NavegadorUI(this);
    }
    public String request(String busqueda) throws IOException {

        String pedido = "GET;"+busqueda;
        String respuesta = ejecutarPedido(pedido);
        return respuesta;
    }
    private String ejecutarPedido(String pedido) throws IOException {
        // String cadena1 = pedido.substring(0,pedido.indexOf(';'));
        // String cadena2 = pedido.substring(pedido.indexOf(';')+1);

        String [] informacionPedido = pedido.split(";");
        String nombreServidor = informacionPedido[1];
        String ip = internet.resolverNombre(nombreServidor);
        String host = ip;
        int puerto = 8080;
        String respuestaHTTP = "";

        Socket sc = null;
        try {
            sc = new Socket(host, puerto);
            DataInputStream in;
            DataOutputStream out;

            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(pedido);
            in = new DataInputStream(sc.getInputStream());
            String mensaje = in.readUTF();

            respuestaHTTP = mensaje;
            sc.close();
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
        return respuestaHTTP;
    }
}
