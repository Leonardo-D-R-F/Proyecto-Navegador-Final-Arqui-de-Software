package spider.navegador.frontend;

import spider.navegador.Internet;
import spider.navegador.ServerNameNotFound;

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
    public String ejecutarPedido(String url) throws ServerNameNotFound {
        int puerto = 8080;
        String respuesta;
        String [] informacionUrl = url.split(";",-1);
        String nombreServidor = informacionUrl[0];
        String host = internet.resolverNombre(nombreServidor);
        String pedidoRecurso = ";";
        if(informacionUrl.length>1){
            pedidoRecurso = informacionUrl[1];
        }
        Socket sc;
        try {
            sc = new Socket(host, puerto);
            DataInputStream in;
            DataOutputStream out;

            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF("GET;"+pedidoRecurso);
            in = new DataInputStream(sc.getInputStream());

            respuesta = in.readUTF();
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
