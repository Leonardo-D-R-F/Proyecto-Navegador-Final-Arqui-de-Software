package spider.navegador.frontend;

import spider.navegador.Internet;
import spider.navegador.ServerNameNotFound;
//import spider.navegador.frontend.Navegador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NavegadorWebVivi {
    private NavegadorConsolaVivi iu;
    private Internet internet;

    public NavegadorWebVivi(Internet internet) {
        this.internet=internet;
        iu = new NavegadorConsolaVivi();
    }

    public void run(){
        try {
            String pedido=iu.run();
            String respuesta = ejecutarPedido(pedido);
            iu.mostrarRespuesta(respuesta);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String ejecutarPedido(String pedido) throws ServerNameNotFound {
        String[] url= pedido.split(";",-1);
        String nombreServidor =url[0];
        String host = internet.resolverNombre(nombreServidor);
        DataInputStream in;
        DataOutputStream out;
        String respuesta="";
        Socket sc = null;
        String pedidoServidor="index.html;";
        if(url.length>1){
            pedidoServidor=url[1];
        }
        try {
            sc = new Socket(host,8080);
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF("GET;"+pedidoServidor);
            in = new DataInputStream(sc.getInputStream());
            respuesta = in.readUTF();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
}