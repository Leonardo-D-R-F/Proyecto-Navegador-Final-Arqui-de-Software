package spider.navegador.frontend;

import spider.navegador.Internet;
import spider.navegador.ServerNameNotFound;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NavegadorWeb {
    NavegadorUI front;
    Internet internet;
    public NavegadorWeb(Internet internet){
            this.internet = internet;
    }
    public String ejecutarPedido(String url){
        System.out.println("PEDIDO" + url);
        String respuestaPedido = 400+";<HTML><BODY><H1>Bad request</H1></BODY></HTML>";
        if(formatoValido(url)){
            System.out.println("Formato Valido");
            try {
                respuestaPedido= request(url);
            } catch (ServerNameNotFound e) {
                e.printStackTrace();
                respuestaPedido = 500+";<HTML><BODY><H1>Server Error</H1></BODY></HTML>";
            }
        }

        return respuestaPedido;
    }
    public String request(String url) throws ServerNameNotFound {
        int puerto = 8080;
        String respuestaRequest;
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

            respuestaRequest = in.readUTF();
            sc.close();
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
        return respuestaRequest;

    }
    public void run(){
        front = new NavegadorUI(this);
    }
    private boolean formatoValido(String pedido){
        boolean respuesta = false;
        Pattern patron = Pattern.compile("[A-Za-z0-9./;]*");
        Matcher mat = patron.matcher(pedido);
        if(mat.matches()){
            respuesta = true;
        }
        return respuesta;
    }
}
