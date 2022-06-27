package spider.navegador;

import spider.navegador.frontend.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NavegadorWeb {
    NavegadorUI front;
    public NavegadorWeb(){}
    public void run(){
        front = new NavegadorUI(this);
    }
    public String request(String busqueda){

        System.out.println("Buscando.."+busqueda);
        String pedido = "GET;"+busqueda;
        System.out.println("Pedido:"+pedido);
        String respuesta = ejecutarPedidio(pedido);

        return respuesta;
    }
    private String ejecutarPedidio(String pedido){
//        String[] parts = pedido.split(";",-1);
//        String part1 = parts[0];
//        String part2 = parts[1];
//        String part3 = parts[2];

        String cadena1 = pedido.substring(0,pedido.indexOf(';'));
        String cadena2 = pedido.substring(pedido.indexOf(';')+1);
        System.out.println(cadena1);
        System.out.println(cadena2);
        String host = "127.0.0.1";
        int puerto = 8080;
        String respuestaHTTP = "";

        Socket sc = null;
        try {
            sc = new Socket(host, puerto);
            DataInputStream in;
            DataOutputStream out;

            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(cadena1+";"+cadena2);
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
