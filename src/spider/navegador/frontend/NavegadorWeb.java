package spider.navegador.frontend;

import spider.navegador.Internet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NavegadorWeb {
    NavegadorUI front;
    Internet internet;
    public NavegadorWeb(Internet internet){
            this.internet = internet;
    }
    public String ejecutarPedido(String url) throws IOException {
        // String cadena1 = pedido.substring(0,pedido.indexOf(';'));
        // String cadena2 = pedido.substring(pedido.indexOf(';')+1);

        String [] informacionUrl = url.split(";");
        String nombreServidor = informacionUrl[0];
        String ip = internet.resolverNombre(nombreServidor);
        String host = ip;
        int puerto = 8080;
        String respuesta = "";

        Socket sc = null;
        try {
            sc = new Socket(host, puerto);
            DataInputStream in;
            DataOutputStream out;

            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF("GET;"+url);
            in = new DataInputStream(sc.getInputStream());
            String mensaje = in.readUTF();

            respuesta = mensaje;
            sc.close();
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
        return respuesta;
    }
    public void run(){
        front = new NavegadorUI(this);
    }
}
