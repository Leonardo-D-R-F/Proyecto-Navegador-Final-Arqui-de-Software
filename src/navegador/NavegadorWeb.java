package navegador;

import navegador.frontend.NavegadorUI;
import navegador.frontend.PedidoHTTP;
import navegador.frontend.RespuestaHTTP;

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
    public RespuestaHTTP request(String busqueda){
        RespuestaHTTP respuestaHTTP = new RespuestaHTTP(400,"<h1>Bad request<h1>");
        PedidoHTTP pedidoHTTP = new PedidoHTTP("GET", busqueda);

        respuestaHTTP = ejecutarPedidio(pedidoHTTP);
        return respuestaHTTP;
    }
    private RespuestaHTTP ejecutarPedidio(PedidoHTTP pedidoHTTP){
        String host = "192.168.1.135";
        int puerto = 9999;
        RespuestaHTTP respuestaHTTP = null;

        Socket sc = null;
        try {
            sc = new Socket(host, puerto);
            DataInputStream in;
            DataOutputStream out;

            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(pedidoHTTP.getMetodo());
            out.writeUTF(pedidoHTTP.getUrl());

            in = new DataInputStream(sc.getInputStream());
            String codigo = in.readUTF();
            String mensaje = in.readUTF();

            respuestaHTTP = new RespuestaHTTP(Integer.parseInt(codigo), mensaje);

            sc.close();
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
        return respuestaHTTP;
    }
}
