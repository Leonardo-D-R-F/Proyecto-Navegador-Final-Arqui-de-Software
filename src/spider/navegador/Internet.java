package spider.navegador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Internet {
    HashMap <String, String> map = new HashMap<String, String>();

    public  Internet() throws IOException {
       leerArchivosDns();
    }

    private void leerArchivosDns() throws IOException {
        String fileName = "./dns.txt";
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String [] nombreServidorYIP = line.split(";");
            String nombreServidor = nombreServidorYIP[0];
            String ip = nombreServidorYIP[1];
            registrar(nombreServidor,ip);
        }
    }
    public void registrar(String nombre,String ip) throws IOException {
        String nombreServidor= map.get(nombre);
        if (nombreServidor == null){
            map.put(nombre,ip);
            registrarEnTextDNS(nombre,ip);
            System.out.println("Registrado correctamente: "+ nombre);
        }
        else{
            System.out.println("Ya se encuentra registrado: " + nombre);
        }
        map.put(nombre,ip);
    }
    public String resolverNombre(String nombre){
        String ip = map.get(nombre);
        return ip;
    }
    private void registrarEnTextDNS(String nombre,String ip) throws IOException {
        if(!existeRegistroEnText(nombre)){
            String filePath = "./dns.txt" ;
            FileWriter fw = new FileWriter(filePath, true);
            String lineToAppend = nombre+";"+ip+"\n";
            fw.write(lineToAppend);
            fw.close();
        }
    }
    private boolean existeRegistroEnText(String nombre) throws FileNotFoundException {
        boolean respuesta = false;
        Scanner scan = new Scanner(new File("./dns.txt"));
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String [] nombreServidorYIp = line.split(";");
            String nombreServidor = nombreServidorYIp[0];
            if (Objects.equals(nombre, nombreServidor)){
                respuesta = true;
            }
        }
        return respuesta;
    }
}
