package spider.navegador.frontend;

import spider.navegador.arbolHTML.EtiquetaHTML;
import spider.navegador.backend.CreadorArbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NavegadorConsolaVivi {
    private CreadorArbol creadorArbol;

    public NavegadorConsolaVivi() {
        creadorArbol=new CreadorArbol();
    }

    public String run() throws IOException {
        String rt ="\u001B[0m";
        String gray ="\033[47m";
        String red="\033[31m";
        String sun="\033[43m";
        String green="\033[32m";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(sun+"==========================================================================="+rt);
        System.out.println("\t"+gray+"\t"+"\033[30m                    _   _     _   _  _                         "+rt);
        System.out.println("\t"+gray+"\t"+"\033[30m                   |_  |_| | | | |_ |_|                        "+rt);
        System.out.println("\t"+gray+"\t"+"\033[30m                    _| |   | |_| |_ | \\                        "+rt);
        System.out.println("\t"+gray+"\t"+"\033[31m             Bienvenido a Spider Browser v0.01                 "+rt);
        System.out.println(sun+"==========================================================================="+rt);
        promptUser();
        System.out.print(green+"Buscar... "+rt);
        String cmd = br.readLine();
        System.out.println("===========================================================================");
        System.out.println(gray+"   "+cmd+"   "+rt);
        System.out.println("---------------------------------------------------------------------------");
        return cmd;
    }

    private void promptUser() {
        String rt ="\u001B[0m";
        System.out.print("(Opcional ingrese "+"'\033[31mcerrar"+rt+"' si desea cerrar el navegador.)\n");
    }

    public void mostrarRespuesta(String respuesta) {
        if(respuesta.contains("\n"))
            respuesta = respuesta.replace("\n", "");
        String[] datos = respuesta.split(";",-1);
        String html=datos[1];
        EtiquetaHTML etiquetaHTML= creadorArbol.crearDOM(html);
        if(!etiquetaHTML.toString().contains("A")){
            System.out.print(etiquetaHTML.desplegar());
        }
        if(etiquetaHTML.toString().contains("A")){
            System.out.println("|  Presione 1 o 2");
            System.out.print(etiquetaHTML.desplegar());
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    private void cerrar() {
        System.out.println("Cerrando...");
    }
}